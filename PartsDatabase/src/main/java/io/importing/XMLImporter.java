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
        PartsDatabase partsDatabase = null;

        try
        {
            File file = new File("parts.xml");

            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            partsDatabase = (PartsDatabase) unmarshaller.unmarshal(file);

            return partsDatabase;
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return partsDatabase;
    }
}
