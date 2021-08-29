package by.epam.training.lab3.v1.build.impl;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.Soil;

public class SoilBuilder implements PlantBuilder {
    private OriginBuilder originBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        if (reader.getLocalName().equals("soil")) {
            plant.setSoil(Soil.valueOf(reader.getElementText()));
            return plant;
        } else {
            originBuilder = new OriginBuilder();
            return originBuilder.build(plant, reader);
        }
    }
}