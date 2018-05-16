package machineLearning;

import exception.MachineLearningException;

public class MachineLearningFactory {

    public static MachineLearning create(MachineLearningType type) throws MachineLearningException {
        if(type.equals(MachineLearningType.SVM)){
            return new SVM();
        } else if(type.equals(MachineLearningType.BACK_PROPAGATION)){
            return new BackPropagation();
        } else {
            throw new MachineLearningException("Cannot create machine learning method.");
        }
    }
}
