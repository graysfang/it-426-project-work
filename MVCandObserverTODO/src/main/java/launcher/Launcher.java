package launcher;

/*
 * Nicholas Perez
 * 11/27/2017
 * Launcher.java
 *
 * Launcher to run the task app.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import ui.ToDoView;

/**
 * Launcher to run the task app.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Launcher extends Application
{
    /**
     * Displays the stage
     * @param stage the stage to be displayed
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Task List");
        stage.setScene(ToDoView.home(stage));
        stage.show();
    }

    /**
     * Runs the application
     * @param args default psvm param
     */
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
