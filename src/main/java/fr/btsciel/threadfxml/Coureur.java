package fr.btsciel.threadfxml;

import javafx.scene.shape.Circle;
import javafx.scene.control.Label;

public class Coureur {
    String name;
    Circle corps;
    Label temps;
    Chronometre chronometre;

    public Coureur(String name, Circle corps, Label temps, Chronometre chronometre) {
        this.name = name;
        this.corps = corps;
        this.temps = temps;
        this.chronometre = chronometre;
    }
}