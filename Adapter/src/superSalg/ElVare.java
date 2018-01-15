package superSalg;

public class ElVare extends Vare {

    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        int pris = getPris();
        if (pris * (1 + 0.30) < pris + 3) {
            return pris+3;
        }
        else {
            return pris * (1 + 0.30);
        }
    }
}
