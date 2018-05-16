package machineLearning;

import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.factory.MLTrainFactory;

public class SVM  extends MachineLearning{

    private final String METHOD_SVMC_A = "?->C->?";
    private final String METHOD_NAME = "?->C->?";

    @Override
    public void createMachineLearningMethod(int inputNeurons, int outputNeurons ){
        MLMethodFactory methodFactory = new MLMethodFactory();
        method = methodFactory.create(MLMethodFactory.TYPE_SVM, METHOD_SVMC_A, inputNeurons, outputNeurons);
    }

    @Override
    public void createTrainer() {
       MLTrainFactory trainFactory = new MLTrainFactory();
       train = trainFactory.create(method, trainingDataSet, MLTrainFactory.TYPE_SVM, "");
    }
}
