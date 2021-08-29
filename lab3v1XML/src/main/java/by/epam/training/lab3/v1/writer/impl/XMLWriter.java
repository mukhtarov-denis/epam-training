package by.epam.training.lab3.v1.writer.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.Parameter;
import by.epam.training.lab3.v1.exception.WriterException;
import by.epam.training.lab3.v1.writer.Writer;

public class XMLWriter implements Writer {
    private String filename;
    private List<Plant> plants;
    
    public XMLWriter(String filename, List<Plant> plants) {
        this.filename = filename;
        this.plants = plants;
    }
    
    @Override
    public void write() throws WriterException {
        try {
            FileOutputStream fos = new FileOutputStream(new File(filename));
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLEventWriter eventWriter = factory.createXMLEventWriter(fos, "UTF-8");
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            eventWriter.add(eventFactory.createStartDocument("UTF-8", "1.0"));
            eventWriter.add(eventFactory.createStartElement("", "", "plants"));
            eventWriter.add(eventFactory.createAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance"));
            eventWriter.add(eventFactory.createAttribute("xmlns", "http://www.epam.com/plants"));
            eventWriter.add(eventFactory.createAttribute("xsi:schemaLocation", "http://www.epam.com/plants plants.xsd"));       
            for (Plant plant : plants) {
                eventWriter.add(eventFactory.createStartElement("", "", "plant"));
                eventWriter.add(eventFactory.createAttribute(new QName("idPlant"), String.valueOf(plant.getId())));
                createSimpleNode(eventWriter, "name", plant.getName());
                createSimpleNode(eventWriter, "soil", plant.getSoil().name());
                createSimpleNode(eventWriter, "origin", plant.getOrigin());
                eventWriter.add(eventFactory.createStartElement("", "", "visuals"));
                for (Parameter parameter : plant.getVisualParameters()) {
                    createParameterNode(eventWriter, parameter);
                }
                eventWriter.add(eventFactory.createEndElement("", "", "visuals"));
                eventWriter.add(eventFactory.createStartElement("", "", "growing_tips"));
                for (Parameter parameter : plant.getGrowingTips()) {
                    createParameterNode(eventWriter, parameter);
                }
                eventWriter.add(eventFactory.createEndElement("", "", "growing_tips"));
                createSimpleNode(eventWriter, "multiplying", plant.getMultiplying().name());
                eventWriter.add(eventFactory.createEndElement("", "", "plant"));
            }
            eventWriter.add(eventFactory.createEndElement("", "", "plants"));
            eventWriter.add(eventFactory.createEndDocument());
            eventWriter.flush();
            eventWriter.close();
        } catch (FileNotFoundException e) {
            throw new WriterException(String.format("Error access file \"%s\" ...", filename), e);
        } catch (XMLStreamException e) {
            throw new WriterException("Error create XMLStreamWriter.", e);
        }
    }
    
    private void createSimpleNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        eventWriter.add(eventFactory.createStartElement("", "", name));
        eventWriter.add(eventFactory.createCharacters(value));
        eventWriter.add(eventFactory.createEndElement("", "", name));
    }
    
    private void createParameterNode(XMLEventWriter eventWriter, Parameter parameter) throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        eventWriter.add(eventFactory.createStartElement("", "", parameter.name()));
        if (!"".equals(parameter.note())) {
            eventWriter.add(eventFactory.createAttribute("note", parameter.note()));
        }
        eventWriter.add(eventFactory.createCharacters(parameter.value()));
        eventWriter.add(eventFactory.createEndElement("", "", parameter.name()));
    }
}