package utilities;

import shapes.Prism;

import java.util.Comparator;

public class BaseAreaComparator implements Comparator<Prism>
{

    @Override
    public int compare(Prism o1, Prism o2) {
        return Double.compare(o2.calcBaseArea(), o1.calcBaseArea());
    }
}
