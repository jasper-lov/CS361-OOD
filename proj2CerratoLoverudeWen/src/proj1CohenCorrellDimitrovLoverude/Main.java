/*
* File: Main.java
* Names: Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
* Class: CS 361
* Project 1
* Date: February 9, 2022
*/
//package proj1CohenCorrellDimitrovLoverude;
package fxmlexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.Optional;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

public class Main extends Application{
    /**
     * Styles a Textfield for our window
     *
     * @author Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
     * @return     a Textfield object
    */
    public TextField createTextField() {
        TextField textField = new TextField("Sample text");
        textField.setPrefHeight(290);
        textField.setAlignment(Pos.TOP_LEFT);
        return textField;
    }

    /**
     * Creates a ToolBar with 2 stylized buttons
     *
     * @author Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
     * @param textField object to append "goodbye" onto
     * @return     a "ToolBar" object
    */
    public void setButtons(Scene scene) {
        Button hello = (Button) scene.lookup("#hello");
        /*
        hello.setStyle("-fx-background-color: #90EE90;"
                        + "-fx-border-radius: .25em;"
                        + "-fx-background-radius: .25em;"
                        + "-fx-border-color: #000000;");
        */
        if (hello != null){
            hello.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * Opens a Dialog Box to change the button text
                 *
                 * @author Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
                 * @param  event event created on button press
                 */
                @Override
                public void handle(ActionEvent event) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Give me a number");
                    dialog.setHeaderText("Give me an integer from 0 to 255:");
                    Optional<String> result = dialog.showAndWait();
                    result.ifPresent(number -> {hello.setText(number);});
                }
            });
        }

        //toolBar.getItems().add(hello);

        Button goodbye = (Button) scene.lookup("#goodbye");
        TextField textField = (TextField) scene.lookup("#textfield");
        /*
        goodbye.setStyle("-fx-background-color: #FFC0CB;"
                        + "-fx-border-radius: .25em;"
                        + "-fx-background-radius: .25em;"
                        + "-fx-border-color: #000000;");
         */
        if (goodbye != null){
            goodbye.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * Appends "Goodbye" to textfield on click
                 *
                 * @param  event event created on button click
                 * @return
                 */
                @Override
                public void handle(ActionEvent event) {
                    textField.appendText("Goodbye");
                }
            });//goodbye.setOnAction
            //toolBar.getItems().add(goodbye);
            //return toolBar;
        }
    }


    /**
     * Creates a MenuBar with a File menu and clear/exit options
     *
     * @author Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
     * @param textField a texfield object to be cleared
     * @param hello a button to be reset
     * @return     a "MenuBar" object
    */
    public void setMenuItems(Scene scene) {
        MenuBar menuBar = (MenuBar) scene.lookup("#menubar");
        if (menuBar != null){
            Menu menu = menuBar.getMenus().get(0);

            MenuItem reset = menu.getItems().get(0);
            MenuItem exit = menu.getItems().get(2);

            TextField textField = (TextField) scene.lookup("textfield");
            Button hello = (Button) scene.lookup("hello");
            //MenuBar menuBar = new MenuBar();
            //Menu menuFile = new Menu("File");
            //menuBar.getMenus().addAll(menuFile);
            //MenuItem clear = new MenuItem("Clear");
            reset.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                    textField.setText("Sample text");
                    hello.setText("Hello");
                }
            });
            //MenuItem exit = new MenuItem("Exit");
            exit.setOnAction(new EventHandler<ActionEvent>() {
                /**
                 * on "exit clicked" end program
                 *
                 * @author Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
                 * @param  event event created on button press
                 */
                public void handle(ActionEvent t) {
                    System.exit(0);
                }
            });
            //reset.add(new SeparatorMenuItem());
            //return menuBar;
        }

    }

    /**
     * Creates a MenuBar, a ToolBar with two Buttons, and a TextField
     * All elements are added to a scene
     * Shows scene on PrimaryStage and handles button "clicked" events
     * <p>
     * Required Inheriterd Subclass Method 
     * The main entry point for all JavaFX applications.
     * Called on the JavaFX Application Thread.
     *
     * @author Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
     * @param  primaryStage  Main window used by Application
     * @return     
     * @see        Application
    */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // initalize scene
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, 400, 350);
        scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        /*
        TextField myTextField = createTextField();
        ToolBar myToolBar = createToolBar(myTextField);
        Button hello = (Button) myToolBar.getItems().get(0);
        MenuBar myMenu = createMenuBar(myTextField, hello);

        // add items to "stage" and display
        ((VBox) scene.getRoot()).getChildren().addAll(myMenu);
        ((VBox) scene.getRoot()).getChildren().addAll(myToolBar);
        ((VBox) scene.getRoot()).getChildren().addAll(myTextField);
        */
        setButtons(scene);
        setMenuItems(scene);

        primaryStage.setTitle("Project 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates a window with interactable buttons
     * Method automatically called on start
     * @param  args Command line arguments used in Application "launch" method
     * @return     an interactable window
     * @see        start
    */
    public static void main(String[] args) {
        launch(args);
    }
}
