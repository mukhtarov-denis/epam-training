package by.epam.training.lab3.v1.xml.message.impl;

import org.xml.sax.SAXParseException;

import by.epam.training.lab3.v1.xml.message.AbstractMessage;
import by.epam.training.lab3.v1.xml.message.Type;

public class WarningMessage extends AbstractMessage {

    public WarningMessage(SAXParseException exception) {
        super(exception);
        type = Type.WARNING;
    }
}