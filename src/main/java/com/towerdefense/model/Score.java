package com.towerdefense.model;

public class Score implements Comparable<Score> {

    private String name;
    private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Score o) {
        if (o == null)
            return 0;

        // Ordre de grandeur des entiers
        if (score < o.getScore())
            return -1;
        if (score > o.getScore())
            return 1;

        // Si les deux joueurs ont le mêmes score on compare leurs noms -> ordre lexicographique inversé
        // (a > f > z) pour que l'ordre lexicographique soit respecté lors de l'affichage des scores
        for (int i = 0; i < Math.min(name.length(), o.getName().length()); i++) {
            if (name.charAt(i) < o.getName().charAt(i))
                return 1;
            if (name.charAt(i) > o.getName().charAt(i))
                return -1;
        }
        if (name.length() < o.getName().length())
            return 1;
        if (name.length() > o.getName().length())
            return -1;

        // Les noms sont égaux (c'est le même joueur) et il a fait le même score
        return 0;
    }
    
}
