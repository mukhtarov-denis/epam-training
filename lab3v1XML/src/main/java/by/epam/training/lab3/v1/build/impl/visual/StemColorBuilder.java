package by.epam.training.lab3.v1.build.impl.visual;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.visual.StemColor;

public class StemColorBuilder implements PlantBuilder {
    private LeafColorBuilder leafColorBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("stem_color")) {
            AbstractParameter parameter = new StemColor(value, reader.getElementText());
            plant.addVisualParameter(parameter);
            return plant;
        } else {
            leafColorBuilder = new LeafColorBuilder();
            return leafColorBuilder.build(plant, reader);
        }
    }
}