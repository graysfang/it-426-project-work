package launchers;

/*
 * Nicholas Perez
 * 12/4/2017
 * Launcher.java
 *
 * Applet Launcher
 */

import javafx.application.Application;
import ui.DoodlePadUI;

/**
 * Applet Launcher
 *
 * @author Nicholas Perez
 * @version 1.0
 */
public class Launcher
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        Application.launch(DoodlePadUI.class, args);
    }
}
