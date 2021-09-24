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
        int pivot = option ?  median(arr) : arr[generateRandon(arr.length)];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                Swap(arr, i, j);
            }
        }
        Swap(arr, i + 1, high);
        return (i + 1);
    }

    static int partitionHoare(int[] arr, int low, int high) {
        int pivot = option ?  median(arr) : arr[generateRandon(arr.length)];
        int i = low - 1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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

    private static int median(int[] arr) {
        int n = arr.length;
        int averageValue = n % 2 == 0 ? (n - 1) / 2 : n / 2;
        int[] arrayAux = {arr[0], arr[n - 1], arr[averageValue]};
        Arrays.sort(arrayAux);
        return arrayAux[arrayAux.length / 2];
    }

    private static int generateRandon(int size){
        Random rand = new Random();
        return rand.nextInt(size);
    }
}