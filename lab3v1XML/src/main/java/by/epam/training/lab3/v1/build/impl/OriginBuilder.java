package by.epam.training.lab3.v1.build.impl;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.build.impl.visual.StemColorBuilder;
import by.epam.training.lab3.v1.entity.Plant;

public class OriginBuilder implements PlantBuilder {
    private StemColorBuilder stemColorBuilder; 
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        if (reader.getLocalName().equals("origin")) {
            plant.setOrigin(reader.getElementText());
            return plant;
        } else {
            stemColorBuilder = new StemColorBuilder();
            return stemColorBuilder.build(plant, reader);
        }
    }
}