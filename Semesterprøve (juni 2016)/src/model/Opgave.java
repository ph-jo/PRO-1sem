package model;

import java.util.ArrayList;

public class Opgave implements Comparable<Opgave> {
	private int nr;
	private String navn;
	private int prioritet;
	private int størrelsesPoint;
	private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
	private Projekt projekt;

	public Opgave(int nr, String navn, int prioritet, int størrelsesPoint, Projekt projekt) {
		this.nr = nr;
		this.navn = navn;
		this.prioritet = prioritet;
		this.størrelsesPoint = størrelsesPoint;
		this.projekt = projekt;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getPrioritet() {
		return prioritet;
	}

	public void setPrioritet(int prioritet) {
		this.prioritet = prioritet;
	}

	public int getStørrelsesPoint() {
		return størrelsesPoint;
	}

	public void setStørrelsesPoint(int størrelsesPoint) {
		this.størrelsesPoint = størrelsesPoint;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public ArrayList<Medarbejder> getMedarbejder() {
		return new ArrayList<>(medarbejdere);
	}

	public void addMedarbejder(Medarbejder medarbejder) {
		medarbejdere.add(medarbejder);
	}

	public void removeMedarbejder(Medarbejder medarbejder) {
		medarbejdere.remove(medarbejder);
	}

	@Override
	public int compareTo(Opgave opgave) {
		if (prioritet == opgave.getPrioritet()) {
			return Integer.compare(størrelsesPoint, opgave.getStørrelsesPoint());
		} else if (prioritet == opgave.getPrioritet() && størrelsesPoint == opgave.getStørrelsesPoint()) {
			return Integer.compare(nr, opgave.getNr());
		} else {
			return Integer.compare(prioritet, opgave.getPrioritet());
		}

	}

	@Override
	public String toString() {
		return "Nr:" + getNr() + "\tNavn: " + getNavn() + "\tPrioritet: " + getPrioritet() + "\tPoints: "
				+ getStørrelsesPoint();
	}
}
