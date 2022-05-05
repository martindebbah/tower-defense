package com.towerdefense.view.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

import com.towerdefense.model.Player;
import com.towerdefense.model.Score;
import com.towerdefense.view.Window;

public class HighScore extends JPanel {

    private File file;
    private List<Score> scores;
    private Window window;

    public HighScore(Player player, Window window) {
        this.file = new File("highscore.txt");
        this.scores = new ArrayList<Score>();
        setLayout(new GridLayout(0, 1));
        setOpaque(false);
        this.window = window;

        if (!file.exists())
            create();

        read();
        if (player != null)
            add(player);

        display();
    }

    // Ecrit les scores dans le fichier
    public void write() {
        if (scores.size() == 0) {
            reset();
            return;
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("");
            for (Score score : scores) {
                writer.append(score.getName() + ":");
                writer.append(score.getScore() + ":");
                writer.append(score.getMode() + ":");
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Importe les score à partir du fichier
    public void read() {
        scores = new ArrayList<Score>();
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter(""); // Pour lire caractère par caractère

            String name, score, mode;

            while (true) {
                name = "";
                score = "";
                mode = "";

                while (sc.hasNext()) {
                    char c = sc.next().charAt(0);
                    if (c == ':')
                        break;
                    name += c;
                }
                while (sc.hasNext()) {
                    char c = sc.next().charAt(0);
                    if (c == ':')
                        break;
                    score += c;
                }
                while (sc.hasNext()) {
                    char c = sc.next().charAt(0);
                    if (c == ':')
                        break;
                    mode += c;
                }

                if (!name.equals("") && !score.equals("") && !mode.equals(""))
                    scores.add(new Score(name, Integer.valueOf(score), mode));

                if (!sc.hasNext())
                    break;
            }

            sc.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Ajoute le score d'un joueur au meilleurs scores
    public void add(Player p) {
        Score score = new Score(p.toString(), p.getScore(), p.getMode());

        boolean b = false; // Si le joueur a refait le même score -> true
        int i = 0; // L'indice où on ajoute le score les meilleurs au début
        for (Score s : scores) {
            if (score.compareTo(s) == -1)
                i++;
            if (score.compareTo(s) == 0)
                b = true;
        }
        if (!b) // Si le joueur n'a pas refait le même score on l'ajoute
            scores.add(i, score);

        if (scores.size() > 10) { // Si la liste comporte plus de 10 scores on enlève le dernier
            List<Score> newScores = new ArrayList<Score>();
            for (int x = 0; x < 10; x++)
                newScores.add(scores.get(x));
            scores = newScores;
        }

        // On met à jour le fichier
        write();
    }

    // Supprime tous les scores enregistrés
    public void reset() {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(":");
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        read();
    }

    // Créer le fichier
    public void create() {
        try {
            file.createNewFile();
        }catch (IOException e) {
            e.printStackTrace();
        }
        reset();
    }

    public void display() {
        removeAll();
        int n = 1;
        for (Score score : scores) {
            String m = "";
            switch (score.getMode()) {
                case "easy": m = "(facile)";
                    break;
                case "difficult": m = "(difficile)";
                    break;
                case "infiny": m = "(infini)";
                    break;
            }
            add(new JLabel(n++ + ": " + score.getName() + " " + score.getScore() + " pts " + m));
        }
        window.refresh();
    }

    public int getNbScores() {
        return scores.size();
    }
    
}
