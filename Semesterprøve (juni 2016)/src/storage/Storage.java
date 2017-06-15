package storage;

import java.util.ArrayList;

import model.Projekt;
import model.UdviklingsTeam;

public class Storage {

	private static ArrayList<Projekt> projekter = new ArrayList<>();
	private static UdviklingsTeam udviklingsteamet;

	// -------------------------------------------------------------------------

	public static ArrayList<Projekt> getProjekt() {
		return new ArrayList<Projekt>(projekter);
	}

	public static void addProjekt(Projekt projekt) {
		projekter.add(projekt);
	}

	// -------------------------------------------------------------------------

	public static UdviklingsTeam getUdviklingsTeam() {
		return udviklingsteamet;
	}

	public static void addUdviklingsTeam(UdviklingsTeam team) {
		udviklingsteamet = team;
	}

	// -------------------------------------------------------------------------

}
