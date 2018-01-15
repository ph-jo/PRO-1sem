import java.util.ArrayList;
import java.util.Arrays;

public class Saelger implements Observer {

    private String navn;

    public Saelger(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        Bogtitel bogtitel = (Bogtitel) s;
        ArrayList<Bogtitel> bogtitlerSomIkkeErEns = new ArrayList<>();

        for (Kunde k : bogtitel.getKunder()) {
            if (k.getBogtitler().contains(bogtitel)) {
                for (Bogtitel b : k.getBogtitler()) {
                    if (!b.equals(bogtitel) && !bogtitlerSomIkkeErEns.contains(b)) {
                        bogtitlerSomIkkeErEns.add(b);
                    }
                }
            }
        }

        for (Bogtitel b : bogtitlerSomIkkeErEns) {
            System.out.println(b.getTitel());
        }
    }
}