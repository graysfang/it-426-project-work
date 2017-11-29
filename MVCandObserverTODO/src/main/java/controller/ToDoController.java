package controller;

/*
 * Nicholas Perez
 * 11/27/2017
 * ToDoController.java
 *
 * This class contains all methods that respond to user inputs.
 */

import model.ToDo;
import model.ToDoModel;
import ui.ToDoView;

import java.util.ArrayList;

/**
 * This class contains all methods that respond to user inputs.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class ToDoController
{
    private static ToDoModel model = new ToDoModel();
    private static ToDoView view = new ToDoView();

    /**
     * Adds a new task based on the users input
     * @param taskMessage the task message to be added
     */
    public void addTask(String taskMessage)
    {
        model.addObserver(view);
        model.addTask(taskMessage);
    }

    /**
     * Marks a task as completed based on a check-box from the view
     * @param taskMessage the task message to be completed
     */
    public void completeTask(String taskMessage)
    {
        model.addObserver(view);
        model.removeByMessage(taskMessage);
    }

    /**
     * Gets the current list from the model
     * @return returns an Array list of task objects
     */
    public ArrayList<ToDo> getList()
    {
        return model.getTaskList();
    }
}
