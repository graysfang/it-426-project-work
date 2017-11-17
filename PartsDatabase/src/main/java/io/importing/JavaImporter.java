package io.importing;

/*
 * Nicholas Perez
 * 11/9/2017
 * JavaImporter.java
 *
 * Imports all CarPart objects from a text file to the application.
 * Returns PartsDatabase Object
 */

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;

/**
 * Imports all CarPart objects from a text file to the application.
 * Returns PartsDatabase Object
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class JavaImporter implements IImporter
{
    /**
     * Imports all CarPart objects from a file.
     * @return a PartsDatabase object
     */
    @Override
    public PartsDatabase importParts()
    {
        ObjectInputStream objectInputStream = null;
        Collection<CarPart> importedData = null;
        PartsDatabase partsDatabase = new PartsDatabase();

        try
        {
            objectInputStream = new ObjectInputStream(new FileInputStream("parts.dat"));
            importedData = (Collection<CarPart>)objectInputStream.readObject();

            for (CarPart part: importedData)
            {
                partsDatabase.addPart(part);
            }

            return partsDatabase;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                objectInputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return partsDatabase;
    }
}
