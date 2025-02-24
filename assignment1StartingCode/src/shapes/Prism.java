package shapes;

public abstract class Prism
{
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    double height;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    double side;
    public abstract double calcVolume();
    public abstract double calcBaseArea();
}
