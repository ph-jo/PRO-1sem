package model;

import java.util.ArrayList;

public class Projekt {
	private int nr;
	private String navn;
	private int estTimer;
	private ArrayList<Opgave> opgaver = new ArrayList<>();

	public Projekt(int nr, String navn, int estTimer) {
		this.nr = nr;
		this.navn = navn;
		this.estTimer = estTimer;
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

	public int getEstTimer() {
		return estTimer;
	}

	public void setEstTimer(int estTimer) {
		this.estTimer = estTimer;
	}

	public ArrayList<Opgave> getOpgave() {
		return new ArrayList<>(opgaver);
	}

	public void addOpgave(Opgave opgave) {
		opgaver.add(opgave);
	}

	public void removeOpgave(Opgave opgave) {
		opgaver.add(opgave);
	}
}
