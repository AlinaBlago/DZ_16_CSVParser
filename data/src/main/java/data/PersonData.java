package data;

import annotation.CsvValue;

public class PersonData {

    @CsvValue("name")
    String name;

    @CsvValue("age")
    Integer age;

    @CsvValue("gender")
    String gender;

    @CsvValue("occupation")
    String occupation;

//    public PersonData(String name, Integer age, String gender, String occupation) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.occupation = occupation;
//    }
}
