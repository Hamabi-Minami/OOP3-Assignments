package shapes;

public class Pyramid extends Shape {
    private double baseEdge;

    public Pyramid(double height, double baseEdge) {
        this.height = height;
        this.baseEdge = baseEdge;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * baseEdge * baseEdge * height;
    }

    @Override
    public double calcBaseArea() {
        return baseEdge * baseEdge;
    }
}
