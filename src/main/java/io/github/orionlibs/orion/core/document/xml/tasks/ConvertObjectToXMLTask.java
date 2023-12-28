package io.github.orionlibs.orion.core.document.xml.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ConvertObjectToXMLTask extends Orion
{
    public static void run(Object objectToConvert, File XMLFile) throws JAXBException
    {
        Assert.notNull(objectToConvert, "The given objectToConvert is null.");
        Assert.notNull(XMLFile, "The given XMLFile is null.");
        JAXBContext JAXBContext1 = JAXBContext.newInstance(objectToConvert.getClass());
        Marshaller JAXBMarshaller = JAXBContext1.createMarshaller();
        JAXBMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBMarshaller.marshal(objectToConvert, XMLFile);
    }
}