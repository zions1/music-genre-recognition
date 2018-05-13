package service;

import com.google.common.primitives.Doubles;
import exception.LoaderException;
import loader.AudioLoader;
import loader.Loader;
import loader.LoaderFactory;
import org.openimaj.audio.features.MFCC;
import org.openimaj.video.xuggle.XuggleAudio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainService {

    private double[][] trainingSet;
    private LoaderFactory loaderFactory;

    public MainService(){
        loaderFactory = new LoaderFactory();
    }

    public void createTrainingSet(List<File> files) throws LoaderException {
        trainingSet = loaderFactory.create(files.get(0).getAbsolutePath()).load(files);
    }


    public double[][] getTrainingSet() {
        return trainingSet;
    }
}
