package fr.btsciel.threadfxml;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button goButton;
    public Circle circleBlue;
    public Circle circleYellow;
    public Circle circleRed;
    public Label gagnant;
    public Label blueTime;
    public Label yellowTime;
    public Label redTime;
    public Chronometre chronometre;
    public int top = 0;
    public boolean isWinnerSettled = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final double blueCoordinate = circleBlue.getLayoutX();
        final double yellowCoordinate = circleYellow.getLayoutX();
        final double redCoordinate = circleRed.getLayoutX();

        goButton.setOnAction(event -> {
            goButton.setDisable(true);
            top = 0;
            isWinnerSettled = false;
            gagnant.setVisible(false);
            chronometre = new Chronometre();
            Coureur coureur1 = new Coureur("BLUE", circleBlue, blueTime, chronometre);
            Coureur coureur2 = new Coureur("YELLOW", circleYellow, yellowTime, chronometre);
            Coureur coureur3 = new Coureur("RED", circleRed, redTime, chronometre);

            coureur1.getCorps().setLayoutX(blueCoordinate);
            coureur2.getCorps().setLayoutX(yellowCoordinate);
            coureur3.getCorps().setLayoutX(redCoordinate);

            new Thread(() -> run(coureur1)).start();
            new Thread(() -> run(coureur2)).start();
            new Thread(() -> run(coureur3)).start();

            new Thread(() -> setTime(coureur1)).start();
            new Thread(() -> setTime(coureur2)).start();
            new Thread(() -> setTime(coureur3)).start();
        });
    }
    public void run(Coureur coureur) {
        for (int i = (int) coureur.getCorps().getLayoutX(); i < coureur.getTemps().getLayoutX() - 50; i+=50) {
            try {
                Thread.sleep((long)(Math.random() * 2000));
                coureur.getCorps().setLayoutX(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        top++;
    }

    public void setTime(Coureur coureur) {
        while (top != 3) {
            try {
                if (coureur.getCorps().getLayoutX() != coureur.getTemps().getLayoutX() - 55) {
                    Thread.sleep(30);
                    Platform.runLater(() -> coureur.getChronometre().afficherTemps(coureur.getTemps()));
                } else if (coureur.getCorps().getLayoutX() == coureur.getTemps().getLayoutX() - 55 && top == 1 && !isWinnerSettled) {
                    Platform.runLater(() -> {
                        gagnant.setVisible(true);
                        gagnant.setText("Winner: " + coureur.getName() + "! Time: " + coureur.getTemps().getText());
                        gagnant.setBackground(coureur.getTemps().getBackground());
                    });
                    isWinnerSettled = true;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        goButton.setDisable(false);
    }
}