package io.exporting;

/*
 * Nicholas Perez
 * 11/9/2017
 * JSONExporter.java
 *
 * Exports all CarPart objects in the application to a file.
 * Returns false if there are no records to write, otherwise true.
 */

import com.google.gson.Gson;
import io.IExporter;
import model.CarPart;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class JSONExporter implements IExporter
{
    private Collection<CarPart> data;

    /**
     * Exporter Constructor
     * @param data data being passed in from the UI
     */
    public JSONExporter(Collection<CarPart> data)
    {
        this.data = data;
    }

    /**
     * Exports all CarPart objects in the application to a file.
     * @return Returns false if there are no records to write, otherwise true.
     */
    @Override
    public boolean exportParts()
    {
        //Exports all CarPart objects in the application to a text file.
        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("parts.json"))
        {
            gson.toJson(data, writer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //Returns false if there are no records to write, otherwise true.
        return false;
    }
}
