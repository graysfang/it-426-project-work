package io.exporting;

/*
 * Nicholas Perez
 * 11/9/2017
 * JavaExporter.java
 *
 * Exports all CarPart objects in the application to a file.
 * Returns false if there are no records to write, otherwise true.
 */

import io.IExporter;
import model.CarPart;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

/**
 * Exports all CarPart objects in the application to a file.
 * Returns false if there are no records to write, otherwise true.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class JavaExporter implements IExporter
{
    private Collection<CarPart> data;

    /**
     * Exporter Constructor
     * @param data data being passed in from the UI
     */
    public JavaExporter(Collection<CarPart> data)
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
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream("parts.dat");
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fileOutputStream.close();
                outputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
