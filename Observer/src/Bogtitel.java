import java.util.ArrayList;

public class Bogtitel implements Subject {

    private String titel;
    private int antal;
    private ArrayList<Kunde> kunder;
    private ArrayList<Observer> observers;

    public Bogtitel(String titel, int antal) {
        this.titel = titel;
        this.antal = antal;
        this.kunder = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public void indkoebTillager(int antal) {
        this.antal += antal;
    }

    public void etKoeb(Kunde k) {
        k.addBogtitel(this);
        addKunde(k);
        antal--;
        for (Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public ArrayList<Kunde> getKunder() {
        return kunder;
    }

    public void addKunde(Kunde k) {
        this.kunder.add(k);
    }

    public void removeKunde(Kunde k) {
        this.kunder.remove(k);
    }
}
