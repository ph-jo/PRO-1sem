import java.util.ArrayList;

/**
 * Created by Jona on 08-06-2017.
 */
public class Spiller {

    private String navn;
    private int årgang;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller(String navn, int årgang) {
        this.navn = navn;
        this.årgang = årgang;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getÅrgang() {
        return årgang;
    }

    public void setÅrgang(int årgang) {
        this.årgang = årgang;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
    }

    public double kampHonorar() {
        double kampHonorar = 0;
        int counter = 0;
        for (Deltagelse deltagelse : deltagelser) {
            if (!deltagelse.isAfbud()) {
                counter++;
            }
        }
        kampHonorar = counter*10;
        return kampHonorar;
    }

    public String toString() {
        return navn + " " + årgang;
    }
}
