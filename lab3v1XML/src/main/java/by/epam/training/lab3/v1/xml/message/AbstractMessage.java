package by.epam.training.lab3.v1.xml.message;

import org.xml.sax.SAXParseException;

public class AbstractMessage implements Message {
    protected Type type;
    private SAXParseException exception;
    
    public AbstractMessage(SAXParseException exception) {
        this.exception = exception;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public StringBuilder message() {
        StringBuilder message = new StringBuilder();
        message.append(type.name()).append(":").append("\n");
        message.append("system id: ").append(exception.getSystemId()).append("\n");
        message.append("line: ").append(exception.getLineNumber()).append(", ");
        message.append("column: ").append(exception.getColumnNumber()).append("\n");
        message.append(exception.getMessage());
        return message;
    }
}