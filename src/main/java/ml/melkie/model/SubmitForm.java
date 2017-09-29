package ml.melkie.model;

import java.io.Serializable;

public class SubmitForm implements Serializable{
    private Country submitCountry;
//    private Taste taste;

    public SubmitForm() {
    }

    public SubmitForm(Country submitCountry) {
        this.submitCountry = submitCountry;
//        this.taste = taste; , Taste taste
    }

    public Country getSubmitCountry() {
        return submitCountry;
    }

    public void setSubmitCountry(Country country) {
        this.submitCountry = country;
    }

//    public Taste getTaste() {
//        return taste;
//    }
//
//    public void setTaste(Taste taste) {
//        this.taste = taste;
//    }
}
