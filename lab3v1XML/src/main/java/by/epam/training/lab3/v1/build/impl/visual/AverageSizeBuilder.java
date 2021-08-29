package by.epam.training.lab3.v1.build.impl.visual;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.build.impl.tips.MinTemperatureBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.visual.AverageSize;

public class AverageSizeBuilder implements PlantBuilder {
    private MinTemperatureBuilder temperatureBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("average_length")) {
            AbstractParameter parameter = new AverageSize(value, reader.getElementText());
            plant.addVisualParameter(parameter);
            return plant;
        } else {
            temperatureBuilder = new MinTemperatureBuilder();
            return temperatureBuilder.build(plant, reader);
        }
    }
}