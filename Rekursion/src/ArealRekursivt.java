public class ArealRekursivt {

    private int a;
    private int b;

    public ArealRekursivt(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int RektangelsAreal() {
        return RektangelsAreal(this.a, this.b);
    }

    private int RektangelsAreal(int a, int b) {
        return 0;
    }
}