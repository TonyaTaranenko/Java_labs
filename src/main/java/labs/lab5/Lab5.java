package labs.lab5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) throws IOException {
        List<String> lines = SortedLineReader.readLinesSortedByLength(new File("hello.txt"));
        System.out.println("result:");
        try (PrintWriter printWriter = new PrintWriter("world.txt")) {
            for (String line : lines) {
                System.out.println(line);
                printWriter.println(line);
            }
        }
    }
}
