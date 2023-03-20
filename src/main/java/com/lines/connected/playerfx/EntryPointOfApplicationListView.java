package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
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
public class EntryPointOfApplicationListView extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        // Kontrola
        ListView<String> carListView = new ListView<>();
        ObservableList<String> carItems = carListView.getItems();
        carItems.addAll("Audi", "BMW", "Mercedes", "VW", "Škoda", "Fiat", "Zastava", "Volvo", "Opel", "Peugeot", "Citroen", "Ford");
        MultipleSelectionModel<String> selectionModel = carListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        //Kontejner
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(carListView);

        Scene scene = new Scene(borderPane, 500, 150);
        stage.setTitle("Favourite Car");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}