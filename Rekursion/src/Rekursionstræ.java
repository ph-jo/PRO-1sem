import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Rekursionstræ extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws InterruptedException {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);
        stage.setResizable(true);

        stage.setTitle("Recursive tree");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() throws InterruptedException {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(1500, 900);
        pane.add(canvas, 0, 0);
        this.drawTree(canvas.getGraphicsContext2D(), 200, 200, 50, 100);
        return pane;
    }

    private synchronized void drawTree(GraphicsContext gc, double x0, double y0, double len, double angle) throws InterruptedException {

        double x1 = x0 + len*Math.cos(Math.toRadians(angle));
        double y1 = y0 - len*Math.sin(Math.toRadians(angle));

        if (!(len  < 1)) {
            gc.setStroke(Color.BLUE);
            gc.strokeLine(x0, y0, x1, y1);
            drawTree(gc, x1, y1, len / 100 * 50, angle + 42);
            drawTree(gc, x1, y1, len / 100 * 50, angle - 33);
            drawTree(gc, x1, y1, len / 100 * 50, angle + 93);
            drawTree(gc, x1, y1, len / 100 * 50, angle - 60);
            drawTree(gc, x1, y1, len / 100 * 50, angle + 170);
            drawTree(gc, x1, y1, len / 100 * 50, angle - 120);
        }
    }

}
