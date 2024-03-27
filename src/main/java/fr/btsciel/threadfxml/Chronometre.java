package fr.btsciel.threadfxml;

import javafx.scene.control.Label;

public class Chronometre {
    double depart = System.currentTimeMillis();
    double heureAfficher;
    public void afficherTemps(Label timeField) {
        try {
            Thread.sleep(100);
            heureAfficher = System.currentTimeMillis() - depart;
            timeField.setText(Double.toString(heureAfficher));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
