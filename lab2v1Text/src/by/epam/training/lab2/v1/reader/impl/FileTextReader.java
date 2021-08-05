package by.epam.training.lab2.v1.reader.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import by.epam.training.lab2.v1.exception.FileReaderException;
import by.epam.training.lab2.v1.reader.TextReader;

public class FileTextReader implements TextReader {
    private File file;    
    
    public FileTextReader(File file) {
        this.file = file;
    }
        
    @Override
    public StringBuilder read() throws FileReaderException {
        StringBuilder result = new StringBuilder();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new FileReaderException("File " + "\"" + file + "\"" + " not found", e);
        } catch (IOException e) {
            throw new FileReaderException("Error read file", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {}
        }
    }
}