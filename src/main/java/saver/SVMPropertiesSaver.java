package saver;

import com.opencsv.CSVWriter;
import dataSet.DataSet;
import exception.SaverException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

public class SVMPropertiesSaver implements PropertiesSaver{


    @Override
    public void save(String path, DataSet dataSet){
        try {
            Properties properties = new Properties();
            if (dataSet.getTotalGenres() != 0) {
                properties.setProperty("TotalGenres", String.valueOf(dataSet.getTotalGenres()));
            }
            if (dataSet.getGenreNames() != null) {
                properties.setProperty("GenreNames", Arrays.toString(dataSet.getGenreNames()));
            }
            if (dataSet.getSamplePerGenre() != 0) {
                properties.setProperty("SamplePerGenre", String.valueOf(dataSet.getSamplePerGenre()));
            }
            if (dataSet.getIdealTrainingSet() != null) {
                properties.setProperty("IdealTrainingSet", Arrays.deepToString(dataSet.getIdealTrainingSet()));
            }

            FileOutputStream fos = new FileOutputStream(new File(path));
            properties.store(fos, "SVM Properties");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
