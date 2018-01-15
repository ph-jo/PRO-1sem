import spiritusFirma.Spiritus;
import superSalg.Adapter;
import superSalg.ElVare;
import superSalg.FoedeVare;
import superSalg.Vare;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {
        ArrayList<Vare> varer = new ArrayList<>();
        varer.add(new ElVare(50, "Lampe"));
        varer.add(new FoedeVare(10, "Kartofler"));
        varer.add(new FoedeVare(20, "2kg Kartofler"));

        Spiritus spiritus = new Spiritus(100, "Vodka");
        Adapter adapter = new Adapter(spiritus.getPrisen(), spiritus.getBetegnelse(), spiritus);
        varer.add(adapter);

        for (Vare vare : varer) {
            System.out.println(vare.getPris());
        }
    }
}
