package com.example.lelalou_assignmentone;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortingHubController {
    //linking all the attributes
    @FXML
    private ComboBox<String> cBox;
    @FXML
    private Pane frame;
    @FXML
    private Slider slider;
   @FXML
   private Button sort;
    @FXML
    private Button reset;
    @FXML
    private Label arrSize;
    private int[] intArray;


   public int[] getArray(){
    return this.intArray;
       }

    public void createArr(int[] newArr){
       this.intArray = newArr;
    }

    //randomize without using collections shuffle
    public int[] getArrayToDisplay(int size) {

        int[] backup = new int[size];
        for (int i = 0; i < size; i++) {
            backup[i]=i;
        }

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int change = random.nextInt(size);
            int temp = backup[change];
            backup[change] = backup[i];
            backup[i] = temp;
        }

        return intArray=backup;
    }


    @FXML
    void initialize(){
       cBox.getItems().addAll("Merge Sort", "Quick Sort");
       cBox.getSelectionModel().selectFirst();
       slider.adjustValue(64);
       setSlide();

    }

    @FXML
    void setSlide(){
        createArr(getArrayToDisplay((int) slider.getValue()));
        arrSize.setText(String.valueOf((int) slider.getValue()));
        upgradeGraph(intArray);
}

    @FXML
    void clear(){
        slider.adjustValue(64);
        createArr(getArrayToDisplay((int) slider.getValue()));
        upgradeGraph(intArray);
    }


    // array size is initially set to 64 then slider can change this number
    // slider goes from 32 to 128
    // array size dictates how many rectangles are created
    @FXML
   public void upgradeGraph(int[] data){
        // rectangles in increasing size
        //array size is manipulated by slider
        //increment height
        //need to make rectangle size relative to pane

        double recW =frame.getPrefWidth()/ this.intArray.length;
        Platform.runLater(()->{
        frame.getChildren().clear();

        for (int i = 0; i < data.length; i++) {
            double recH = data[i] * frame.getPrefHeight() / data.length; // this fosters an incremental increase in height
            double x = i * recW + 0.75;
            double y = frame.getPrefHeight() - recH; // distance from top therefore find difference in heights
            Rectangle r = new Rectangle(x, y, recW - 2, recH); //-2 keeps spaces in between
            r.setFill(Color.RED);
            frame.getChildren().add(r);

        }});
    }

    @FXML
    public void setSortStrategy(){
       if (cBox.getValue()=="Merge Sort"){
           MergeSort mergeSort;
           mergeSort = new MergeSort(this);
           new Thread(mergeSort).start();
       }else if(cBox.getValue()=="Quick Sort"){
QuickSort quickSort;
quickSort = new QuickSort(this);
new Thread(quickSort).start();;
    }

}}

