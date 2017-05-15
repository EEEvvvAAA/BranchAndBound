package evg.algorithm.impl.salesman;

import evg.utils.DataReader;
import evg.utils.Utils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Matrix {
    private int n;
    private Double infinity;
    private double score = 0d;

    private Double[][] matrix;

    public Matrix(String filePath) throws InvalidFormatException {
        this.matrix = DataReader.getData(filePath, false);
        this.n = this.matrix.length;
        this.infinity = matrix[0][0];
        reduction();
    }

    public Matrix(Matrix M, int startPoint, int endPoint, boolean shouldBePresent){
        Double[][] m = M.getMatrix();
        n = M.getN();
        matrix = new Double[n][n];
        this.infinity = m[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (shouldBePresent && (i == startPoint || j == endPoint))
                    matrix[i][j] = infinity;
                else
                    matrix[i][j] = m[i][j];
            }
        }
        if (shouldBePresent)
            matrix[endPoint][startPoint] = infinity;
        else
            matrix[startPoint][endPoint] = infinity;

        reduction();
        score += M.getScore();
    }

    private Double[][] reduction(){
        for (int i = 0; i < n; i++) {
            Double min = Utils.getMin(matrix[i]);
            if (!infinity.equals(min)) {
                score += min;
                for (int j = 0; j < n; j++) {
                    if (min != 0 && !infinity.equals(matrix[i][j]))
                        matrix[i][j] -= min;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            Double min = Utils.getMin(matrix, j);
            if (!infinity.equals(min)) {
                score += min;
                for (int i = 0; i < n; i++) {
                    if (min != 0 && !infinity.equals(matrix[i][j]))
                        matrix[i][j] -= min;
                }
            }
        }
        return matrix;
    }

    public Double[][] getMatrix(){
        return matrix;
    }

    public int getN() {
        return n;
    }

    public double getScore() {
        return score;
    }
}
