package algorithms;

import java.util.Arrays;

public class BinaryInsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            System.arraycopy(array, j, array, j + 1, i - j);

            array[j] = x;
        }
    }
}