import config.CsvValueAnnotationConfig;
import data.PersonData;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        PersonData personData = new PersonData();
        CsvValueAnnotationConfig config = new CsvValueAnnotationConfig();
        try {
            config.configure(personData);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println(personData.);
    }
}
