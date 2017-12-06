package drawing;
/*
 * Nicholas Perez
 * 12/1/2017
 * Drawing.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
    import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Drawing extends Application
{



    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Drawing in Canvas");
        stage.setScene(getScene());
        stage.show();
    }

    public Scene getScene()
    {
        VBox box = new VBox();
        Canvas canvas = new Canvas(500, 500);

        box.getChildren().add(canvas);

        box.setStyle("-fx-color: #000000;");

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

                double x = event.getX();
                double y = event.getY();

                //draw a line
//                graphicsContext.setStroke(Color.CHARTREUSE);
//                graphicsContext.setLineWidth(5);
//                graphicsContext.strokeLine(x,y,x+10,y+10);

                // draw a rec and fill it
//                graphicsContext.setStroke(Color.TEAL);
//                graphicsContext.setFill(Color.CHARTREUSE);
//                graphicsContext.setLineWidth(2);
//
//                graphicsContext.fillRect(x,y,100, 100);
//                graphicsContext.strokeRect(x,y,100, 100);

                graphicsContext.setFill(Color.PINK);
                //graphicsContext.fillPolygon(new double[]{x, x+20,x+40, x+30, x+10},new double[]{y, y-10, y,y+10,y+10},5);
                graphicsContext.fillPolygon(new double[]{x, x+50,x+100},new double[]{y, y-10, y},3);
            }
        });

        return new Scene(box, 500, 500);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
