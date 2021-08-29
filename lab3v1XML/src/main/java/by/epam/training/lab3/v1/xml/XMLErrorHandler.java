package by.epam.training.lab3.v1.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import by.epam.training.lab3.v1.xml.message.Message;
import by.epam.training.lab3.v1.xml.message.Type;
import by.epam.training.lab3.v1.xml.message.impl.ErrorMessage;
import by.epam.training.lab3.v1.xml.message.impl.FatalErrorMessage;
import by.epam.training.lab3.v1.xml.message.impl.WarningMessage;

public class XMLErrorHandler implements ErrorHandler {
    private List<Message> messages = new ArrayList<>();
    
    public boolean isError() {
        for (Message message : messages) {
            if (message.type() == Type.ERROR || message.type() == Type.FATAL_ERROR) {
                return true;
            }
        }
        return false;
    }
    
    public StringBuilder getErrors() {
        StringBuilder errors = new StringBuilder();
        for (Message message : messages) {
            errors.append(message.message()).append("\n");
        }
        return errors;
    }
    
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        messages.add(new WarningMessage(exception));
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        messages.add(new ErrorMessage(exception));
    }
    
    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        messages.add(new FatalErrorMessage(exception));
    }
}