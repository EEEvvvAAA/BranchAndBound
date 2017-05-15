package evg;

import evg.algorithm.impl.salesman.Matrix;
import evg.utils.DataReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    private String salesmanPath = DataReader.getFilePath("Salesman(6)_26.xlsx");
    private String expectedSalesmanPath = DataReader.getFilePath("expectedSalesman(6)_26.xlsx");

    @Test
    public void reductionShouldReturnValidMatrix() throws InvalidFormatException {
        Matrix matrix = new Matrix(salesmanPath);
        Assert.assertEquals(6, matrix.getN());
        Assert.assertEquals(21, matrix.getScore(), 0.000000001);

        Double[][] expectedMatrix = DataReader.getData(expectedSalesmanPath, false);
        Assert.assertArrayEquals(expectedMatrix, matrix.getMatrix());
    }
}
