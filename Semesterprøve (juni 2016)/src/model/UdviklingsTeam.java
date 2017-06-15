package model;

import java.util.ArrayList;

public class UdviklingsTeam {
	private String navn;
	private String teamEgenskaber;
	private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

	public UdviklingsTeam(String navn, String teamEgenskaber) {
		this.navn = navn;
		this.teamEgenskaber = teamEgenskaber;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getTeamEgenskaber() {
		return teamEgenskaber;
	}

	public void setTeamEgenskaber(String teamEgenskaber) {
		this.teamEgenskaber = teamEgenskaber;
	}

	public ArrayList<Medarbejder> getMedarbejder() {
		return new ArrayList<>(medarbejdere);
	}

	public void addMedarbejder(Medarbejder medarbejder) {
		this.medarbejdere.add(medarbejder);
	}

	public void removeMedarbejder(Medarbejder medarbejder) {
		this.medarbejdere.remove(medarbejder);
	}

	public Medarbejder opretMedarbejder(String navn, int nr, String stillingsBetegnelse) {
		Medarbejder medarbejder = new Medarbejder(navn, nr, stillingsBetegnelse);
		medarbejdere.add(medarbejder);
		return medarbejder;
	}

	public int getTotalPoints() {
		int total = 0;
		ArrayList<Opgave> opgaver = new ArrayList<>();

		for (Medarbejder list : medarbejdere) {
			for (Opgave list2 : list.getOpgave()) {
				if (!opgaver.contains(list2)) {
					total += list2.getStørrelsesPoint();
					opgaver.add(list2);
				}
			}
		}

		return total;
	}

}
