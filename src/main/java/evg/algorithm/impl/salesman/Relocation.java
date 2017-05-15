package evg.algorithm.impl.salesman;

public class Relocation {
    private int startPoint;
    private int endPoint;

    public Relocation(int startPoint, int endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    @Override
    public String toString(){
        return "{" + startPoint + ", " + endPoint + "}";
    }
}
