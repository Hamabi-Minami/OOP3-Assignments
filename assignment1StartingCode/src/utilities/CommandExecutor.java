package utilities;

import java.util.Comparator;
import java.util.List;

import models.Command;
import models.SortField;
import shapes.Shape;


public class CommandExecutor {
    public static void execute(Command command) {
        SortField field = command.getSortField();
        SortAlgorithm algorithm = command.getSortAlgorithm();
        List<Shape> shapes = command.getShapes();

        Comparator<Shape> comparator = field.getComparator();

        long startTime = System.currentTimeMillis();
        algorithm.sort(shapes, comparator);
        long endTime = System.currentTimeMillis();

        System.out.println("First element is:\t" + shapes.get(0));
        for (int i = 1000; i < shapes.size(); i += 1000) {
            System.out.println(i + "-th element:\t" + shapes.get(i));
        }
        System.out.println("Last element is:\t" + shapes.get(shapes.size() - 1));

        System.out.println(algorithm.name() + " Sort run time was: " + (endTime - startTime) + " milliseconds");
    }
}

