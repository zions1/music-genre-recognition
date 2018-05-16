package machineLearning;

import org.encog.ml.MLMethod;
import org.encog.ml.MLRegression;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.util.simple.EncogUtility;

public abstract class MachineLearning {

    protected MLMethod method;
    protected MLDataSet trainingDataSet;
    protected MLDataSet testingDataSet;
    protected MLDataSet outputDataSet;
    protected MLTrain train;

    public abstract void    createMachineLearningMethod(int inputNeurons, int outputNeurons);

    public void setTrainingDataSet(double[][] inputs, double[][] ideals) {
        trainingDataSet = new BasicMLDataSet(inputs, ideals);
    }

    public void setTestingDataSet(double[][] inputs, double[][] ideals) {
        testingDataSet = new BasicMLDataSet(inputs, ideals);
    }

    public abstract void createTrainer();

    public void train(double error) {
        EncogUtility.trainToError(train, error);
        method = train.getMethod();
    }

    public void evaluateAndPrint() {
        EncogUtility.evaluate((MLRegression) method, testingDataSet);
    }

    public void evaluate() {
        outputDataSet = new BasicMLDataSet();
        for (final MLDataPair pair : testingDataSet) {
            final MLData output = ((MLRegression) method).compute(pair.getInput());
            outputDataSet.add(output, pair.getIdeal());
        }
    }

    public void printOutputData(){
        for (final MLDataPair pair : outputDataSet) {
            System.out.println("Actual="
                    + EncogUtility.formatNeuralData(pair.getInput())
                    + ", Ideal="
                    + EncogUtility.formatNeuralData(pair.getIdeal()));
        }
    }

    private MLDataSet createBasicDataSet(double[][] inputs, double[][] ideals) {
        return new BasicMLDataSet(inputs, ideals);
    }

    public void process1(String trainerName, String trainerArgs) {
//        // first, create the machine learning method
//        MLMethodFactory methodFactory = new MLMethodFactory();
//        method = methodFactory.create(methodName, methodArchitecture, inputNeurons, outputNeurons);
//
//        // second, create the data set
//        MLDataSet dataSet = new BasicMLDataSet(XOR_INPUT, XOR_IDEAL);
//
//        // third, create the trainer
//        MLTrainFactory trainFactory = new MLTrainFactory();
//        MLTrain train = trainFactory.create(method,dataSet,trainerName,trainerArgs);
//        // reset if improve is less than 1% over 5 cycles
//        if( method instanceof MLResettable && !(train instanceof ManhattanPropagation) ) {
//            train.addStrategy(new RequiredImprovementStrategy(500));
//        }
//
//        // fourth, train and evaluate.
//        EncogUtility.trainToError(train, 0.01);
//        method = train.getMethod();
//
//        //evaluate
//        MLDataSet dataSetTest = new BasicMLDataSet(XOR_INPUT_TEST, XOR_IDEAL_TEST);
//        EncogUtility.evaluate((MLRegression)method, dataSetTest);
//
//        // finally, save out what we did
//        //System.out.println("Machine Learning Type: " + methodName);
//       // System.out.println("Machine Learning Architecture: " + methodArchitecture);
//
//        System.out.println("Training Method: " + trainerName);
//        System.out.println("Training Args: " + trainerArgs);
    }


    public MLDataSet getOutputDataSet() {
        return outputDataSet;
    }

    public void setOutputDataSet(MLDataSet outputDataSet) {
        this.outputDataSet = outputDataSet;
    }
}
