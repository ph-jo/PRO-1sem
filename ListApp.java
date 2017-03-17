package Opgaver;

import java.util.ArrayList;

import demo4listview_Dialog.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("System");
        GridPane pane = new GridPane();
        this.initContent(pane);

        personWindow = new PersonInputWindow("Add Person", stage);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();





    }

    // -------------------------------------------------------------------------

    private TextField txfName;
    private TextField txfTitle;
    private Button btnAdd;
    private CheckBox senior;

    private PersonInputWindow personWindow;

    private ListView<Person> lvwPersons;

    private final Controller controller = new Controller();

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        /*Label lblNames = new Label("Name:");
        pane.add(lblNames, 0, 0);
        txfName = new TextField();
        pane.add(txfName, 1, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        txfTitle = new TextField();
        pane.add(txfTitle, 1, 1);

        Label lblSenior = new Label("Senior:");
        pane.add(lblSenior, 0, 2);
        senior = new CheckBox();
        pane.add(senior, 1, 2);*/


        lvwPersons = new ListView<Person>();
        pane.add(lvwPersons, 1, 3);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        //lvwPersons.getItems().setAll(controller.persons);

        //btnAdd = new Button("Add");
        //pane.add(btnAdd, 4, 2);
        //btnAdd.setOnAction(event -> this.controller.addAction());

        Button btnAddPerson = new Button("Add");
        pane.add(btnAddPerson, 4, 2);
        btnAddPerson.setOnAction(event -> this.controller.addPerson());

    }

    private class Controller {
        private ArrayList<Person> persons = new ArrayList<>();

        private void addPerson() {
            personWindow.showAndWait();
            Person newPerson = personWindow.getPerson();
            if(newPerson != null) {
                persons.add(newPerson);
                lvwPersons.getItems().setAll(persons);

            }
        }

        /*public Controller() {
            initPersons();
        }*/

        /*private void initPersons() {
            persons = new ArrayList<Person>();
            persons.add(new Person("Jens", "Landmand", true));
        }*/

        // Button actions
        /*private void addAction() {
            String name = txfName.getText().trim();
            String title = txfTitle.getText().trim();
            Boolean senior1 = senior.isSelected();
            if (name.length() > 0 && title.length() > 0) {
                Person p = new Person(name, title, senior1);
                persons.add(p);
                lvwPersons.getItems().setAll(persons);
                clear();
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                if(name.length() > 0 && title.length() == 0) {
                    alert.setTitle("Add person");
                    alert.setHeaderText("No TITLE typed");
                    alert.setContentText("Type the TITLE of the person");
                    alert.show();
                } else if(name.length() == 0 && title.length() > 0) {
                    alert.setTitle("Add person");
                    alert.setHeaderText("No NAME typed");
                    alert.setContentText("Type the NAME of the person");
                    alert.show();
                } else {
                    alert.setTitle("Add person");
                    alert.setHeaderText("No NAME AND TITLE typed");
                    alert.setContentText("Type the NAME AND TITLE of the person");
                    alert.show();
                }

                // wait for the modal dialog to close
            }
        }*/

        private void clear() {
            txfName.clear();
            txfTitle.clear();
            senior.setSelected(false);
        }
    }
}
