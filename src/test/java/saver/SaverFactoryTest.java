package saver;

import exception.SaverException;
import helper.FormatExtension;
import org.junit.Test;

import static org.junit.Assert.*;
public class SaverFactoryTest {

    @Test
    public void shouldCreateCSVSaver() {
        try {
            Saver saver = SaverFactory.create(FormatExtension.CSV);
            assertEquals(CSVSaver.class, saver.getClass());
        } catch (SaverException e) {
            e.printStackTrace();
            assert false;
        }
    }
}