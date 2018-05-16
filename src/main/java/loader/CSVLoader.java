package loader;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader implements Loader {

    @Override
    public double[][] load(List<String> filePaths) {
        List<String[]> list = new ArrayList<>();
        try {
            for (String path : filePaths) {
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReader(reader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    list.add(nextRecord);
                }
            }
            double[][] results = new double[list.size()][list.get(0).length];
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(0).length; j++) {
                    results[i][j] = Double.valueOf(list.get(i)[j]);
                }
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
