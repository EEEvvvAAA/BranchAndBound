package evg.algorithm.impl.threemachine;

import evg.utils.DataReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.util.List;

public class Matrix {
    private int n;
    private Double score = 0d;

    private Double[][] matrix;

    public Matrix(String filePath) throws InvalidFormatException {
        this.matrix = DataReader.getData(filePath, true);
        this.n = this.matrix[0].length;
    }

    public Double countScore(Delta prevDelta, Set set){
        set.setDelta(getDelta(prevDelta.getDeltaA(), prevDelta.getDeltaB(), prevDelta.getDeltaC(), set));
        return score;
    }

    private Delta getDelta(Double prevDeltaA, Double prevDeltaB, Double prevDeltaC, Set set){
        List<Integer> sequence = set.getSequence();
        List<Integer> marker = set.markSequence();
        Double sumA = 0d;
        Double minBC = -1d;
        Double sumB = 0d;
        Double minC = -1d;
        Double sumC = 0d;
        for (int i = 0; i < marker.size(); i++) {
            if (marker.get(i) == 0){
                sumA += matrix[0][i];

                Double sumBC = matrix[1][i] + matrix[2][i];
                if (minBC < 0)
                    minBC = sumBC;
                else
                    if (sumBC < minBC)
                        minBC = sumBC;

                sumB += matrix[1][i];

                Double c = matrix[2][i];
                if (minC < 0)
                    minC = c;
                else
                if (c < minC)
                    minC = c;

                sumC += c;
            }
        }
        int j = -1;
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) != -1)
                j = i;
        }
        Double A = prevDeltaA + ((j == -1) ? 0 : matrix[0][sequence.get(j)]);
        Double deltaA = A + sumA + minBC;
        Double B = Math.max(A, prevDeltaB) + ((j == -1) ? 0 :matrix[1][sequence.get(j)]);
        Double deltaB = B + sumB + minC;
        Double C = Math.max(B, prevDeltaC) + ((j == -1) ? 0 : matrix[2][sequence.get(j)]);
        Double deltaC = C + sumC;
        score = Math.max(deltaA, Math.max(deltaB, deltaC));
        return new Delta(A, B, C);
    }



    public int getN() {
        return n;
    }
}
