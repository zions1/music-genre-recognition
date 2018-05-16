package mfcc;

import com.google.common.primitives.Doubles;
import org.openimaj.audio.features.MFCC;
import org.openimaj.video.xuggle.XuggleAudio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomMFCC{

    public double[][] read(List<File> files) {
        List<List<Double>> mfccs = new ArrayList<>();
        for(File file: files){
            MFCC mfcc = new MFCC(new XuggleAudio(file));
            List<Double> tmpList = new ArrayList<>();
            while (mfcc.nextSampleChunk() != null) {
                tmpList.addAll(Doubles.asList(mfcc.getLastCalculatedFeature()[0]));
            }
            mfccs.add(tmpList);
        }
        double[][] trainingSet = new double[files.size()][mfccs.size()];

        for (int i = 0; i < mfccs.size(); i++) {
            List<Double> tmpList = mfccs.get(i);
            Double[] tmpArray = tmpList.toArray(new Double[tmpList.size()]);
            trainingSet[i] = Stream.of(tmpArray).mapToDouble(Double::doubleValue).toArray();
        }
        return trainingSet;
    }
}
