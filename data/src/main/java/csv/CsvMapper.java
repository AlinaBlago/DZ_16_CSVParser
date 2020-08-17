package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvMapper {

    public static Map<Object, Object> getResource(String resource) {
        URL systemResource = ClassLoader.getSystemResource(resource);
        String path = systemResource.getPath();
        try {
            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            return lines.map(line -> line.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e.getMessage());
        }
    }
}
