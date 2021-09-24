package algorithms;

import sequences.Sequence;

import java.util.ArrayList;
import java.util.List;

public class ShellSort {

    private final int[] unorderedNumbers;
    private final Sequence sequence;
    private List<String> sequenceSorted = new ArrayList<String>();
    private String timeExec;

    public ShellSort(Sequence sequence, int[] unorderedNumbers) {
        this.unorderedNumbers = unorderedNumbers;
        this.sequence = sequence;
    }

    public void sort(boolean stepByStep) {
        long start = System.nanoTime();
        if (stepByStep) mountResponse(arrayToString(unorderedNumbers) + " SEQ=" + sequence.getName());

        int length = unorderedNumbers.length;
        int sequenceNumber = sequence.getNumberLessThan(length);
        int index = sequence.getSequence().size() - 1;
        int change;
        int j;
        int trocas =0 ;

        while (sequenceNumber > 0) {
            for (int i = sequenceNumber; i < length; i++) {

                change = this.unorderedNumbers[i];
                j = i;
                while (j >= sequenceNumber && unorderedNumbers[j - sequenceNumber] > change) {
                    this.unorderedNumbers[j] = this.unorderedNumbers[j - sequenceNumber];
                    trocas++;
                    j = j - sequenceNumber;
                }
                this.unorderedNumbers[j] = change;
            }
            if (stepByStep) mountResponse(arrayToString(unorderedNumbers) + " INCR=" + sequenceNumber);
            index--;
            sequenceNumber = (index < 0) ? 0 : sequence.getValueOfIndex(index);
        }
        long end = System.nanoTime();
        double time = (double) (end - start) / 1_000_000_000;
        this.timeExec = sequence.getName() + "," + (length - 1) + "," + time;
        System.out.println("trocas: "+trocas);
    }

    public String getTimeExec() {
        return timeExec;
    }

    public List<String> getSequenceSorted() {
        return this.sequenceSorted;
    }

    private String arrayToString(int[] arr) {
        var resp = "";
        for (int value : arr) {
            resp = resp.isEmpty() ? resp + "" + value : resp + "," + value;
        }
        return resp;
    }

    private void mountResponse(String row) {
        this.sequenceSorted.add(row);
    }

}