package superSalg;

import spiritusFirma.Spiritus;
import superSalg.Vare;

public class Adapter extends Vare {

    private Spiritus spiritus;

    public Adapter(int pris, String navn, Spiritus spiritus) {
        super(pris, navn);
        this.spiritus = spiritus;
    }

    @Override
    public int getPris() {
        return spiritus.getPrisen();
    }

    @Override
    public void setPris(int pris) {
        spiritus.setPrisen(pris);
    }

    @Override
    public String getNavn() {
        return spiritus.getBetegnelse();
    }

    @Override
    public void setNavn(String navn) {
        spiritus.setBetegnelse(navn);
    }

    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }
}
