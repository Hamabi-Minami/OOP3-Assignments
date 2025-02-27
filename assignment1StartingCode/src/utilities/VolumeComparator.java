package utilities;

import shapes.Shape;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o2.calcVolume(), o1.calcVolume());
    }
}
