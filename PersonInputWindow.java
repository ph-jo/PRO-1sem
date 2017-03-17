package Opgaver;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class PersonInputWindow extends Stage {
    public PersonInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //------------------------------------------------------//

    private TextField txfName;
    private TextField txfTitle;
    private CheckBox senior;
    private Person p = null;

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Name:");
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
        pane.add(senior, 1, 2);

        Button btnOk = new Button("Ok");
        pane.add(btnOk, 1, 3, 2, 3);
        btnOk.setOnAction(event -> this.okAction());


    }
    private void okAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        Boolean senior1 = senior.isSelected();
        if (name.length() > 0 && title.length() > 0) {
            p = new Person(name, title, senior1);
            txfName.clear();
            txfTitle.clear();
            senior.setSelected(false);
            this.hide();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
    }
    public Person getPerson() {
        return p;
    }
}
