package by.epam.training.lab3.v1.build.impl.tips;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.tips.Temperature;

public class MaxTemperatureBuilder implements PlantBuilder {
    private LightBuilder lightBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("max_temperature")) {
            AbstractParameter temperature = new Temperature(value, reader.getElementText());
            plant.addGrowingTip(temperature);
            return plant;
        } else {
            lightBuilder = new LightBuilder();
            return lightBuilder.build(plant, reader);
        }
    }
}