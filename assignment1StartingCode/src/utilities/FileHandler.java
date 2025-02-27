package utilities;

import shapes.*;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static List<Shape> readShapesFromFile(String filename) {

        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\12206\\Desktop\\OOP3\\assignment1StartingCode\\res\\shapes3.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 3) continue;

                String shapeType = parts[0];
                double height = Double.parseDouble(parts[1]);
                double param = Double.parseDouble(parts[2]);

                switch (shapeType.toLowerCase()) {
                    case "cone" -> shapes.add(new Cone(height, param));
                    case "cylinder" -> shapes.add(new Cylinder(height, param));
                    case "pyramid" -> shapes.add(new Pyramid(height, param));
                    case "squareprism" -> shapes.add(new SquarePrism(height, param));
                    case "triangularprism" -> shapes.add(new TriangularPrism(height, param));
                    case "pentagonalprism" -> shapes.add(new PentagonalPrism(height, param));
                    case "octagonalprism" -> shapes.add(new OctagonalPrism(height, param));
                    default -> throw new IllegalArgumentException("Unknown shape type: " + shapeType);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + e.getMessage());
        }
        return shapes;
    }
}
