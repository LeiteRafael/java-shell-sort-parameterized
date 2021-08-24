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
        exec(listOfSequences, entrada1, saida1, 1);
        // Method to part2
        exec(listOfSequences, entrada2, saida2, 2);

    }

    private static void exec(List<Sequence> listOfSequences, String fileImput, String fileOutput, int option)
            throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        var fileManager = new FileManager();
        fileManager.readFileOf(fileImput);
        var listOfRows = fileManager.getListOfRows();

        for (List<Integer> row : listOfRows) {

            for (Sequence sequence : listOfSequences) {
                var shellSort = new ShellSort(sequence, row.stream().mapToInt(i -> i).toArray());
                if (option == 1) {
                    shellSort.sort(true);
                    stringBuilder.append(String.join("\n", shellSort.getSequenceSorted()));
                } else {
                    shellSort.sort(false);
                    stringBuilder.append(shellSort.getTimeExec());
                }
                stringBuilder.append("\n");
            }
            fileManager.writeStringInFile(fileOutput, stringBuilder.toString());
        }

    }

}