package evg.algorithm.program;

import evg.algorithm.impl.salesman.BranchAndBoundSalesman;
import evg.algorithm.impl.salesman.Set;
import evg.utils.DataReader;
import evg.algorithm.impl.salesman.Matrix;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class SalesmanMain {

    static BranchAndBoundSalesman branchAndBound = new BranchAndBoundSalesman();

    private static String salesmanPath = DataReader.getFilePath("salesman/Salesman(20).xlsx");
    //private static String salesmanPath2 = DataReader.getFilePath("salesman/Salesman(6)_74.xlsx");

    public static void main(String[] args) throws InvalidFormatException {
        Matrix matrix1 = new Matrix(salesmanPath);
        long start_time = System.currentTimeMillis();
        Set result = branchAndBound.decide(matrix1);
        long finish_time = System.currentTimeMillis();

        System.out.println("Result:");
        System.out.println("Relocations: " + result.getAllowedRelocations());
        System.out.println("Score: " + result.getScore());
        System.out.println("Time of work: " + (finish_time - start_time));


//        Matrix matrix2 = new Matrix(salesmanPath2);
//        System.out.println("Result: " + BranchAndBound.decide(matrix2));
    }
}
