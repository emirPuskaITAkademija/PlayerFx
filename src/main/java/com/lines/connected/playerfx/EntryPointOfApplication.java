package com.lines.connected.playerfx;

import com.lines.connected.playerfx.product.dao.Person;
import com.lines.connected.playerfx.product.dao.ProductController;
import com.lines.connected.playerfx.product.dao.entity.Product;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.time.LocalDate;

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
 * <li>1. Kontejneri i LayoutManageri  ->  BorderPane, VBox, GBox</li>
 * <li>2. Kontrole</li>
 * </p>
 */
public class EntryPointOfApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    //JTable -> TableModel -> loada podatke
    //Direktno sa tabelom JavaFx vezali Product
    private TableView<Product> productTableView = new TableView<>();
    private ProductController productController = new ProductController();

    private TextField priceInput = new TextField();
    private TextField quantityInput = new TextField();
    private TextField nameInput = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Product> productObservableList = productController.loadProducts();
        productTableView.setItems(productObservableList);

        TableColumn<Product, String> nameColumn = new TableColumn<>("Ime");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product, String> descriptionColumn = new TableColumn<>("Opis");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Product, BigDecimal> priceColumn = new TableColumn<>("Cijena jedinična");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Količina");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        productTableView.getColumns().addAll(nameColumn, descriptionColumn, priceColumn, quantityColumn);

        Button deleteButton = new Button("DELETE");
        deleteButton.setOnAction(this::onDeleteClickHandle);

        Button addButton = new Button("ADD");
        addButton.setOnAction(this::onAddButtonClick);

        HBox formBox = new HBox(10);
        formBox.setPadding(new Insets(10));
        nameInput.setPromptText("Name..");
        priceInput.setPromptText("Price..");
        formBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);





        VBox container = new VBox(20);
        container.setPadding(new Insets(10));
        ObservableList<Node> nodes = container.getChildren();
        nodes.add(productTableView);
        nodes.add(formBox);
        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();
    }

    private void onAddButtonClick(ActionEvent actionEvent){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        product.setPrice(new BigDecimal(priceInput.getText()));
        ObservableList<Product> allTableProducts = productTableView.getItems();
        allTableProducts.add(product);
        //TODO:zadaca interakcija s bazom
    }

    private void onDeleteClickHandle(ActionEvent actionEvent){
      ObservableList<Product> selectedProducts =  productTableView.getSelectionModel().getSelectedItems();
      ObservableList<Product> allTableProducts = productTableView.getItems();
      selectedProducts.forEach(allTableProducts::remove);
    }

}