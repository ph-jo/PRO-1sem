public class Trekanter implements Figur {

    private String navn;
    private double x, y;

    public Trekanter(String navn, double x, double y) {
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
        System.out.println("Trekant");
    }

    @Override
    public double getArea() {
        return x * y * 0.5;
    }
}
