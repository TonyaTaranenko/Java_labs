package labs.lab5;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortedLineReaderTest {
    @Test
    void testGetLinesSortedByLength() throws IOException {
        List<String> lines = SortedLineReader.readLinesSortedByLength(new File("hello.txt"));
        for (int i = 1; i < lines.size(); i++) {
            assertTrue(lines.get(i).length() >= lines.get(i - 1).length());
        }
    }
}
