package ui;
/*
 * Nicholas Perez
 * 12/4/2017
 * DoodlePadUI.java
 *
 * DESCRIPTION
 */



import adapters.*;
import drawing.IShape;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.*;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class DoodlePadUI extends Application
{

    /**
     *  Loads the stage
     * @param stage
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Doodle Pad");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene()
    {
        VBox box = new VBox();
        box.getStylesheets().add("styles.css");

        HBox toolBar = new HBox();
        toolBar.setSpacing(10);
        toolBar.setAlignment(Pos.CENTER);
        toolBar.setPadding(new Insets(10));

        String[] toggles = {"Circle","Square","Triangle","Hexagon","Line"};
        ToggleButton[] toggleButtons = new ToggleButton[toggles.length];
        ToggleGroup toggleGroup = new ToggleGroup();
        HBox toggleBox = new HBox();

        toggleBox.setAlignment(Pos.CENTER_LEFT);

        for(int i = 0; i<toggles.length; i++)
        {
            toggleButtons[i] = new ToggleButton(toggles[i]);

            if(i==4)
            {
                toggleButtons[i].setSelected(true);
            }

            toggleButtons[i].setUserData(toggles[i]);
            toggleButtons[i].setToggleGroup(toggleGroup);
            toggleBox.getChildren().add(toggleButtons[i]);
        }

        ColorPicker colorPicker = new ColorPicker(Color.BLACK);

        CheckBox fillCheck = new CheckBox("Fill");

        Label sizeLabel = new Label("Size");
        TextField sizeField = new TextField();
        sizeField.setPrefColumnCount(2);
        sizeField.setText("1");
        sizeField.setMinWidth(10);
        sizeLabel.setPadding(new Insets(3,0,0,0));
        HBox sizeAndThickSet = new HBox();
        sizeAndThickSet.getChildren().addAll(sizeLabel, sizeField);
        sizeAndThickSet.setSpacing(5);
        sizeAndThickSet.setPadding(new Insets(15,0,0,0));

        HBox sliderBox = new HBox();
        sliderBox.setPadding(new Insets(15,0,0,0));
        Slider slider = new Slider();
        slider.setMin(1);
        slider.setMax(10);
        slider.setValue(1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(0);
        slider.setBlockIncrement(1);
        sliderBox.getChildren().add(slider);

        toolBar.getChildren().addAll(
                toggleBox,
                colorPicker,
                fillCheck,
                sizeAndThickSet,
                sliderBox
        );

        Canvas canvas = new Canvas(900, 550);
        VBox canvasBox = new VBox();
        canvasBox.getStyleClass().add("canvas-box-style");
        canvasBox.setPadding(new Insets(5));

        canvasBox.getChildren().add(canvas);
        box.getChildren().addAll(toolBar, canvasBox);

        canvas.setOnMouseClicked(event ->
        {
            String currentToggle = (String) toggleGroup.getSelectedToggle().getUserData();
            GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

            int size = Integer.parseInt(sizeField.getText());

            double x = event.getX()-(size/2);
            double y = event.getY()-(size/2);

            switch (currentToggle)
            {
                case "Circle":
                    IShape circle = new CircleAdapter(new Circle(size,x, y,slider.getValue(), colorPicker.getValue(), false));
                    circle.setThickness(slider.getValue());
                    circle.setFilled(fillCheck.isSelected());
                    circle.setColor(colorPicker.getValue());

                    circle.drawShape(graphicsContext);
                    break;

                case "Square":
                    IShape rectangle = new RectangleAdapter(new Rectangle(x,y,size,size,slider.getValue(), colorPicker.getValue(), false));
                    rectangle.setThickness(slider.getValue());
                    rectangle.setFilled(fillCheck.isSelected());
                    rectangle.setColor(colorPicker.getValue());
                    rectangle.drawShape(graphicsContext);
                    break;

                case "Triangle":
                    IShape triangle = new TriangleAdapter(new Triangle(event.getX()-(size/2), event.getY()+(size/2),size, size, slider.getValue(), colorPicker.getValue(), false));
                    triangle.setThickness(slider.getValue());
                    triangle.setFilled(fillCheck.isSelected());
                    triangle.setColor(colorPicker.getValue());
                    triangle.drawShape(graphicsContext);
                    break;

                case "Hexagon":
                    IShape hexagon = new HexagonAdapter(new Hexagon(event.getX()-(size/2), event.getY()+(size/2),size, size, slider.getValue(), colorPicker.getValue(), false));
                    hexagon.setThickness(slider.getValue());
                    hexagon.setFilled(fillCheck.isSelected());
                    hexagon.setColor(colorPicker.getValue());
                    hexagon.drawShape(graphicsContext);
                    break;

                case "Line":
                    IShape line = new LineAdapter(new Line(event.getX()-(size/2),event.getY(),x+(size),event.getY(),slider.getValue(),colorPicker.getValue(),true));
                    line.setThickness(slider.getValue());
                    line.setFilled(fillCheck.isSelected());
                    line.setColor(colorPicker.getValue());
                    line.drawShape(graphicsContext);
                    break;
                default:
                        break;
            }
        });
        return new Scene(box, 950,600);
    }
}
