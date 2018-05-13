package controller;

import exception.LoaderException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import service.MainService;

import java.io.File;
import java.util.List;

public class MainController {
    @FXML
    private TextArea aTextArea;


    private MainService service;

    public MainController() {
        this.service = new MainService();
    }

    public void loadSoundFiles(MouseEvent mouseEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.setInitialDirectory(new File("C:/Users/Donski/Desktop/thesis/genres"));
            List<File> selectedFile = fileChooser.showOpenMultipleDialog(null);
            selectedFile.forEach(f -> System.out.println(f.getPath()));
            service.createTrainingSet(selectedFile);
        } catch (LoaderException e) {
            e.printStackTrace();
        }
        double[][] a = service.getTrainingSet();
        System.out.println("TEST");
    }
}
