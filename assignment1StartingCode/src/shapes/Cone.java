package shapes;

public class Cone extends Shape {
    private double radius;

    public Cone(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;
    }
}
