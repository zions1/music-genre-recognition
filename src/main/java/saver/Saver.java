package saver;

import exception.SaverException;

public interface Saver {

    void save(String path, String[][] records) throws SaverException;
}
