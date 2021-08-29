package by.epam.training.lab3.v1.reader.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.build.impl.PlantBuilderImpl;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.exception.ReaderException;
import by.epam.training.lab3.v1.reader.Reader;

public class XMLReader implements Reader {
    private String filename;
    
    public XMLReader(String filename) {
        this.filename = filename;
    }
    
    @Override
    public List<Plant> read() throws ReaderException {
        Plant plant = null;
        List<Plant> plants = new ArrayList<>();
        FileInputStream fis = null;
        XMLStreamReader xmlStreamReader = null;
        XMLInputFactory xmlInputFactory = null;
        try {
            fis = new FileInputStream(new File(filename));
            xmlInputFactory = XMLInputFactory.newFactory();
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(fis);
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (type == XMLStreamReader.START_ELEMENT) {
                    PlantBuilder plantBuilder = new PlantBuilderImpl();
                    plant = plantBuilder.build(plant, xmlStreamReader);
                }               
                if (type == XMLStreamReader.END_ELEMENT) {
                    String tagName = xmlStreamReader.getLocalName();
                    if (tagName.equals("plant")) {
                        plants.add(plant);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new ReaderException(String.format("File %s not found...", filename), e);
        } catch (XMLStreamException e) {
            throw new ReaderException("Error create XMLStreamReader.", e);
        }
        
        
        return plants;
    }
}