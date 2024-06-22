package io.github.orionlibs.core.document.xml.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class ConvertXMLToObjectTask extends Orion
{
    public static Object run(Class<?> classToMapTheXMLData, File XMLFilePath) throws JAXBException
    {
        Assert.notNull(classToMapTheXMLData, "The given classToMapTheXMLData is null.");
        Assert.notNull(XMLFilePath, "The given XMLFilePath is null.");
        JAXBContext JAXBContext1 = JAXBContext.newInstance(classToMapTheXMLData);
        Unmarshaller JAXBUnmarshaller = JAXBContext1.createUnmarshaller();
        return JAXBUnmarshaller.unmarshal(XMLFilePath);
    }
}