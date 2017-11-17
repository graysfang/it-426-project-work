package io.importing;

/*
 * Nicholas Perez
 * 11/9/2017
 * XMLImporter.java
 *
 * Imports all CarPart objects from a text file to the application.
 * Returns PartsDatabase Object
 */

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Imports all CarPart objects from a text file to the application.
 * Returns PartsDatabase Object
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class XMLImporter implements IImporter
{
    /**
     * Imports all CarPart objects from a file.
     * @return a PartsDatabase object
     */
    @Override
    public PartsDatabase importParts()
    {
        PartsDatabase partsDatabase = new PartsDatabase();
        JAXBContext context = null;

        try
        {
            context = JAXBContext.newInstance(CarPart.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            CarPart myVariable = (CarPart)unmarshaller.unmarshal(new File("parts.xml"));

            partsDatabase.addPart(myVariable);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return partsDatabase;
    }
}
