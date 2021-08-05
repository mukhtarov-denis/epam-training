package by.epam.training.lab2.v1.writer.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import by.epam.training.lab2.v1.exception.WriterException;
import by.epam.training.lab2.v1.writer.TextWriter;

public class FileTextWriter implements TextWriter {

    @Override
    public void write(File file, StringBuilder text) throws WriterException {
        FileOutputStream fis = null;
        OutputStreamWriter osr = null;
        BufferedWriter bw = null;
        try {
            fis = new FileOutputStream(file);
            osr = new OutputStreamWriter(fis, "UTF-8");
            bw = new BufferedWriter(osr);
            bw.write(text.toString());
            bw.flush();
        } catch (FileNotFoundException e) {
            throw new WriterException("File not found.", e);
        } catch (IOException e) {
            throw new WriterException("Error write data to file.", e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {}
        }
    }
}