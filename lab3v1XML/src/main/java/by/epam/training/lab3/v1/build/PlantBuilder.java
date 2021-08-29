package by.epam.training.lab3.v1.build;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.training.lab3.v1.entity.Plant;

public interface PlantBuilder {
    Plant build(Plant plant, XMLStreamReader reader) throws XMLStreamException;
}