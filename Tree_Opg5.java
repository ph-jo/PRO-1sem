import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Author:  Francisco
 * Project:    EAAA_PRO2
 * Date:    23-08-2017
 * Time:    10:35
 */
public class Tree_Opg5  extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("TreeRecursion");
        stage.setScene(scene);
        stage.show();

        Thread thread = new Thread(() -> drawTree(400, 600, 100, 90));
        thread.setDaemon(true);
        thread.start();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(800, 800);
        GLOBAL_PANE = pane;

        //drawTree(400, 600, 100, 90);

        return GLOBAL_PANE;
    }

    // ------------------------------------------------------------------------

    private static Pane GLOBAL_PANE;

    private void drawTree(double x0, double y0, double len, double angle) {
        double x1 = x0 + len * Math.cos(Math.toRadians(angle));
        double y1 = y0 - len * Math.sin(Math.toRadians(angle));

        if((angle > -360 && angle < 360) && len > 5) {

            Line line = new Line(x0, y0, x1, y1);
            //GLOBAL_PANE.getChildren().add(line);
            line.setStroke(GetRandomColor());

            Platform.runLater(() -> UpdatePane(line));

            double len1 = len * 0.80, len2 = len * 0.75;

            drawTree(x1, y1, len1, angle + 30);
            drawTree(x1, y1, len2, angle - 50);

        } else {
            Circle circle = new Circle(x1,y1, 5, GetRandomColor());
            //GLOBAL_PANE.getChildren().add(circle);
            Platform.runLater(() -> UpdatePane(circle));
        }


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    private Color GetRandomColor() {
        double red = new Random().nextDouble();
        double green = new Random().nextDouble();
        double blue = new Random().nextDouble();
        return new Color(red, green, blue, 0.75);
    }

    private void UpdatePane(Node node) {
        GLOBAL_PANE.getChildren().add(node);
    }
}
