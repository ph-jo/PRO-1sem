import java.util.ArrayList;
import java.util.List;

public class Drawing implements Figur {

    private List<Figur> figurer;

    public Drawing() {
        figurer = new ArrayList<>();
    }

    @Override
    public String getNavn() {
        return null;
    }

    @Override
    public void setNavn(String navn) {

    }

    @Override
    public void draw() {
        for (Figur figur : figurer) {
            System.out.println(figur.getNavn());
        }
    }

    @Override
    public double getArea() {
        double area = 0;
        for (Figur figur : figurer) {
            area = area + figur.getArea();
        }
        return area;
    }

    public void addFigur(Figur figur) {
        this.figurer.add(figur);
    }

    public void removeFigur(Figur figur) {
        this.figurer.add(figur);
    }

    public List<Figur> getFigurer() {
        return this.figurer;
    }
}
