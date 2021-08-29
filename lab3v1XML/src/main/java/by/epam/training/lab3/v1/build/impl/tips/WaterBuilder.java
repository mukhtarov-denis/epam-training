package by.epam.training.lab3.v1.build.impl.tips;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.build.impl.MultiplyingBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.tips.Water;

public class WaterBuilder implements PlantBuilder {
    private MultiplyingBuilder multiplyingBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("water")) {
            AbstractParameter light = new Water(value, reader.getElementText());
            plant.addGrowingTip(light);
            return plant;
        }  else {
            multiplyingBuilder = new MultiplyingBuilder();
            return multiplyingBuilder.build(plant, reader);
        }
    }
}