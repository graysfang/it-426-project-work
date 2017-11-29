package model;

/*
 * Nicholas Perez
 * 11/28/2017
 * ToDoModel.java
 *
 * This class is responsible for reading/writing all tasks to disk,
 * using .json file.
 */

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.UUID;

/**
 * This class is responsible for reading/writing all tasks to disk,
 * using .json file.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class ToDoModel extends Observable
{
    private ArrayList<ToDo> data = new ArrayList<>();

    /**
     * Default Constructor
     */
    public ToDoModel() {}

    /**
     * Adds a new task to the data structure and notifies the observer
     * and catches any extremely rare duplicate ids with a custom exception
     * @param taskMessage the message for the new to-do object
     */
    public void addTask(String taskMessage)
    {
        try
        {
            for (ToDo task: data)
            {
                if(new ToDo(taskMessage).getId().equals(task.getId()))
                {
                    throw new ExistingRecordException();
                }
            }
            data.add(new ToDo(taskMessage));
        }
        catch(ExistingRecordException ex)
        {
            System.out.println("Cannot add and existing record" + ex.getMessage());
        }

        exportTaskList(data);

        this.setChanged();

        this.notifyObservers(new Object[]{data});
    }

    /**
     * Removes a task based on the message, notifies observer
     * @param message the message of the task to be removed
     */
    public void removeByMessage(String message)
    {

        for (Iterator<ToDo> task = data.iterator(); task.hasNext();)
        {
            String taskMessage = task.next().getMessage();
            if (taskMessage.equals(message))
            {
                task.remove();
            }
        }

        exportTaskList(data);

        this.setChanged();

        this.notifyObservers(new Object[]{data});
    }

    /**
     * Updates a task's message based on its id
     * @param id the current id of a task
     * @param newMessage new message for the task found
     */
    public void updateByID(UUID id, String newMessage)
    {
        for (ToDo task: data)
        {
            try
            {
                if (task.getId() == id)
                {
                    task.setMessage(newMessage);
                }
                else
                {
                    throw new MissingRecordException();
                }
            }
            catch(MissingRecordException ex)
            {
                System.out.println("Cannot update a nonexistent record" + ex.getMessage());
            }
        }

        this.setChanged();

        this.notifyObservers(new Object[]{data});
    }

    /**
     * Removes a task based on id
     * @param id the id of the task to be removed
     */
    public void removeById(UUID id)
    {
        for (Iterator<ToDo> task = data.iterator(); task.hasNext();)
        {
            UUID taskMessage = task.next().getId();
            try
            {
                if (taskMessage.equals(id))
                {
                    task.remove();
                }
                else
                {
                    throw new MissingRecordException();
                }
            }
            catch(MissingRecordException ex)
            {
                System.out.println("Cannot remove a nonexistent record" + ex.getMessage());
            }

        }

        exportTaskList(data);

        this.setChanged();

        this.notifyObservers(new Object[]{data});
    }

    /**
     * Gets the data from the file
     * @return the data in an ArrayList
     */
    public ArrayList<ToDo> getTaskList()
    {
        return importTaskList();
    }

    //imports json file
    private ArrayList<ToDo> importTaskList()
    {
        Gson gson = new Gson();
        FileReader reader = null;

        try
        {
            reader = new FileReader("task_list.json");

            ToDo[] importedParts = gson.fromJson(reader, ToDo[].class);

            for (ToDo task : importedParts)
            {
                data.add(task);
            }
            return data;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error reading/writing from file: " + ex.getMessage());

        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException ex)
            {
                System.out.println("Error closing reader: " + ex.getMessage());
            }
        }

        return data;
    }

    //exports json file
    private void exportTaskList(ArrayList<ToDo> taskList)
    {
        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("task_list.json"))
        {
            gson.toJson(taskList, writer);
        }
        catch (IOException ex)
        {
            System.out.println("Error reading/writing from file: " + ex.getMessage());
        }
    }

    //inner class for custom exception
    private class ExistingRecordException extends Exception
    {
        public ExistingRecordException()
        {
        }

        public ExistingRecordException(String message)
        {
            super(message);
        }
    }

    //inner class for custom exception
    private class MissingRecordException  extends Exception
    {
        public MissingRecordException ()
        {
        }

        public MissingRecordException (String message)
        {
            super(message);
        }
    }
}
