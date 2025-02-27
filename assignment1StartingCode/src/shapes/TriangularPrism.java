package shapes;

public class TriangularPrism extends Prism {
    public TriangularPrism(double height, double baseEdge) {
        super(height, baseEdge);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return 0.5 * baseEdge * baseEdge;
    }
}
