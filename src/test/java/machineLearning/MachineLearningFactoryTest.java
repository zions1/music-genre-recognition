package machineLearning;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MachineLearningFactoryTest {

    /**
     * The input necessary for XOR.
     */
    public static double XOR_INPUT[][] = { { 0.0, 0.0 }, { 1.0, 0.0 }, { 0.0, 1.0 }, { 1.0, 1.0 } };

    /**
     * The ideal data necessary for XOR.
     */
    public static double XOR_IDEAL[][] = { { 0.0 }, { 1.0 }, { 1.0 }, { 0.0 } };


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldCreateSVM(){
//        SVM svm = (SVM) MachineLearningFactory.create(MachineLearningType.SVM);
//        assertEquals(svm.getClass(), SVM.class);
    }

    @Test
    public void shouldSVM(){
//        SVM svm = (SVM) MachineLearningFactory.create(MachineLearningType.SVM);
//        svm.createMachineLearningMethod(2, 1);
//        svm.setTrainingDataSet(XOR_INPUT, XOR_IDEAL);
//        svm.createTrainer();
//        svm.train(0.01);
//        svm.setTestingDataSet(XOR_INPUT, XOR_IDEAL);
//        svm.evaluate();
//        svm.printOutputData();
    }

    @Test
    public void shouldBackPropagation(){
//        BackPropagation backPropagation = (BackPropagation) MachineLearningFactory.create(MachineLearningType.BACK_PROPAGATION);
//        backPropagation.createMachineLearningMethod(2, 1);
//        backPropagation.setTrainingDataSet(XOR_INPUT, XOR_IDEAL);
//        backPropagation.createTrainer();
//        backPropagation.train(0.01);
//        backPropagation.setTestingDataSet(XOR_INPUT, XOR_IDEAL);
//        backPropagation.evaluate();
//        backPropagation.printOutputData();
    }

}