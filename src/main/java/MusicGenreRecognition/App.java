package MusicGenreRecognition;

import com.google.common.primitives.Doubles;
import org.encog.neural.networks.BasicNetwork;
import org.openimaj.audio.AudioPlayer;
import org.openimaj.audio.SampleChunk;
import org.openimaj.audio.analysis.FourierTransform;
import org.openimaj.audio.features.MFCC;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.convolution.FGaussianConvolve;
import org.openimaj.image.typography.hershey.HersheyFont;
import org.openimaj.video.xuggle.XuggleAudio;
import org.openimaj.vis.audio.AudioWaveform;
import org.openimaj.vis.general.BarVisualisation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.opencsv.CSVWriter;

import java.io.Writer;

/**
 * OpenIMAJ Hello world!
 */
public class App {
    public static void main(String[] args) {

        String path = "C:/Users/Donski/Desktop/thesis/genres/classical/classical.00020.au";
        //path = path.replace("\\", "/");

        final XuggleAudio xa = new XuggleAudio(new File(path));

        List<XuggleAudio> trainingSample = new ArrayList<>();
        trainingSample.add(new XuggleAudio(new File(path)));


        MFCC mfcc = new MFCC(xa);

        List<Double> mfccs = new ArrayList<>();

        while (mfcc.nextSampleChunk() != null) {
            mfccs.addAll(Doubles.asList(mfcc.getLastCalculatedFeature()[0]));

        }
        double[][] inputData = new double[1][mfccs.size()];
        for (int i = 0; i < mfccs.size(); i++) {
            inputData[i] = mfccs.stream().mapToDouble(d -> d).toArray();
        }

        CSVWriter csvWriter = null;
        try {
            Writer writer = Files.newBufferedWriter(Paths.get("./test.csv"));
            csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            csvWriter.writeNext(new String[]{Arrays.toString(inputData[0])});

        } catch (Exception e) {
        } finally {
            if (csvWriter != null) {
                try {
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("----------");
        for (double e : mfccs) {
            System.out.print(e);
            System.out.print(",");
        }
        System.out.println("----------");


//            vis.setData( mfccs[0] );
        //idealOutput[i] = Stream.of(tmpArray).mapToDouble(Double::doubleValue).toArray();

//        final BarVisualisation vis = new BarVisualisation(800, 400);
//        vis.showWindow("Waveform");
//
//        //play :)
//        final XuggleAudio xa = new XuggleAudio(new File(path));
//
//        SampleChunk sc = null;
//        //    while( (sc = xa.nextSampleChunk()) != null ) {
//        //   vis.setData( sc.getSampleBuffer().asDoubleArray() );
//        //  }
//
//        MFCC mfcc = new MFCC(xa);
//
//        List<Double> mfccs = new ArrayList<>();
//        while (mfcc.nextSampleChunk() != null) {
//            mfccs.addAll(Doubles.asList(mfcc.getLastCalculatedFeature()[0]));
//        }
//
//
//        for (double e : mfccs) {
//            System.out.print(e);
//            System.out.print(" ");
//        }
//        System.out.println();
//            vis.setData( mfccs[0] );


        //AudioPlayer.createAudioPlayer(xa).run();
//
//        MFCC mfcc = new MFCC( xa );
//
//        SampleChunk sc = null;
////        while( (sc = xa.nextSampleChunk()) != null )
////            vis.setData( sc.getSampleBuffer() );
//
//
//        while( (sc = mfcc.nextSampleChunk()) != null )
//        {
//            double[][] mfccs = mfcc.getLastCalculatedFeature();//getLastGeneratedFeature();
//            vis.setData( mfccs[0] );
//        }


        //Create an image
        MBFImage image = new MBFImage(320, 70, ColourSpace.RGB);

        //Fill the image with white
        image.fill(RGBColour.WHITE);

        //Render some test into the image
        image.drawText("Hello World", 10, 60, HersheyFont.CURSIVE, 50, RGBColour.BLACK);

        //Apply a Gaussian blur
        image.processInplace(new

                FGaussianConvolve(2f));

        //Display the image
        DisplayUtilities.display(image);
    }
}
