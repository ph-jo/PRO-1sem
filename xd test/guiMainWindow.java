import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Jona on 08-06-2017.
 */
public class guiMainWindow extends Application{

    private ListView<Kamp> lvwKampe;
    private TextField txfSted, txfDato, txfTid;
    private HBox hBoxButtons;
    private Button btnOpdater, btnOpret, btnLavFil;

    public static void main(String[] args) {
        Service.initStorage();
        Application.launch(args);
    }

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(500, 280);
        this.initContent(gridPane);
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kampadministration");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // --------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblKampe = new Label("Kampe");
        pane.add(lblKampe,0,0);

        lvwKampe = new ListView<>();
        pane.add(lvwKampe, 0, 1, 1, 4);
        lvwKampe.getItems().setAll(Storage.getKampe());

        javafx.beans.value.ChangeListener<Kamp> listener;
        listener = (ov, oldMedarbejder, newMedarbejder) -> this.updateControls();
        lvwKampe.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblSted = new Label("Spillested:");
        pane.add(lblSted, 1, 0);

        txfSted = new TextField();
        pane.add(txfSted, 2, 0);
        txfSted.setEditable(false);

        Label lblDato = new Label("Spilledato:");
        pane.add(lblDato, 1, 1);

        txfDato = new TextField();
        pane.add(txfDato, 2, 1);
        txfDato.setEditable(false);

        Label lblTid = new Label("Spilletid:");
        pane.add(lblTid,1,2);

        txfTid = new TextField();
        pane.add(txfTid, 2, 2);
        txfTid.setEditable(false);

        hBoxButtons = new HBox();
        pane.add(hBoxButtons, 2, 3);

        btnOpret = new Button("Opret");
        hBoxButtons.getChildren().add(btnOpret);
        btnOpret.setOnAction(event -> createKamp());

        btnOpdater = new Button("Opdater");
        hBoxButtons.getChildren().add(btnOpdater);
        btnOpdater.setOnAction(event -> opdaterKamp());

        btnLavFil = new Button("Lav fil");
        pane.add(btnLavFil, 2, 4);
        btnLavFil.setOnAction(event -> lavFil());
    }

    private void updateControls() {
        Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();

        txfSted.clear();
        txfDato.clear();
        txfTid.clear();

        txfSted.setText(kamp.getSted());
        txfDato.setText(kamp.getDato().toString());
        txfTid.setText(kamp.getTid().toString());
    }

    private void opdaterKamp() {

    }

    private void createKamp() {

    }

    private void lavFil() {
        Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();

        guiOpret guiOpretWindow = new guiOpret(kamp);
        guiOpretWindow.showAndWait();
    }
}
