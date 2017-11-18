package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@XmlRootElement
public class PartsDatabase
{
    private Collection<CarPart> parts;

    public PartsDatabase()
    {
        parts = new ArrayList<CarPart>();
    }

    public void addPart(CarPart part)
    {
        parts.add(part);
    }

    @XmlElement
    public Collection<CarPart> getParts()
    {
        return parts;
    }

    public void clear()
    {
        parts.clear();
    }
}
