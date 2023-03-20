package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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
public class EntryPointOfApplicationCopyCheckBoxChoiceBoxButton extends Application {






    //loada statički dio UI
//        FXMLLoader fxmlLoader = new FXMLLoader(EntryPointOfApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

    //    private CheckBox pizzaCheckBox;
//    private CheckBox cevapiCheckBox;
//    private CheckBox pittaCheckBox;
    private ChoiceBox<String> fruitChoiceBox;
    private Label messageLabel;

    @Override
    public void start(Stage stage) throws IOException {
        /*
        Kontrole
         */
//        pizzaCheckBox = new CheckBox("Pizza");
//        cevapiCheckBox = new CheckBox("Čevapi");
//        pittaCheckBox = new CheckBox("Pita");
//        pittaCheckBox.setSelected(true);
        //OrderButtonEventHandler orderButtonEventHandler = new OrderButtonEventHandler();
        fruitChoiceBox = new ChoiceBox<>();
        fruitChoiceBox.setValue("Strawberry");
        SingleSelectionModel<String> fruitSelectionModel = fruitChoiceBox.getSelectionModel();
        ReadOnlyProperty<String> fruitStringReadOnlyProperty = fruitSelectionModel.selectedItemProperty();
        fruitStringReadOnlyProperty.addListener(((observableValue, oldSelectedValue, newSelectedValue) -> {
            System.out.println(observableValue.getClass().getName());
            System.out.println("OLD: " + oldSelectedValue);
            System.out.println("NEW: " + newSelectedValue);
        }));
        ObservableList<String> fruits = fruitChoiceBox.getItems();
        fruits.add("Strawberry");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Watermelon");
        fruits.add("Blueberry");
        fruits.add("Kiwi");
        fruits.add("Pineapple");
        fruits.add("Orange");
        fruits.add("Lemon");

        Button orderFoodButton = new Button("Naruči");
        orderFoodButton.setOnAction(this::onOrderButtonClick);

        messageLabel = new Label();


        /*
        Kontejner
         */
        VBox foodVBox = new VBox(10);
        foodVBox.setPadding(new Insets(20));

        /*
        Veza između kontejnera i sadržanih kontrola je urađena preko ObservableList<Node>
         */
        ObservableList<Node> controlsList = foodVBox.getChildren();
//        controlsList.add(pittaCheckBox);
//        controlsList.add(pizzaCheckBox);
//        controlsList.add(cevapiCheckBox);
        controlsList.add(fruitChoiceBox);
        controlsList.add(orderFoodButton);
        controlsList.add(messageLabel);

        Scene scene = new Scene(foodVBox, 300, 200);
        stage.setTitle("Hrana u Bosni");
        stage.setScene(scene);
        stage.show();
    }

    private void onOrderButtonClick(ActionEvent actionEvent) {
        String odabranoVoce = fruitChoiceBox.getValue();
        messageLabel.setText("Odabrano voće: " + odabranoVoce);
    }

    public static void main(String[] args) {
        launch();
    }

    /*private class OrderButtonEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if(pittaCheckBox.isSelected()){
                System.out.println("Neko voli PITU...");
            }
            if(pizzaCheckBox.isSelected()){
                System.out.println("Neko voli PIZZU");
            }
            if(cevapiCheckBox.isSelected()){
                System.out.println("Neko voli ĆEVAPE");
            }
        }
    }*/
}