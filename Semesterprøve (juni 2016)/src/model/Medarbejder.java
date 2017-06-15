package model;

import java.util.ArrayList;

public class Medarbejder {
	private String navn;
	private int nr;
	private String stillingsBetegnelse;
	private ArrayList<Opgave> opgaver = new ArrayList<>();

	public Medarbejder(String navn, int nr, String stillingsBetegnelse) {
		this.navn = navn;
		this.nr = nr;
		this.stillingsBetegnelse = stillingsBetegnelse;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getStillingsBetegnelse() {
		return stillingsBetegnelse;
	}

	public void setStillingsBetegnelse(String stillingsBetegnelse) {
		this.stillingsBetegnelse = stillingsBetegnelse;
	}

	public ArrayList<Opgave> getOpgave() {
		return new ArrayList<>(opgaver);
	}

	public void addOpgave(Opgave opgave) {
		opgaver.add(opgave);
	}

	public void removeOpgave(Opgave opgave) {
		opgaver.remove(opgave);
	}

	public int getTotalPoints() {
		int total = 0;
		for (int i = 0; i < opgaver.size(); i++) {
			total += opgaver.get(i).getStørrelsesPoint();
		}
		return total;
	}

	public int findOpgaveMedPointPrioritet(int antalPoint, int prioritet) {
		boolean found = false;
		int i = 0;
		Opgave opgave = null;
		while (!found && i < opgaver.size()) {
			opgave = opgaver.get(i);
			if (opgave.getStørrelsesPoint() == antalPoint && opgave.getPrioritet() == prioritet) {
				found = true;
			} else {
				i++;
			}
		}
		if (found) {
			return i;
		} else {
			return -1;
		}
	}

	public void sortOpgaver() {
		for (int i = 1; i < opgaver.size(); i++) {
			Opgave key = opgaver.get(i);
			int j = i;
			while (j > 0 && opgaver.get(j - 1).compareTo(key) > 0) {
				opgaver.set(j, opgaver.get(j - 1));
				j--;
			}
			opgaver.set(j, key);
		}
	}

	@Override
	public String toString() {
		return getNavn() + " " + getNr() + " " + getStillingsBetegnelse() + " " + getTotalPoints() + " points";
	}
}
