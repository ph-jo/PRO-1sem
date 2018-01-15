import java.util.ArrayList;

public class Kunde {

    private String navn;
    private ArrayList<Bogtitel> bogtitler;

    public Kunde(String navn) {
        this.navn = navn;
        this.bogtitler = new ArrayList<>();
    }

    public ArrayList<Bogtitel> getBogtitler() {
        return this.bogtitler;
    }

    public void addBogtitel(Bogtitel bogtitel) {
        this.bogtitler.add(bogtitel);
    }

    public void removeBogtitel(Bogtitel bogtitel) {
        this.bogtitler.remove(bogtitel);
    }
}
