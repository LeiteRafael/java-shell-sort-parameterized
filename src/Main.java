import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import algorithms.QuickSort;
import algorithms.ShellSort;
import io.FileManager;
import sequences.Ciura;
import sequences.Knuth;
import sequences.Sequence;
import sequences.Shell;

public class Main {
    public static void main(String[] args) throws IOException {


        int[] arr = {10, 7, 5, 9, 1, 23, 10, 20};
        int n = arr.length;
        var quickSort = new QuickSort();
        quickSort.setOption(false);

        quickSort.sortHoare(arr, 0, n - 1);
        System.out.println("Sorted array with Median number Hoare: ");
        printArray(arr, arr.length);
//
//
//        int[] arrHoare = {10, 7, 8, 9, 1, 5};
//        quickSort.sortHoare(arrHoare, 0, n - 1, pivot);
//        System.out.println("Sorted array with Media Hoare: ");
//        printArray(arrHoare, arrHoare.length);

//        var shell = new Shell();
//        var knuth = new Knuth();
//        var ciura = new Ciura();
//        var listOfSequences = List.of(shell, knuth, ciura);
//
//        String entrada1 = "src/files/entrada1.txt";
//        String entrada2 = "src/files/entrada2.txt";
//        String saida1 = "src/files/saida1.txt";
//        String saida2 = "src/files/saida2.txt";
        // Method to part1
        //execute(listOfSequences, entrada1, saida1, true);
        // Method to part2
        //exec(listOfSequences, entrada2, saida2, false);

    }

    private static void execute(List<Sequence> listOfSequences, String fileInput, String fileOutput, boolean option)
            throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        var fileManager = new FileManager();
        fileManager.readFileOf(fileInput);
        var listOfRows = fileManager.getListOfRows();

        for (List<Integer> row : listOfRows) {

            for (Sequence sequence : listOfSequences) {
                var shellSort = new ShellSort(sequence, row.stream().mapToInt(i -> i).toArray());
                shellSort.sort(option);
                stringBuilder.append(option ? String.join("\n", shellSort.getSequenceSorted()) : shellSort.getTimeExec());
                stringBuilder.append("\n");
            }
            fileManager.writeStringInFile(fileOutput, stringBuilder.toString());
        }

    }

    private static void printArray(int[] arr, int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }

}