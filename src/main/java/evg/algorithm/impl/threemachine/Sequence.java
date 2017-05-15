package evg.algorithm.impl.threemachine;

import org.apache.commons.lang.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class Sequence extends LinkedList<Integer>{

    //private List<Integer> sequence;

    public Sequence(int n){
        super();
        for (int i = 0; i < n; i++)
            add(-1);
        /*this.sequence = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sequence.add(-1);
        }*/
    }

    public Sequence(Sequence sequence){
        super(sequence);
    }


    @Override
    public String toString(){
        return  "{" + StringUtils.join(this, ", ") + "}";
    }
}
