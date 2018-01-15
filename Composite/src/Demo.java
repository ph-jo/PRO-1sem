public class Demo {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();

        drawing.addFigur(new Trekanter("Trekant1", 5, 10));
        drawing.addFigur(new Trekanter("Trekant2", 10, 20));
        drawing.addFigur(new Rektangler("Rektangel1", 5, 5));

        System.out.println(drawing.getArea());
        drawing.draw();
    }
}
