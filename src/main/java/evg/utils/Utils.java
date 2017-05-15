package evg.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static Double getMin(Double[] vector){
        List b = Arrays.asList(vector);
        return (Double) Collections.min(b);
    }

    public static Double getMin(Double[][] matrix, int col){
        int n = matrix[0].length;
        Double[] vector = new Double[n];
        for (int i = 0; i < n; i++) {
            vector[i] = matrix[i][col];
        }
        return getMin(vector);
    }
}
