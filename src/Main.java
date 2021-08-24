import algorithms.ShellSort;
import io.FileManager;
import sequences.Ciura;
import sequences.Knuth;
import sequences.Sequence;
import sequences.Shell;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        var shell = new Shell();
        var knuth = new Knuth();
        var ciura = new Ciura();
        var listOfSequences = List.of(shell, knuth, ciura);

        String saida1 = "src/files/saida1.txt";
        String saida2 = "src/files/saida2.txt";
        StringBuilder stringBuilder = new StringBuilder();

        var fileManager = new FileManager();
        fileManager.readFileOf("src/files/entrada1.txt");
        var listOfRows = fileManager.getListOfRows();

        for (List<Integer> row : listOfRows) {

            for (Sequence sequence : listOfSequences) {
                var shellSort = new ShellSort(sequence, row.stream().mapToInt(i -> i).toArray());
                shellSort.sort();
                stringBuilder.append(String.join("\n", shellSort.getSequenceSorted()));
                stringBuilder.append("\n");
            }

        }

        fileManager.writeStringInFile(saida1, stringBuilder.toString());
        // Part 2 - Abstrair para um função
        StringBuilder stringBuilder1 = new StringBuilder();
        var fileManager1 = new FileManager();
        fileManager1.readFileOf("src/files/entrada2.txt");
        var listOfRows2 = fileManager1.getListOfRows();

        for (List<Integer> row : listOfRows2) {

            for (Sequence seq2 : listOfSequences) {
                var shellSort = new ShellSort(seq2, row.stream().mapToInt(i -> i).toArray());
                stringBuilder1.append(shellSort.sortedWithTime());
                stringBuilder1.append("\n");

            }
            fileManager.writeStringInFile(saida2, stringBuilder1.toString());
        
        }
    }

}
