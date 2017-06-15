import java.util.ArrayList;

/**
 * Created by Jona on 08-06-2017.
 */
public class Storage {

    private static ArrayList<Kamp> kampe = new ArrayList<>();
    private static ArrayList<Spiller> spillere = new ArrayList<>();

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<>(kampe);
    }

    public static void addKamp(Kamp kamp) {
        if (!kampe.contains(kamp)) {
            kampe.add(kamp);
        }
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

    public static void addSpiller(Spiller spiller) {
        if (!spillere.contains(spiller)) {
            spillere.add(spiller);
        }
    }
}
