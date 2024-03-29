package fr.btsciel.threadfxml;

import javafx.scene.control.Label;

public class Chronometre {
    double depart;
    double timeAfficher;

    public Chronometre() {
        this.depart = System.currentTimeMillis();
    }
    public void afficherTemps(Label timeField) {
        timeAfficher = System.currentTimeMillis() - depart;
        timeAfficher = timeAfficher / 1000;
        timeField.setText(Double.toString(timeAfficher));
    }
}