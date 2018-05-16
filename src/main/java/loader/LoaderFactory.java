package loader;

import exception.LoaderException;
import helper.FormatExtension;

public class LoaderFactory {

    public static Loader create(String path) throws LoaderException {
        String extension = getExtension(path, ".");
        if(extension.equals(FormatExtension.CSV.toString())){
            return new CSVLoader();
//        } else if(extension.equals(FormatExtension.AUDIO_AU.toString())){
//            return new AudioCustomReader();
        } else {
            throw new LoaderException("Invalid extension type of the file.");
        }
    }

    private static String getExtension(String path, String extensionSeparator) {
        return path.substring(path.lastIndexOf(extensionSeparator) + 1);
    }

    public CSVLoader createCSVReader() {
        return new CSVLoader();
    }
}
