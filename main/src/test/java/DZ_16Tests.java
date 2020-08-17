import csv.CsvMapper;
import data.PersonData;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DZ_16Tests {

    ClassLoader classLoader = Main.class.getClassLoader();
    File file = new File(classLoader.getResource("personDataFile.csv").getFile());

    String expectedValueOfFirstName = "Mike";
    String expectedValueOfSecondName = "Beth";
    Integer expectedValueOfFirstAge = 27;
    Integer expectedValueOfSecondAge = 23;
    String expectedValueOfFirstGender = "male";
    String expectedValueOfSecondGender = "female";
    String expectedValueOfFirstOccupation = "janitor";
    String expectedValueOfSecondOccupation = "recruiter";

    @Test
    public void nameFromPath() {
        CsvMapper<PersonData> mapper = new CsvMapper(Paths.get(file.getAbsolutePath()), PersonData.class);
        List<PersonData> persons = mapper.getListOfInstance();
        assertTrue(persons.get(0).name.equals(expectedValueOfFirstName));

    }

    @Test
    public void ageFromPath() {
        CsvMapper<PersonData> mapper = new CsvMapper(Paths.get(file.getAbsolutePath()), PersonData.class);
        List<PersonData> persons = mapper.getListOfInstance();
        assertTrue(persons.get(0).age.equals(expectedValueOfFirstAge));

    }

    @Test
    public void genderFromPath() {
        CsvMapper<PersonData> mapper = new CsvMapper(Paths.get(file.getAbsolutePath()), PersonData.class);
        List<PersonData> persons = mapper.getListOfInstance();
        assertTrue(persons.get(0).gender.equals(expectedValueOfFirstGender));

    }

    @Test
    public void occupationFromPath() {
        CsvMapper<PersonData> mapper = new CsvMapper(Paths.get(file.getAbsolutePath()), PersonData.class);
        List<PersonData> persons = mapper.getListOfInstance();
        assertTrue(persons.get(0).occupation.equals(expectedValueOfFirstOccupation));

    }

    @Test
    public void nameFromLines(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvMapper<PersonData> mapper2 = new CsvMapper(lines , PersonData.class);
        List<PersonData> personsFromMapper2 = mapper2.getListOfInstance();
        assertTrue(personsFromMapper2.get(1).name.equals(expectedValueOfSecondName));
    }

    @Test
    public void ageFromLines(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvMapper<PersonData> mapper2 = new CsvMapper(lines , PersonData.class);
        List<PersonData> personsFromMapper2 = mapper2.getListOfInstance();
        assertTrue(personsFromMapper2.get(1).age.equals(expectedValueOfSecondAge));
    }

    @Test
    public void genderFromLines(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvMapper<PersonData> mapper2 = new CsvMapper(lines , PersonData.class);
        List<PersonData> personsFromMapper2 = mapper2.getListOfInstance();
        assertTrue(personsFromMapper2.get(1).gender.equals(expectedValueOfSecondGender));
    }

    @Test
    public void occupationFromLines(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvMapper<PersonData> mapper2 = new CsvMapper(lines , PersonData.class);
        List<PersonData> personsFromMapper2 = mapper2.getListOfInstance();
        assertTrue(personsFromMapper2.get(1).occupation.equals(expectedValueOfSecondOccupation));
    }


}
