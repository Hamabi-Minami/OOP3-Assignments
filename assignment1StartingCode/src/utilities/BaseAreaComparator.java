package utilities;

import shapes.Shape;

import java.util.Comparator;

public class BaseAreaComparator implements Comparator<Shape>
{

    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o2.calcBaseArea(), o1.calcBaseArea());
    }
}
