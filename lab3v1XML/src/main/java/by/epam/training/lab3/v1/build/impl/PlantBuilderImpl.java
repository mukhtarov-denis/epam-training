package by.epam.training.lab3.v1.build.impl;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;

public class PlantBuilderImpl implements PlantBuilder {
    private NameBuilder plantNameBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        if (reader.getLocalName().equals("plant")) {
            plant = new Plant();
            String id = reader.getAttributeValue(null, "idPlant");
            try {
                plant.setId(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                plant.setId(null);
            }
            return plant;
        } else {
            plantNameBuilder = new NameBuilder();
            return plantNameBuilder.build(plant, reader);
        }
    }
}