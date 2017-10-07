package launcher;

/**
 * @author Nicholas Perez
 * @version 1.0
 *
 * 10/6/2017
 * This is hte driver class for a calculator.
 */

import javafx.application.Application;
import ui.CalculatorUI;

/**
 * This is hte driver class for a calculator.
 */
public class Launcher
{
    /**
     * Main method to launch the calculator
     * @param args is the default string array
     */
    public static void main(String[] args)
    {
        Application.launch(CalculatorUI.class, args);
    }
}
