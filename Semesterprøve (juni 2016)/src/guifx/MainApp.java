package guifx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Medarbejder;
import model.Opgave;
import model.UdviklingsTeam;
import service.Service;

public class MainApp extends Application {

	private ListView<Medarbejder> medarbejderliste;
	private ListView<Opgave> opgaveliste;
	private TextField txfNavn, txfNr, txfStilling, txfTeamInfo;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Service.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("UdviklingsTeam Management");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblMedarbejderInfo = new Label("Medarbejder info:");
		pane.add(lblMedarbejderInfo, 0, 0);

		Label lblTeamInfo = new Label("Team info:");
		pane.add(lblTeamInfo, 2, 0);

		Label lblName = new Label("Navn:");
		pane.add(lblName, 0, 1);
		txfNavn = new TextField();
		pane.add(txfNavn, 1, 1);
		txfNavn.setEditable(true);

		txfTeamInfo = new TextField();
		pane.add(txfTeamInfo, 2, 1);
		txfTeamInfo.setEditable(true);
		txfTeamInfo.setText(String
				.valueOf(Service.getUdviklingsTeam().getNavn() + " " + Service.getUdviklingsTeam().getTeamEgenskaber()
						+ " " + Service.getUdviklingsTeam().getTotalPoints() + " points"));

		Label lblNr = new Label("Nummer:");
		pane.add(lblNr, 0, 2);
		txfNr = new TextField();
		pane.add(txfNr, 1, 2);
		txfNr.setEditable(true);

		Label lblStilling = new Label("Stilling:");
		pane.add(lblStilling, 0, 3);
		txfStilling = new TextField();
		pane.add(txfStilling, 1, 3);
		txfStilling.setEditable(true);

		Button btnTilføj = new Button("Tilføj");
		pane.add(btnTilføj, 0, 4);
		btnTilføj.setOnAction(event -> this.tilføjMedarbejder());

		Label lblMedarbejdere = new Label("Medarbejdere:");
		pane.add(lblMedarbejdere, 1, 4);

		Label lblOpgaver = new Label("Opgaver:");
		pane.add(lblOpgaver, 2, 4);

		Button btnVis = new Button("Vis");
		pane.add(btnVis, 0, 5);
		btnVis.setOnAction(event -> this.opdaterMedarbejderInfo());

		medarbejderliste = new ListView<>();
		pane.add(medarbejderliste, 1, 5, 1, 4);
		pane.setPrefHeight(400);
		medarbejderliste.getItems().setAll(Service.getMedarbejderlist());

		opgaveliste = new ListView<>();
		pane.add(opgaveliste, 2, 5, 1, 4);
		pane.setPrefHeight(400);
	}

	// -------------------------------------------------------------------------

	public void tilføjMedarbejder() {
		Medarbejder medarbejder = Service.opretMedarbejder(txfNavn.getText(), Integer.parseInt(txfNr.getText()),
				txfStilling.getText());
		UdviklingsTeam team = Service.getUdviklingsTeam();
		medarbejderliste.getItems().setAll(Service.getMedarbejderlist());
		Service.tilføjMedarbejder(team, medarbejder);
		opdaterMedarbejderInfo();
		this.reset();
	}

	public void reset() {
		txfNavn.setText("");
		txfNr.setText("");
		txfStilling.setText("");
	}

	public void opdaterMedarbejderInfo() {
		Medarbejder medarbejder = medarbejderliste.getSelectionModel().getSelectedItem();
		this.medarbejderliste.getItems().setAll(Service.getUdviklingsTeam().getMedarbejder());
		if (medarbejder != null) {
			medarbejder.sortOpgaver();
			txfNavn.setText(medarbejder.getNavn());
			txfNr.setText(String.valueOf(medarbejder.getNr()));
			txfStilling.setText(medarbejder.getStillingsBetegnelse());
			opgaveliste.getItems().setAll(Service.getOpgave(medarbejder));
		}
	}

}
