package com.example.lelalou_assignmentone;

import java.util.Arrays;

public class MergeSort implements SortingStrategy {
    private SortingHubController controller;
    public MergeSort(SortingHubController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        sort(controller.getArray());
    }
//in place merge
   public void merge(int[] array, int left, int middle, int right) {
       int start = middle + 1;

        if (array[middle] <= array[start])
           return;
        while (left <= middle && start <= right) {

            if (array[left] <= array[start])
               left++;
           else {
               int value = array[start];
               int index = start;

                while (index != left) {
                   array[index] = array[index - 1];
                   index--;
               }
             array[left] = value;

               left++;
               middle++;
               start++;
           }
           try {
               controller.upgradeGraph(controller.getArray());
               Thread.sleep(10);
           } catch (InterruptedException e){
               e.printStackTrace();
           }
        }
   }

 public void mergeSort(int array[], int left, int right)
  {if (left < right) {
           int middle = left + (right - left) / 2;

           mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
           merge(array, left, middle, right);
        }
    }

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}





