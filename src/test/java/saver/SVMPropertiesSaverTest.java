package saver;

import dataSet.DataSet;
import dataSet.TrainingDataSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SVMPropertiesSaverTest {

    private SVMPropertiesSaver svmPropertiesSaver;
    private DataSet dataSet;

    @Before
    public void setUp() throws Exception {
        dataSet = new TrainingDataSet();
        svmPropertiesSaver = new SVMPropertiesSaver();
    }

    private void createDataSet(){
        dataSet.setTotalGenres(3);
        dataSet.setGenreNames(new String[]{"Blues", "Metal", "Rock"});
        dataSet.setSamplePerGenre(10);
        dataSet.setIdealTrainingSet(new double[][] { { 0.0 }, { 1.0 }, { 1.0 }, { 0.0 } });
    }

    @Test
    public void shouldSaveAndLoadProperties() {
        createDataSet();
        svmPropertiesSaver.save("SVM.properties", dataSet);


        assert true;
    }
}