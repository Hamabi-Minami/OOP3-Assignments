package models;

import shapes.Shape;
import utilities.BaseAreaComparator;
import utilities.VolumeComparator;

import java.util.Comparator;


public enum SortField {
    VOLUME("v", new VolumeComparator()) {
        @Override public double getValue(Shape shape) {
            return shape.calcVolume();
        }
    },
    HEIGHT("h", Comparator.naturalOrder()) {
        @Override public double getValue(Shape shape) {
            return shape.getHeight();
        }
    },
    BASE_AREA("a", new BaseAreaComparator()) {
        @Override public double getValue(Shape shape) {
            return shape.calcBaseArea();
        }
    };

    private final String key;
    private final Comparator<Shape> comparator;

    SortField(String key, Comparator<Shape> comparator) {
        this.key = key;
        this.comparator = comparator;
    }

    public static SortField fromKey(String key) {
        for (SortField field : values()) {
            if (field.key.equalsIgnoreCase(key)) {
                return field;
            }
        }
        throw new IllegalArgumentException("Invalid sorting field: " + key);
    }

    public Comparator<Shape> getComparator() {
        return comparator;
    }

    public abstract double getValue(Shape shape);
}


