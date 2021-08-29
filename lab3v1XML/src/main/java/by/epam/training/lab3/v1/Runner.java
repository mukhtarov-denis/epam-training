package by.epam.training.lab3.v1;

import java.util.Collections;
import java.util.List;

import by.epam.training.lab3.v1.comparator.NameComparator;
import by.epam.training.lab3.v1.comparator.WaterComparator;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.exception.ApplicationException;
import by.epam.training.lab3.v1.exception.ReaderException;
import by.epam.training.lab3.v1.exception.WriterException;
import by.epam.training.lab3.v1.reader.Reader;
import by.epam.training.lab3.v1.reader.impl.XMLReader;
import by.epam.training.lab3.v1.writer.Writer;
import by.epam.training.lab3.v1.writer.impl.XMLWriter;
import by.epam.training.lab3.v1.xml.XMLErrorHandler;
import by.epam.training.lab3.v1.xml.XMLValidator;

public class Runner {
    private final String XML_FILE = "plants.xml";
    
    public void run() throws ApplicationException {
        String newFilename = "";
        XMLValidator xmlValidator = new XMLValidator(XML_FILE, "plants.xsd");
        XMLErrorHandler errorHandler = new XMLErrorHandler();
        xmlValidator.setErrorHandler(errorHandler);
        xmlValidator.validate();
        if (errorHandler.isError()) {
            throw new ApplicationException(
                    String.format("Error validate file \"%s\"\n", XML_FILE),
                    new Exception(errorHandler.getErrors().toString()));
        }
        try {
            List<Plant> plants = null;
            Reader xmlReader = new XMLReader(XML_FILE);
            plants = xmlReader.read();
            Collections.sort(plants, new NameComparator());
            newFilename = "plants_sort_by_name.xml";
            Writer writer = new XMLWriter(newFilename, plants);
            writer.write();
            Collections.sort(plants, new WaterComparator());
            newFilename = "plants_sort_by_water.xml";
            writer = new XMLWriter(newFilename, plants);
            writer.write();
        } catch (ReaderException e) {
            throw new ApplicationException(String.format("Error read file \"%s\"...", XML_FILE), e);
        } catch (WriterException e) {
            throw new ApplicationException(String.format("Error write file \"%s\"...", newFilename), e);
        }    
    }
}