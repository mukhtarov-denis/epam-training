package by.epam.training.lab3.v1.build.impl.tips;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.build.PlantBuilder;
import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.AbstractParameter;
import by.epam.training.lab3.v1.entity.parameter.tips.Light;

public class LightBuilder implements PlantBuilder {
    private WaterBuilder waterBuilder;
    
    @Override
    public Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException {
        String value = reader.getLocalName();
        if (value.equals("light")) {
            AbstractParameter light = new Light(value, reader.getElementText());
            plant.addGrowingTip(light);
            return plant;
        }  else {
            waterBuilder = new WaterBuilder();
            return waterBuilder.build(plant, reader);
        }
    }
}