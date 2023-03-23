package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
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
public class EntryPointOfApplicationTreeView extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        /*
        Svako stablo ili TreeView ima MAIN ROOT.
        Svaki ROOT ima BRANCH.
        Ukoliko ima neki BRANCH koji nema children to je LEAF.
         */


        TreeItem<String> root = new TreeItem<>("Programming Languages");
        root.setExpanded(true);

        //Java, JavaScript, Python -> root
        TreeItem<String> javaBranch = createBranch("Java", root);
        createBranch("Ruby", javaBranch);
        createBranch("Scala", javaBranch);
        createBranch("Spring", javaBranch);
        createBranch("Kotlin", javaBranch);
        createBranch("Dart", javaBranch);

        TreeItem<String> jsBranch = createBranch("JS", root);
        createBranch("Vue.js", jsBranch);
        createBranch("React.js", jsBranch);
        createBranch("Angular.js", jsBranch);

        TreeItem<String> pythonBranch = createBranch("Python", root);
        createBranch("Django", pythonBranch);
        createBranch("Flusk", pythonBranch);
        createBranch("Hug", pythonBranch);

        TreeView<String> languageTreeView = new TreeView<>(root);
        languageTreeView.setShowRoot(true);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(languageTreeView);

        Scene scene = new Scene(stackPane, 500, 300);
        stage.setScene(scene);
        stage.show();

    }


    private TreeItem<String> createBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        System.out.println("Argumenti: " + args.length);
        for(String param: args){
            System.out.println("Param: " + param);
        }
        launch();
    }
}