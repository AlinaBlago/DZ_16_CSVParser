package data;

import annotation.CsvValue;

public class PersonData {

    @CsvValue("name")
    public String name;

    @CsvValue("age")
    public Integer age;

    @CsvValue("gender")
    public String gender;

    @CsvValue("occupation")
    public String occupation;

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age + ", gender: " + gender + ", occupation: " + occupation + ".";
    }
}
