package ui;

/**
 * @author Nicholas Perez
 * @version 1.0
 *
 * 10/6/2017
 * This class holds the logic and components to create the UI for a calculator.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *This class holds the logic and components to create the UI for a calculator.
 */
public class CalculatorUI extends Application
{
    private static final int BUTTON_AMOUNT = 15;
    private final int COL_WIDTH = 30;

    /**
     * Creates the applet from the assemble method
     *
     * @param stage is the applet
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Calculator!");
        stage.setScene(assemble());
        stage.show();
    }

    // Constructs the scene
    private Scene assemble()
    {
        //grid layout
        GridPane gridPane = new GridPane();
        gridPane.getColumnConstraints().addAll(
                new ColumnConstraints(COL_WIDTH),
                new ColumnConstraints(COL_WIDTH),
                new ColumnConstraints(COL_WIDTH));

        //creates the arrays of info for macking the buttons
        String[] buttonLabels = {" 7 ", " 8 ", " 9 ", " + ", " 4 ", " 5 ", " 6 ", " - ", " 1 ", " 2 ", " 3 ", " * ", " 0 ", "Enter", " / "};
        Button[] buttons = new Button[buttonLabels.length];

        //creates each button
        for (int i = 0; i < buttonLabels.length; i++)
        {
            buttons[i] = new Button(buttonLabels[i]);
        }

        //used to prevent out of bounds errors because of the grid columns and rows
        int counter = 0;

        //used to create each row and column using the buttons on the gridPane
        for (int row = 0; row <= 3; row++)
        {
            for (int column = 0; column <= 3; column++)
            {
                if (counter == BUTTON_AMOUNT)
                {
                    break;
                }
                else if (buttons[counter].getText().equals("Enter"))
                {
                    gridPane.add(buttons[counter], column, row, 4, 1);
                    buttons[counter].getStyleClass().add("enterButton");
                    column++;
                }
                else
                {
                    gridPane.add(buttons[counter], column, row);
                }
                counter++;
            }
        }

        //Creates the label/hbox and adds to gridPane
        HBox hbox = new HBox();
        Label label = new Label("");

        hbox.getChildren().add(label);
        hbox.getStyleClass().add("labelOutput");

        gridPane.add(hbox, 0, 4, 4, 1);

        //adds the css sheet link
        gridPane.getStylesheets().add("styles/styles.css");

        //returns the scene with a set height and width
        return new Scene(gridPane, 192, 195);
    }
}