import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Jona on 08-06-2017.
 */
public class Service {


    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
        Kamp kamp = new Kamp(sted, dato, tid);
        Storage.addKamp(kamp);
        return kamp;
    }

    public static Spiller createSpiller(String navn, int årgang) {
        Spiller spiller = new Spiller(navn, årgang);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static Profspiller createProfspiller(String navn, int årgang, double kampHonorar) {
        Profspiller profspiller = new Profspiller(navn, årgang, kampHonorar);
        Storage.addSpiller(profspiller);
        return profspiller;
    }

    public static Deltagelse createDeltagelse(Kamp kamp, Spiller spiller) {
        Deltagelse deltagelse = kamp.createDeltagelse();
        spiller.addDeltagelse(deltagelse);
        deltagelse.setSpiller(spiller);
        return deltagelse;
    }

    public static void initStorage() {
        Spiller jane = createSpiller("Jane Jensen", 1999);
        Spiller lene = createSpiller("Lene Hansen", 2000);
        Spiller mette = createSpiller("Mette Petersen", 1999);

        Profspiller sofia = createProfspiller("Sofia Kjeldsen", 1999, 50);
        Profspiller maria = createProfspiller("Maria Nielsen", 2000, 55);

        Kamp herning = createKamp("Herning", LocalDate.of(2015,01,26), LocalTime.of(10, 30));
        Kamp ikast = createKamp("Ikast", LocalDate.of(2015,01,27), LocalTime.of(13,30));

        Deltagelse deltagelseJane1 = createDeltagelse(herning, jane);
        deltagelseJane1.setAfbud(true);
        deltagelseJane1.setBegrundelse("Moster Oda har fødselsdag");
        Deltagelse deltagelseJane2 = createDeltagelse(ikast, jane);

        Deltagelse deltagelseLene1 = createDeltagelse(herning, lene);
        Deltagelse deltagelseLene2 = createDeltagelse(ikast, lene);

        Deltagelse deltagelseMette1 = createDeltagelse(herning, mette);
        Deltagelse deltagelseMette2 = createDeltagelse(ikast, mette);

        Deltagelse deltagelseSofia1 = createDeltagelse(herning, sofia);
        Deltagelse deltagelseSofia2 = createDeltagelse(ikast, sofia);
        deltagelseSofia2.setAfbud(true);
        deltagelseSofia2.setBegrundelse("Dårlig form");

        Deltagelse deltagelseMaria1 = createDeltagelse(herning, maria);
        Deltagelse deltagelseMaria2 = createDeltagelse(ikast, maria);

    }

    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse) {
        if (spiller != null && deltagelse != null) {
            spiller.addDeltagelse(deltagelse);
            deltagelse.setSpiller(spiller);
        }
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> kamp1, ArrayList<Kamp> kamp2) {
        ArrayList<Kamp> alleKampe = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < kamp1.size() && i2 < kamp2.size()) {
            if (kamp1.get(i1).compareTo(kamp2.get(i2)) <= 0) {
                alleKampe.add(kamp1.get(i1));
                i1++;
            }
            else {
                alleKampe.add(kamp2.get(i2));
                i2++;
            }
        }
        while (i1 < kamp1.size()) {
            alleKampe.add(kamp1.get(i1));
            i1++;
        }

        while (i2 < kamp2.size()) {
            alleKampe.add(kamp2.get(i2));
            i2++;
        }

        return alleKampe;
    }
}
