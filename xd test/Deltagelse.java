/**
 * Created by Jona on 08-06-2017.
 */
public class Deltagelse {

    private boolean afbud;
    private String begrundelse;
    private Spiller spiller;

    public Deltagelse() {
        this.afbud = false;
    }

    public boolean isAfbud() {
        return afbud;
    }

    public void setAfbud(boolean afbud) {
        this.afbud = afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public void setBegrundelse(String begrundelse) {
        this.begrundelse = begrundelse;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public void setSpiller(Spiller spiller) {
        this.spiller = spiller;
    }

    public String toString() {
        return spiller.getNavn();
    }
}
