package by.epam.training.lab3.v1.build.impl.visual;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.visual.LeafColor;

public class LeafColorBuilder implements PlantBuilder {
    private AverageSizeBuilder averageSizeBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("leaf_color")) {
            AbstractParameter parameter = new LeafColor(value, reader.getElementText());
            plant.addVisualParameter(parameter);
            return plant;
        } else {
            averageSizeBuilder = new AverageSizeBuilder();
            return averageSizeBuilder.build(plant, reader);
        }
    }
}