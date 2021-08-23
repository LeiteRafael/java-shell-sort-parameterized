package sequences;

import java.util.List;

public class Sequence {
    String name;
    List<Integer> sequence;

    public Sequence(String name, List<Integer> sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getSequence() {
        return this.sequence;
    }

    public int getNumberLessThan(int value) {
        for (int i = 0; i < this.sequence.size(); i++) {
            if (sequence.get(i) >= value) {
                this.sequence = this.sequence.subList(0, i);
                return sequence.get(i - 1);
            }
        }
        return this.sequence.get(this.sequence.size() - 1);
    }

    public int getValueOfIndex(int index) {
        return sequence.get(index);
    }

}
