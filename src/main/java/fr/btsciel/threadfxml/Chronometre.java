package fr.btsciel.threadfxml;

import javafx.scene.control.Label;

public class Chronometre {
    double depart;
    double timeAfficher;

    public Chronometre() {
        this.depart = System.currentTimeMillis();
    }
    public void afficherTemps(Label timeField) {
        try {
            Thread.sleep(50);
            timeAfficher = System.currentTimeMillis() - depart;
            timeAfficher = timeAfficher / 1000;
            timeField.setText(Double.toString(timeAfficher));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}