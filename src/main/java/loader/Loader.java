package loader;

import java.io.File;
import java.util.List;

public interface Loader {

    double[][] load(List<File> files);
}
