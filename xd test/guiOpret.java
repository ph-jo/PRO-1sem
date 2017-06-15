import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Jona on 08-06-2017.
 */
public class guiOpret extends Stage {

    private Kamp kamp;
    private TextField txfFilNavn;
    private Button btnCreate;

    public guiOpret(Kamp kamp) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.setTitle("Opret fil");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
        this.kamp = kamp;
    }

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        pane.setPrefSize(200, 200);

        Label lblFilNavn = new Label("Indtast filnavn:");
        pane.add(lblFilNavn, 0, 0);

        txfFilNavn = new TextField();
        pane.add(txfFilNavn, 0, 1);

        btnCreate = new Button("Opret fil");
        pane.add(btnCreate,0,2);
        btnCreate.setOnAction(event -> opretFil());
    }

    private void opretFil() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (txfFilNavn.getText().trim().isEmpty()) {
            alert.setTitle("Missing information");
            alert.setHeaderText("Missing information");
            alert.setContentText("Skriv filnavn");
            alert.showAndWait();
        }
        else {
            String filnavn = txfFilNavn.getText().trim();
            kamp.spillerHonorar(filnavn);
            this.hide();
        }
    }
}