package saver;

import exception.SaverException;
import helper.FormatExtension;

public class SaverFactory {

    public static Saver create(FormatExtension extension) throws SaverException {
        if(extension.equals(FormatExtension.CSV)){
            return new CSVSaver();
        } else {
            throw new SaverException("Invalid extension type of the file.");
        }
    }


}
