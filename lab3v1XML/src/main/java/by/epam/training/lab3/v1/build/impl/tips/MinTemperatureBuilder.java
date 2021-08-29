package by.epam.training.lab3.v1.build.impl.tips;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.tips.Temperature;

public class MinTemperatureBuilder implements PlantBuilder {
    private MaxTemperatureBuilder maxTemperatureBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("min_temperature")) {
            AbstractParameter temperature = new Temperature(value, reader.getElementText());
            plant.addGrowingTip(temperature);
            return plant;
        } else {
            maxTemperatureBuilder = new MaxTemperatureBuilder();
            return maxTemperatureBuilder.build(plant, reader);
        }
    }
}