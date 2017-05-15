package evg;


import evg.utils.DataReader;
import org.junit.Test;

public class BranchAndBoundTest {

    private String salesmanPath = DataReader.getFilePath("Salesman(6)_26.xlsx");

    @Test
    public void getRelocationShouldReturnValidRelocation() throws Exception {
        /*Matrix matrix = new Matrix(salesmanPath);
        Relocation relocation = BranchAndBound.getRelocation(matrix);
        Assert.assertEquals(2, relocation.getStartPoint());
        Assert.assertEquals(3, relocation.getEndPoint());*/
    }

    @Test
    public void devideSetShouldReturnValidSets() throws Exception {
        /*Matrix matrix = new Matrix(salesmanPath);
        Set set = new Set();
        set.setMatrix(matrix);
        BranchAndBound.devideSet(set);
        Assert.assertEquals(2, BranchAndBound.getSetsList().size());
        Assert.assertEquals(21, BranchAndBound.getSetsList().get(0).getScore(), 0.0000000001);
        Assert.assertEquals(26, BranchAndBound.getSetsList().get(1).getScore(), 0.0000000001);*/
    }
}
