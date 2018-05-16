package saver;

import exception.SaverException;
import org.junit.Before;
import org.junit.Test;
import loader.Loader;
import helper.FormatExtension;
import loader.LoaderFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CSVSaverTest {

    private final String PATH = "./test.csv";
    private Saver writer;
    private Loader loader;

    @Before
    public void setUp() throws Exception {
        writer = SaverFactory.create(FormatExtension.CSV);
        loader = LoaderFactory.create(PATH);
    }

    @Test
    public void shouldSaveAndLoadCSVFile() {
        String[][] recordsString = {{"1", "2", "3", "4"}, {"11", "22", "33", "44"}};
        double[][] recordsDouble = {{1, 2, 3, 4}, {11, 22, 33, 44}};
        try {
            writer.save(PATH, recordsString);
            List<String> filePaths = new ArrayList<>();
            filePaths.add(PATH);
            double[][] results = loader.load(filePaths);
            assertArrayEquals(results, recordsDouble);
        } catch (SaverException e) {
            assert (false);
        }
    }
}