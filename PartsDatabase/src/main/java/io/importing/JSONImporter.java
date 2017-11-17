package io.importing;

/*
 * Nicholas Perez
 * 11/9/2017
 * JSONImporter.java
 *
 * Imports all CarPart objects from a text file to the application.
 * Returns PartsDatabase Object
 */

import com.google.gson.Gson;
import io.IImporter;
import model.CarPart;
import model.PartsDatabase;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Imports all CarPart objects from a text file to the application.
 * Returns PartsDatabase Object
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class JSONImporter implements IImporter
{
    /**
     * Imports all CarPart objects from a file.
     * @return a PartsDatabase object
     */
    @Override
    public PartsDatabase importParts()
    {
        Gson gson = new Gson();
        PartsDatabase partsDatabase = new PartsDatabase();
        FileReader reader = null;

        try
        {
            reader = new FileReader("parts.json");
            CarPart[] importedParts = gson.fromJson(reader, CarPart[].class);


            for (CarPart aPart :importedParts)
            {
                partsDatabase.addPart(aPart);
            }

            return partsDatabase;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return partsDatabase;
    }
}
