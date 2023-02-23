package com.example.lelalou_assignmentone;

public class QuickSort implements SortingStrategy{
    private SortingHubController controller;
    public QuickSort(SortingHubController controller){
        this.controller = controller;
    }
    @Override
    public void run() {
   sort(controller.getArray());

    }
    public void qSort(int[] array, int low, int high){

        if(low < high) {// base case
            int p = array[high];// selecting pivot point around end
            int l = (low - 1);//this scans the left

            for (int i = low; i <= high - 1; i++) {// the need for these nested loops to perform comparisons would be the worst case
                //scans up to right
                if (array[i] < p) {// if the pivot point is valid
                    l++;
                    int temp = array[l];// insert into respective index starting from eft to right
                    array[l] = array[i];
                    array[i] = temp;
                }

            }

            int temp = array[l + 1];
            array[l + 1] = array[high];
            array[high] = temp; //creating p
            int n = l+1;
            qSort(array,low, n-1);
            qSort(array,n+1, high);
            try {
                controller.upgradeGraph(controller.getArray());
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }


} public void sort(int[] numbers){
        qSort(numbers, 0, numbers.length-1);
    }
}
