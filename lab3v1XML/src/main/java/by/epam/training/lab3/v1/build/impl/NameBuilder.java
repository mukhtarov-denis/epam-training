package by.epam.training.lab3.v1.build.impl;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;

public class NameBuilder implements PlantBuilder {
    private SoilBuilder soilBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        if (reader.getLocalName().equals("name")) {
            plant.setName(reader.getElementText());
            return plant;
        } else {
            soilBuilder = new SoilBuilder();
            return soilBuilder.build(plant, reader);
        }
    }
}