package by.epam.training.lab3.v1.xml.message.impl;

import org.xml.sax.SAXParseException;

import by.epam.training.lab3.v1.xml.message.AbstractMessage;
import by.epam.training.lab3.v1.xml.message.Type;

public class FatalErrorMessage extends AbstractMessage {

    public FatalErrorMessage(SAXParseException exception) {
        super(exception);
        type = Type.FATAL_ERROR;
    }
}