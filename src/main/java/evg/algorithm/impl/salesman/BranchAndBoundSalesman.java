package evg.algorithm.impl.salesman;

import evg.algorithm.BranchAndBound;
import evg.utils.Utils;

import java.util.*;

public class BranchAndBoundSalesman implements BranchAndBound<Matrix, Set> {

    @Override
    public Set decide(Matrix matrix) {
        Set set = new Set(matrix);
        setsList.add(set);
        while (true){
            //System.out.println("Score of current set = " + set.getScore());
            if (set.getAllowedRelocations().size() == matrix.getN())
                return set;
            devideSet(set.getMatrix(), set);
//            System.out.println("List of sets:");
//            for (int j = 0; j < setsList.size(); j++) {
//                System.out.println("Set " + j + ": " + setsList.get(j).toString());
//            }
//            System.out.println();
            set = getOptSet();
        }
    }

    @Override
    public void devideSet(Matrix matrix, Set set) {
        List<Relocation> allowedRelocation = set.getAllowedRelocations();
        List<Relocation> disallowedRelocation = set.getDisallowedRelocations();

        Relocation relocation = getRelocation(set.getMatrix());
        Set set1 = new Set();
        Set set2 = new Set();

        List<Relocation> allowedRelocation1 = new ArrayList<Relocation>(allowedRelocation);
        allowedRelocation1.add(relocation);
        set1.setAllowedRelocations(allowedRelocation1);
        set1.setDisallowedRelocations(disallowedRelocation);
        set1.setMatrix(new Matrix(matrix, relocation.getStartPoint(), relocation.getEndPoint(), true));

        set2.setAllowedRelocations(allowedRelocation);
        List<Relocation> disallowedRelocation2 = new ArrayList<Relocation>(disallowedRelocation);
        disallowedRelocation2.add(relocation);
        set2.setDisallowedRelocations(disallowedRelocation2);
        set2.setMatrix(new Matrix(matrix, relocation.getStartPoint(), relocation.getEndPoint(), false));

        setsList.add(set1);
        setsList.add(set2);
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


    private static Relocation getRelocation(Matrix M){
        int n = M.getN();
        Double[][] matrix = M.getMatrix();
        Double minInStr, minInCol;
        Map<Double, Relocation> relocationMap = new HashMap<Double, Relocation>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Relocation relocation = new Relocation(i, j);
                    matrix[i][j] = matrix[i][0] + matrix[i][1] + matrix[0][j];
                    minInStr = Utils.getMin(matrix[i]);
                    minInCol = Utils.getMin(matrix, j);
                    matrix[i][j] = 0d;
                    relocationMap.put(minInStr + minInCol, relocation);
                }
            }
        }
        Double key = Collections.max(relocationMap.keySet());
        return relocationMap.get(key);
    }
}
