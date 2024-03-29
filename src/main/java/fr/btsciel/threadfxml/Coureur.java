package fr.btsciel.threadfxml;

import javafx.scene.shape.Circle;
import javafx.scene.control.Label;

public class Coureur {
    public Circle getCorps() {
        return corps;
    }

    public Label getTemps() {
        return temps;
    }

    public String getName() {
        return name;
    }

    private String name;
    private Circle corps;
    private Label temps;
    private Chronometre chronometre;

    public Chronometre getChronometre() {
        return chronometre;
    }
    public Coureur(String name, Circle corps, Label temps, Chronometre chronometre) {
        this.name = name;
        this.corps = corps;
        this.temps = temps;
        this.chronometre = chronometre;
    }
}