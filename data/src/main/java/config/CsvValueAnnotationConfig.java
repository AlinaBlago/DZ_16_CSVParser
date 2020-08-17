package config;

import annotation.CsvValue;
import csv.CsvMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CsvValueAnnotationConfig {
    private Map<Object, Object> map;

    public CsvValueAnnotationConfig() {
        map = CsvMapper.getResource("personDataFile.csv");

    }

    public  void configure(Object o) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> implClass = o.getClass();
        for (Field field : implClass.getFields()) {
            CsvValue annotation = field.getAnnotation(CsvValue.class);
            if (annotation != null) {
                Object value ;
                if(!annotation.value().isEmpty()){
                    value = field.getType().getConstructor(String.class).newInstance(map.get(annotation.value()));
                }else{
                    value = annotation.value();
                }
                field.setAccessible(true);
                try {
                    field.set(o, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Problem with initialization of field: " + e.getMessage());
                }
            }
        }
    }
}
