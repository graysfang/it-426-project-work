package io.exporting;

/*
 * Nicholas Perez
 * 11/9/2017
 * XMLExporter.java
 *
 * Exports all CarPart objects in the application to a file.
 * Returns false if there are no records to write, otherwise true.
 */

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Collection;

/**
 * Exports all CarPart objects in the application to a file.
 * Returns false if there are no records to write, otherwise true.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class XMLExporter implements IExporter
{
    private Collection<CarPart> data;

    /**
     * Exporter Constructor
     * @param data data being passed in from the UI
     */
    public XMLExporter(Collection<CarPart> data)
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
        JAXBContext context = null;
        try
        {
            PartsDatabase partsDatabase = new PartsDatabase();

            File file = new File("parts.xml");
            context = JAXBContext.newInstance(PartsDatabase.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            for (CarPart part: data)
            {
                partsDatabase.addPart(part);
            }

            marshaller.marshal(partsDatabase, file);
            return true;
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
