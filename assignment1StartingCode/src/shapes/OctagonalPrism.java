package shapes;

public class OctagonalPrism extends Prism {
    public OctagonalPrism(double height, double baseEdge) {
        super(height, baseEdge);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * baseEdge * baseEdge;
    }
}
