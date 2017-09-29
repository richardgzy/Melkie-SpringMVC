package ml.melkie.model;

import java.util.ArrayList;

public class Taste {

    private Integer taste_id;
    private String taste_name;
    private Integer country_id;

    public Taste(Integer taste_id, String taste_name, Integer country_id) {
        this.taste_id = taste_id;
        this.taste_name = taste_name;
        this.country_id = country_id;
    }

    public Integer getTaste_id() {
        return taste_id;
    }

    public void setTaste_id(Integer taste_id) {
        this.taste_id = taste_id;
    }

    public String getTaste_name() {
        return taste_name;
    }

    public void setTaste_name(String taste_name) {
        this.taste_name = taste_name;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }
}
