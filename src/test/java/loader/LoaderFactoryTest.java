package loader;

import exception.LoaderException;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoaderFactoryTest {

    @Test
    public void shouldCreateCSLoader() {
        try {
            String path = "./aaa/bb/ccc.csv";
            Loader loader = LoaderFactory.create(path);
            assertEquals(CSVLoader.class, loader.getClass());
        } catch (LoaderException e) {
            e.printStackTrace();
            assert false;
        }
    }
}