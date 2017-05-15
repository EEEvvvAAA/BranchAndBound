package evg.algorithm.program;

import evg.algorithm.impl.threemachine.BranchAndBoundThreemachine;
import evg.algorithm.impl.threemachine.Matrix;
import evg.algorithm.impl.threemachine.Set;
import evg.utils.DataReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ThreeMachineMain {

    static BranchAndBoundThreemachine branchAndBound = new BranchAndBoundThreemachine();

    private static String threeMachinePath = DataReader.getFilePath("threemachine/ThreeMachine(5)_20.xlsx");
    //private static String threeMachinePath2 = DataReader.getFilePath(".xlsx");

    public static void main(String[] args) throws InvalidFormatException {
        Matrix matrix = new Matrix(threeMachinePath);
        Set result = branchAndBound.decide(matrix);

        System.out.println("Result:");
        System.out.println("Sequence: " + result.getSequence());
        System.out.println("Score: " + result.getScore());
    }
}
