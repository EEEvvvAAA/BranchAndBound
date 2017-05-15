package evg.algorithm.impl.threemachine;

import java.util.LinkedList;
import java.util.List;

public class Set {

    private Double score;
    private Delta delta;
    private Sequence sequence;

    public Set(Matrix matrix){
        this.sequence = new Sequence(matrix.getN());
        Delta prevDelta = new Delta(0d, 0d, 0d);
        this.score = matrix.countScore(prevDelta, this);
    }

    public Set(Matrix matrix, Sequence sequence, Set parentSet){
        this.sequence = sequence;
        this.score = matrix.countScore(parentSet.delta, this);
    }

    public List<Integer> markSequence(){
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < sequence.size(); i++) {
            result.add(0);
        }
        for (Integer elem : sequence) {
            if (elem != -1) {
                result.set(elem, 1);
            }
        }
        return result;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setDelta(Delta delta) {
        this.delta = delta;
    }

    public Double getScore() {
        return score;
    }
}
