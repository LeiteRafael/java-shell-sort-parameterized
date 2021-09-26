package algorithms;

import partitioners.Partitioner;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static boolean option;
    public int numberOfChanges;
    public int numberOfRecursions;
    private String timeExec;

    public static boolean isOption() {
        return option;
    }

    public static void setOption(boolean option) {
        QuickSort.option = option;
    }

    static void Swap(int[] array, int position1, int position2) {
        int temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    static int partitionLomuto(int[] arr, int low, int high) {
        int pivotPosition = option ?  median(arr, low, high) : generateRandon(arr.length);
        int pivot = arr[high];

        int i = (low);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                Swap(arr, i, j);
                i++;
            }
        }
        Swap(arr, i, high);
        return (i);
    }

    static int partitionHoare(int[] arr, int low, int high) {
        int pivotPosition = option ?  median(arr, low, high) : generateRandon(arr.length);
        int pivot = arr[pivotPosition];

        int i = low-1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;

            Swap(arr, i, j);

        }
    }

    public void sortLomuto(int[] arr, int low, int high) {
        long start = System.nanoTime();
        if (low < high) {
            int pi = partitionLomuto(arr, low, high);
            sortLomuto(arr, low, pi - 1);
            sortLomuto(arr, pi + 1, high);
        }
        long end = System.nanoTime();
        double time = (double) (end - start) / 1_000_000_000;
        this.timeExec = "qualquer coisa" + time;
    }

    public void sortHoare(int[] arr, int low, int high) {
        long start = System.nanoTime();
        if (low < high) {
            int pi = partitionHoare(arr, low, high);
            sortHoare(arr, low, pi);
            sortHoare(arr, pi + 1, high);
        }
        long end = System.nanoTime();
        double time = (double) (end - start) / 1_000_000_000;
        this.timeExec = "qualquer coisa" + time;
    }

    private static int median(int[] arr, int low, int high) {
        int averageValue = (low + high) % 2 == 0 ? ((low + high) - 1) / 2 : (low + high) / 2;

        if (arr[averageValue] > arr[low])
            Swap(arr, averageValue, low);
        if (arr[high] > arr[low])
            Swap(arr, high, low);
        if (arr[averageValue] > arr[high])
            Swap(arr, averageValue, high);

        return averageValue;
    }

    private static int generateRandon(int size){
        Random rand = new Random();
        return rand.nextInt(size);
    }
}