package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Uslovi koje mora zadovoljavati klasa koja je deklarisana u pom.xml kao
 * glavna klasa od koje sve počinje.
 * <li>1. extends Application</li>
 * <li>2. implementirati start(Stage stage) </li>
 * <li>3. mora postojati main</li>
 * <li>4. launch() funkcija unutar main funkcije poziva start(Stage stage)</li>
 *
 * <p>
 * Tri vrste komponenti u swingu:
 * <li>1. Kontejneri</li>
 * <li>2. Kontrole</li>
 * <li>3. LayoutManageri..BorderLayout, FlowLayout, BoxLayout</li>
 * <p>
 * Dvije vrste komponenti u JavaFx:
 * <li>1. Kontejneri i LayoutManageri  ->  BorderPane, VBox</li>
 * <li>2. Kontrole</li>
 * </p>
 */
public class EntryPointOfApplicationComboBox extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        //kontrola
        ComboBox<String> favouriteMovieComboBox = new ComboBox<>();
        ObservableList<String> items = favouriteMovieComboBox.getItems();
        items.addAll("Notebook", "Good Will Hunting", "Kum", "Kum 2", "Mafia", "Hanibal", "StarWars", "Hpobit");
        favouriteMovieComboBox.setPromptText("Odaberi omiljeni film...");
        favouriteMovieComboBox.setEditable(true);
        favouriteMovieComboBox.setOnAction(e->{
            System.out.println(favouriteMovieComboBox.getValue());
        });

        //kontejner
        VBox comboVBox = new VBox(10);
        comboVBox.setPadding(new Insets(20));
        comboVBox.getChildren().add(favouriteMovieComboBox);

        Scene scene = new Scene(comboVBox, 400, 300);
        stage.setTitle("Favourite Movie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}