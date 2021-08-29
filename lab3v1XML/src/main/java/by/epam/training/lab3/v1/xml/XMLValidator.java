package by.epam.training.lab3.v1.xml;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLValidator {
    private String filename;
    private String schemaFilename;
    private ErrorHandler errorHandler;
    
    public XMLValidator(String filename, String schemaFilename) {
        this.filename = filename;
        this.schemaFilename = schemaFilename;
    }
    
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
    
    public void validate() {
        Source xmlfile = new StreamSource(filename);
        Source xmlSchema = new StreamSource(schemaFilename);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(xmlSchema);
            Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            validator.validate(xmlfile);
        } catch (SAXException | IOException e) {
            try {
                errorHandler.error(new SAXParseException(e.getMessage(), null, e));
            } catch (SAXException handlerException) {}
        }
    }
}