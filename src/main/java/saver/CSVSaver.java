package saver;

import com.opencsv.CSVWriter;
import exception.SaverException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVSaver implements Saver {

    @Override
    public void save(String path, String[][] records) throws SaverException {
        CSVWriter csvWriter = null;
        try {
            Writer customWriter = Files.newBufferedWriter(Paths.get(path));
            csvWriter = new CSVWriter(customWriter,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            for (String[] record : records) {
                csvWriter.writeNext(record);
            }
        } catch (IOException e) {
            throw new SaverException("", e.getCause());
        } finally {
            if (csvWriter != null) {
                try {
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
