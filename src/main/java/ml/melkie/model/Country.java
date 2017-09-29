package ml.melkie.model;

import java.io.Serializable;

public class Country implements Serializable {

    private Integer country_id;
    private String country_name;
    private Integer international_student_number;

    public Country(){

    }

    public Country(Integer country_id, String country_name, Integer international_student_number) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.international_student_number = international_student_number;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Integer getInternational_student_number() {
        return international_student_number;
    }

    public void setInternational_student_number(Integer international_student_number) {
        this.international_student_number = international_student_number;
    }
}
