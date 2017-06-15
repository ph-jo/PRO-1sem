package service;

import java.util.ArrayList;

import model.Medarbejder;
import model.Opgave;
import model.Projekt;
import model.UdviklingsTeam;
import storage.Storage;

public class Service {

	public static UdviklingsTeam opretUdviklingsTeam(String navn, String teamEgenskaber) {
		UdviklingsTeam team = new UdviklingsTeam(navn, teamEgenskaber);
		Storage.addUdviklingsTeam(team);
		return team;
	}

	public static UdviklingsTeam getUdviklingsTeam() {
		return Storage.getUdviklingsTeam();
	}

	public static Medarbejder opretMedarbejder(String navn, int nr, String stillingsBetegnelse) {
		Medarbejder medarbejder = new Medarbejder(navn, nr, stillingsBetegnelse);
		return medarbejder;
	}

	public static void tilføjMedarbejder(UdviklingsTeam team, Medarbejder medarbejder) {
		team.addMedarbejder(medarbejder);
	}

	public static ArrayList<Medarbejder> getMedarbejderlist() {
		return Storage.getUdviklingsTeam().getMedarbejder();
	}

	public static ArrayList<Medarbejder> getMedarbejder(UdviklingsTeam team) {
		return new ArrayList<Medarbejder>(team.getMedarbejder());
	}

	public static Projekt opretProjekt(int nr, String navn, int estTimer) {
		Projekt projekt = new Projekt(nr, navn, estTimer);
		Storage.addProjekt(projekt);
		return projekt;
	}

	public static Opgave opretOpgave(int nr, String navn, int prioritet, int størrelsesPoint, Projekt projekt) {
		Opgave opgave = new Opgave(nr, navn, prioritet, størrelsesPoint, projekt);
		projekt.addOpgave(opgave);
		return opgave;
	}

	public static void tilføjOpgaver(Medarbejder medarbejder, Opgave opgave) {
		medarbejder.addOpgave(opgave);
	}

	public static ArrayList<Opgave> getOpgave(Medarbejder medarbejder) {
		return new ArrayList<Opgave>(medarbejder.getOpgave());
	}

	public static void initStorage() {
		UdviklingsTeam team1 = Service.opretUdviklingsTeam("TestTeam", "Super team!");

		Projekt projekt1 = Service.opretProjekt(1, "Testprojekt", 42);

		Opgave opgave1 = Service.opretOpgave(1, "Design", 1, 25, projekt1);
		Opgave opgave2 = Service.opretOpgave(2, "Refactor", 5, 50, projekt1);
		Opgave opgave3 = Service.opretOpgave(3, "Storage", 3, 10, projekt1);
		Opgave opgave4 = Service.opretOpgave(4, "Test", 1, 25, projekt1);

		Medarbejder medarbejder1 = Service.opretMedarbejder("Peter", 1, "Tester");
		Medarbejder medarbejder2 = Service.opretMedarbejder("Kristian", 2, "Evaluator");

		tilføjMedarbejder(team1, medarbejder1);
		tilføjMedarbejder(team1, medarbejder2);

		Service.tilføjOpgaver(medarbejder1, opgave1);
		Service.tilføjOpgaver(medarbejder1, opgave2);
		Service.tilføjOpgaver(medarbejder1, opgave3);
		Service.tilføjOpgaver(medarbejder1, opgave4);

		Service.tilføjOpgaver(medarbejder2, opgave1);

		// medarbejder1.sortOpgaver();
		// medarbejder2.sortOpgaver();

	}
}
