package utilities;
import models.Command;
import models.SortField;
import shapes.Shape;

import java.util.List;

public class CliParser {
    public static Command parse(String[] args) {
        System.out.println("Received arguments: " + String.join(" ", args));

        if (args.length < 3) {
            throw new IllegalArgumentException("Usage: java -jar Sort.jar -f<filename> -t<sortType> -s<sortAlgorithm>");
        }

        String fileName = null;
        SortField field = null;
        SortAlgorithm algorithm = null;

        for (String arg : args) {
            String lowerArg = arg.toLowerCase();
            if (lowerArg.startsWith("-f")) {
                fileName = arg.substring(2); // 提取文件名
            } else if (lowerArg.startsWith("-t")) {
                field = SortField.fromKey(arg.substring(2)); // 解析排序字段
            } else if (lowerArg.startsWith("-s")) {
                algorithm = SortAlgorithm.fromKey(arg.substring(2)); // 解析排序算法
            }
        }

        StringBuilder missingParams = new StringBuilder();
        if (fileName == null) missingParams.append("-f<filename> ");
        if (field == null) missingParams.append("-t<sortType> ");
        if (algorithm == null) missingParams.append("-s<sortAlgorithm> ");

        if (missingParams.length() > 0) {
            throw new IllegalArgumentException("Missing required arguments: " + missingParams.toString().trim());
        }

        List<Shape> shapes = FileHandler.readShapesFromFile(fileName);
        return new Command(shapes, field, algorithm);
    }
}


