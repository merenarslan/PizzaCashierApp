/*
    CSS.css
    Author: Melih Eren Arslan
    Date: 07.31.2020

    Description
    Pizzeria class is the main class to manage and create the gui with its frame.
 
    @author Melih Eren Arslan
 */
package arslamel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Pizzeria class is main class to show frame of the app.
 *
 * @author melih
 */
public class Pizzeria extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    /**
     * It helps to create the frame.
     *
     * @param stage represents the windows in JAVAFX
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("FXMLPizza.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Printer");
        stage.show();
    }

}
