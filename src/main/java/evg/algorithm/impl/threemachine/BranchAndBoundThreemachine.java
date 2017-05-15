package evg.algorithm.impl.threemachine;

import evg.algorithm.BranchAndBound;

import java.util.LinkedList;
import java.util.List;

public class BranchAndBoundThreemachine implements BranchAndBound<Matrix, Set> {

    @Override
    public Set decide(Matrix matrix) {
        Set set = new Set(matrix);
        setsList.add(set);
        while (true){
            if (set.getSequence().get(matrix.getN() - 1) != -1)
                return set;
            devideSet(matrix, set);
            set = getOptSet();
        }
    }

    @Override
    public void devideSet(Matrix matrix, Set set) {
        Sequence sequence = set.getSequence();
        int j = 0;
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) == -1) {
                j = i;
                break;
            }
        }
        List<Integer> marker = set.markSequence();
        for (int i = 0; i < marker.size(); i++) {
            if (marker.get(i) == 0){
                Sequence newSequence = new Sequence(sequence);
                newSequence.set(j, i);
                Set newSet = new Set(matrix, newSequence, set);
                setsList.add(newSet);
            }
        }
        setsList.remove(set);
    }

    @Override
    public Set getOptSet() {
        Set resultSet = (Set) setsList.get(0);
        Double minScore = resultSet.getScore();
        for (int i = 1; i < setsList.size(); i++) {
            Set set = (Set) setsList.get(i);
            if (minScore.compareTo(set.getScore()) > 0){
                minScore = set.getScore();
                resultSet = set;
            }
        }
        return resultSet;
    }
}
