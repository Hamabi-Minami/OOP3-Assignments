package appDomain;


import models.Command;

import utilities.CliParser;
import utilities.CommandExecutor;


public class AppDriver {
    public static void main(String[] args) {

        // refer to demo001 BasicFileIO.java for a simple example on how to
        // read data from a text file

        // refer to demo01 Test.java for an example on how to parse command
        // line arguments and benchmarking tests

        // refer to demo02 Student.java for comparable implementation, and
        // NameCompare.java or GradeCompare for comparator implementations

        // refer to demo02 KittySort.java on how to use a custom sorting
        // algorithm on a list of comparables to sort using either the
        // natural order (comparable) or other orders (comparators)

        try {
            Command command = CliParser.parse(args);
            CommandExecutor.execute(command);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Usage: java -jar Sort.jar -f<filename> -t<sortType> -s<sortAlgorithm>");
        }
    }
}
