public class Ellipser implements Figur {

    private String navn;
    private double x, y;

    public Ellipser(String navn, double x, double y) {
        this.navn = navn;
        this.x = x;
        this.y = y;
    }

    @Override
    public String getNavn() {
        return this.navn;
    }

    @Override
    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public void draw() {
        System.out.println("Ellipse");
    }

    @Override
    public double getArea() {
        return Math.PI * (Math.pow(x,2));
    }
}
