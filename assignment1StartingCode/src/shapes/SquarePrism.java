package shapes;

public class SquarePrism extends Prism {
    public SquarePrism(double height, double baseEdge) {
        super(height, baseEdge);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return baseEdge * baseEdge;
    }
}
