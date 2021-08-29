package by.epam.training.lab3.v1.build.impl;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Multiplying;
import by.epam.training.lab3.v1.entity.Plant;

public class MultiplyingBuilder implements PlantBuilder {
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        if (reader.getLocalName().equals("multiplying")) {
            plant.setMultiplying(Multiplying.valueOf(reader.getElementText()));
        }
        return plant;
    }
}