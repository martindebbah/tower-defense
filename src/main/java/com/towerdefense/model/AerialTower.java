package com.towerdefense.model;

public class AerialTower extends Tower {

    private boolean Aerial; // pour faciliter l'insertion sur une autre dimension du plateau
                            // et éviter la confusion, ça peut être utile

                            // Au lieu de faire un boolean juste le fait d'être de type AerialTower permet
                            // d'éviter la confusion
    public AerialTower(){
        super();
        this.Aerial = true;
    }

    @Override
    public String toString() {
        return "Tour aérienne de base";
    }

    @Override
    public int getAttackSpeed() {
        return 1;
    }

    @Override
    public int getPrice() {
        return 10;
    } // plus cher ou pas ?

    @Override
    public int getDamage() {
        return 0;
    }

    public int getRange() {
        return 5;
    }

}
