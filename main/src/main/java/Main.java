import csv.CsvMapper;
import data.PersonData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("DZ_16\n----------------------------");

        System.out.println("First mapper");
        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(classLoader.getResource("personDataFile.csv").getFile());

        CsvMapper<PersonData> mapper = new CsvMapper(Paths.get(file.getAbsolutePath()), PersonData.class);
        List<PersonData> persons = mapper.getListOfInstance();
        persons.forEach(System.out::println);

        System.out.println("\nSecond mapper");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvMapper<PersonData> mapper2 = new CsvMapper(lines , PersonData.class);
        List<PersonData> personsFromMapper2 = mapper2.getListOfInstance();
        personsFromMapper2.forEach(System.out::println);

    }
}
