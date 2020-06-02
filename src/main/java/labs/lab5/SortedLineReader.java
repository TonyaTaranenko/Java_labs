package labs.lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortedLineReader {
    public static List<String> readLinesSortedByLength(File file) throws IOException {
        List<String> ret = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ret.add(line);
            }
        }
        bubbleSort(ret);
        return ret;
    }

    private static void bubbleSort(List<String> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            for (int j = 0; j < lines.size() - i - 1; j++) {
                if (lines.get(j).length() > lines.get(j + 1).length()) {
                    String tmp = lines.get(j);
                    lines.set(j, lines.get(j + 1));
                    lines.set(j + 1, tmp);
                }
            }
        }
    }
}
