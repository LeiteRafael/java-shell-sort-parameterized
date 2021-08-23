package algorithms;

import sequences.Sequence;

import java.util.ArrayList;
import java.util.List;

public class ShellSort {

    int[] arr;
    Sequence sequence;
    List<String> sequenceSorted = new ArrayList<String>();

    public ShellSort(Sequence sequence, int[] arr) {
        this.arr = arr;
        this.sequence = sequence;
    }

    public void sort() {
        mountResp(arrayToString(arr) + " SEQ=" + sequence.getName());

        int n = arr.length;
        int h = sequence.getNumberLessThan(n);

        int c, j, index;
        index = sequence.getSequence().size() - 1;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = this.arr[i];
                j = i;
                while (j >= h && arr[j - h] > c) {
                    this.arr[j] = this.arr[j - h];
                    j = j - h;
                }
                this.arr[j] = c;
            }
            mountResp(arrayToString(arr) + " INCR=" + h);
            index--;

            h = (index < 0) ? 0 : sequence.getValueOfIndex(index);
        }
    }

    public String arrayToString(int[] arr) {
        var resp = "";
        for (int value : arr) {
            resp = resp.isEmpty() ? resp + "" + value : resp + "," + value;
        }
        return resp;
    }

    public void mountResp(String row) {
        this.sequenceSorted.add(row);
    }

    public List<String> getSequenceSorted() {
        return this.sequenceSorted;
    }
}