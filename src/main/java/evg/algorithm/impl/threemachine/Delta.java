package evg.algorithm.impl.threemachine;

public class Delta {

    private Double deltaA;
    private Double deltaB;
    private Double deltaC;

    public Delta(Double deltaA, Double deltaB, Double deltaC) {
        this.deltaA = deltaA;
        this.deltaB = deltaB;
        this.deltaC = deltaC;
    }

    public Double getDeltaA() {
        return deltaA;
    }

    public Double getDeltaB() {
        return deltaB;
    }

    public Double getDeltaC() {
        return deltaC;
    }
}
