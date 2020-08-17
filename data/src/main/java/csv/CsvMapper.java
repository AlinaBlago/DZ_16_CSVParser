package csv;

import annotation.CsvValue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class  CsvMapper<T> {
    List<T> instances;

    public CsvMapper(Path path, Class<T> classType) {
        try {
            CsvTable csvTable = CsvTable.fromFile(path).orElseThrow(() -> new RuntimeException("ERROR: EMPTY TABLE"));
            this.instances = getListOfGenericInstances(classType , csvTable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CsvMapper(List<String> lines, Class<T> classType) {
        CsvTable csvTable = CsvTable.fromLines(lines).orElseThrow(() -> new RuntimeException("ERROR: EMPTY TABLE"));
        this.instances = getListOfGenericInstances(classType , csvTable);
    }

    public List<T> getListOfInstance(){
        return this.instances;
    }

    private <T> List<T> getListOfGenericInstances(Class<T> typeOfClass, CsvTable table) {
        try {
            List<T> instanceList = new ArrayList<>();
            for (int i = 0; i < table.height(); i++) {
                T currentObject = typeOfClass.getConstructor().newInstance();
                for (Field field : typeOfClass.getFields()) {
                    CsvValue annotation = field.getAnnotation(CsvValue.class);
                    if (annotation != null) {
                        Object value;
                        if(table.getHeaders().contains(annotation.value())) {

                            if (!annotation.value().isEmpty()) {
                                value = field.getType().getConstructor(String.class).newInstance(table.get(i, annotation.value()));
                            } else {
                                value = annotation.value();
                            }
                            field.setAccessible(true);
                            try {
                                field.set(currentObject, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException("Problem with initialization of field: " + e.getMessage());
                            }
                        }
                    }
                }
                instanceList.add(currentObject);
            }
            return instanceList;
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
