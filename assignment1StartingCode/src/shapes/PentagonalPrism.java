package shapes;

public class PentagonalPrism extends Prism {
    public PentagonalPrism(double height, double baseEdge) {
        super(height, baseEdge);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return (5.0 / 4) * baseEdge * baseEdge / Math.tan(Math.PI / 5);
    }
}
