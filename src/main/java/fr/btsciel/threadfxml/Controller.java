package fr.btsciel.threadfxml;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button goButton;
    public Circle coureur1;
    public Circle coureur2;
    public Circle coureur3;
    public Label gagnantTime;
    public Label coureur1Time;
    public Label coureur2Time;
    public Label coureur3Time;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(() -> run(coureur1, coureur1Time)).start();

        new Thread(() -> run(coureur2, coureur2Time)).start();

        new Thread(() -> run(coureur3, coureur3Time)).start();
    }

    public void run(Circle coureur, Label coureurTime) {
        for (int i = (int) coureur.getLayoutX(); i < coureurTime.getLayoutX() - 50; i+=30) {
            try {
                Thread.sleep((long) (Math.random() * 2000));
                coureur.setLayoutX(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}