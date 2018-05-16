package machineLearning;

import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.factory.MLTrainFactory;

public class BackPropagation extends MachineLearning{

   private final String METHOD_FEEDFORWARD_A = "?:B->SIGMOID->4:B->SIGMOID->?";

    @Override
    public void createMachineLearningMethod(int inputNeurons, int outputNeurons) {
        MLMethodFactory methodFactory = new MLMethodFactory();
        method = methodFactory.create(MLMethodFactory.TYPE_FEEDFORWARD, METHOD_FEEDFORWARD_A, inputNeurons, outputNeurons);
    }

    @Override
    public void createTrainer() {
        MLTrainFactory trainFactory = new MLTrainFactory();
        train = trainFactory.create(method, trainingDataSet, MLTrainFactory.TYPE_BACKPROP, "");
    }
}
