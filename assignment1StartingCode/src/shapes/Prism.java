package shapes;

public abstract class Prism extends Shape {
    protected double baseEdge;

    public Prism(double height, double baseEdge) {
        this.height = height;
        this.baseEdge = baseEdge;
    }

    @Override
    public abstract double calcVolume();

    @Override
    public abstract double calcBaseArea();
}
