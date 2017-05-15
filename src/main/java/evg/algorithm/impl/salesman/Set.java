package evg.algorithm.impl.salesman;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Set {

    private Matrix matrix;
    private Double score;
    private List<Relocation> allowedRelocations = new ArrayList<>();
    private List<Relocation> disallowedRelocations = new ArrayList<>();

    public Set(){

    }

    public Set(Matrix matrix){
        setMatrix(matrix);
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
        this.score = matrix.getScore();
    }

    public List<Relocation> getAllowedRelocations() {
        return allowedRelocations;
    }

    public void setAllowedRelocations(List<Relocation> allowedRelocations) {
        this.allowedRelocations = allowedRelocations;
    }

    public List<Relocation> getDisallowedRelocations() {
        return disallowedRelocations;
    }

    public void setDisallowedRelocations(List<Relocation> disallowedRelocations) {
        this.disallowedRelocations = disallowedRelocations;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString(){
        String allowed = StringUtils.join(allowedRelocations, ",");
        String disallowed = StringUtils.join(disallowedRelocations, ",");
        return "score = " + score + "; allowed: " + allowed + "; disallowed" + disallowed;
    }
}
