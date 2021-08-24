import java.io.IOException;
import java.util.List;

import algorithms.ShellSort;
import io.FileManager;
import sequences.Ciura;
import sequences.Knuth;
import sequences.Sequence;
import sequences.Shell;

public class Main {
    public static void main(String[] args) throws IOException {

        var shell = new Shell();
        var knuth = new Knuth();
        var ciura = new Ciura();
        var listOfSequences = List.of(shell, knuth, ciura);

        String entrada1 = "src/files/entrada1.txt";
        String entrada2 = "src/files/entrada2.txt";
        String saida1 = "src/files/saida1.txt";
        String saida2 = "src/files/saida2.txt";
        // Method to part1
        exec(listOfSequences, entrada1, saida1, true);
        // Method to part2
        exec(listOfSequences, entrada2, saida2, false);

    }

    private static void exec(List<Sequence> listOfSequences, String fileInput, String fileOutput, boolean option)
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

}