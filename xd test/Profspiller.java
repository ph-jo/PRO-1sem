/**
 * Created by Jona on 08-06-2017.
 */
public class Profspiller extends Spiller{

    private double kampHonorar;

    public Profspiller(String navn, int årgang, double kampHonorar) {
        super(navn, årgang);
        this.kampHonorar = kampHonorar;
    }

    public double getKampHonorar() {
        return kampHonorar;
    }

    public void setKampHonorar(double kampHonorar) {
        this.kampHonorar = kampHonorar;
    }

    public double kampHonorar() {
        int counter = 0;
        for (Deltagelse deltagelse : getDeltagelser()) {
            if (deltagelse.isAfbud()) {
                counter++;
            }
        }
        return kampHonorar/(1+(counter/100));
    }
}
