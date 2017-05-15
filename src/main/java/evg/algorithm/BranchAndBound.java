package evg.algorithm;

import java.util.ArrayList;
import java.util.List;

public interface BranchAndBound<M, S> {

    List setsList = new ArrayList<>();

    public S decide(M matrix);

    public void devideSet(M matrix, S set);

    public S getOptSet();

}
