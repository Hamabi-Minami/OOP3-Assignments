package utilities;

import shapes.Shape;
import java.util.*;

public enum SortAlgorithm {
    BUBBLE("b") {
        @Override
        public void sort(List<Shape> list, Comparator<Shape> comparator) {
            int n = list.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                        Collections.swap(list, j, j + 1);
                    }
                }
            }
        }
    },
    INSERTION("i") {
        @Override
        public void sort(List<Shape> list, Comparator<Shape> comparator) {
            int n = list.size();
            for (int i = 1; i < n; i++) {
                Shape key = list.get(i);
                int j = i - 1;
                while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
                list.set(j + 1, key);
            }
        }
    },
    SELECTION("s") {
        @Override
        public void sort(List<Shape> list, Comparator<Shape> comparator) {
            int n = list.size();
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                        minIndex = j;
                    }
                }
                Collections.swap(list, i, minIndex);
            }
        }
    },
    MERGE("m") {
        @Override
        public void sort(List<Shape> list, Comparator<Shape> comparator) {
            if (list.size() <= 1) return;
            int mid = list.size() / 2;
            List<Shape> left = new ArrayList<>(list.subList(0, mid));
            List<Shape> right = new ArrayList<>(list.subList(mid, list.size()));

            MERGE.sort(left, comparator);
            MERGE.sort(right, comparator);

            merge(list, left, right, comparator);
        }

        private void merge(List<Shape> list, List<Shape> left, List<Shape> right, Comparator<Shape> comparator) {
            int i = 0, j = 0, k = 0;
            while (i < left.size() && j < right.size()) {
                if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                    list.set(k++, left.get(i++));
                } else {
                    list.set(k++, right.get(j++));
                }
            }
            while (i < left.size()) {
                list.set(k++, left.get(i++));
            }
            while (j < right.size()) {
                list.set(k++, right.get(j++));
            }
        }
    },
    QUICK("q") {
        @Override
        public void sort(List<Shape> list, Comparator<Shape> comparator) {
            quickSortHelper(list, 0, list.size() - 1, comparator);
        }

        private void quickSortHelper(List<Shape> list, int low, int high, Comparator<Shape> comparator) {
            if (low < high) {
                int pi = partition(list, low, high, comparator);
                quickSortHelper(list, low, pi - 1, comparator);
                quickSortHelper(list, pi + 1, high, comparator);
            }
        }

        private int partition(List<Shape> list, int low, int high, Comparator<Shape> comparator) {
            Shape pivot = list.get(high);
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (comparator.compare(list.get(j), pivot) < 0) {
                    i++;
                    Collections.swap(list, i, j);
                }
            }
            Collections.swap(list, i + 1, high);
            return i + 1;
        }
    },
    HEAP("z") {
        @Override
        public void sort(List<Shape> list, Comparator<Shape> comparator) {
            PriorityQueue<Shape> heap = new PriorityQueue<>(comparator);
            heap.addAll(list);
            list.clear();
            while (!heap.isEmpty()) {
                list.add(heap.poll());
            }
        }
    };

    private final String key;

    SortAlgorithm(String key) {
        this.key = key;
    }

    public static SortAlgorithm fromKey(String key) {
        for (SortAlgorithm algo : values()) {
            if (algo.key.equalsIgnoreCase(key)) {
                return algo;
            }
        }
        throw new IllegalArgumentException("Invalid sorting algorithm: " + key);
    }

    public abstract void sort(List<Shape> list, Comparator<Shape> comparator);

    public String getKey() {
        return key;
    }
}
