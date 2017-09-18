package ml.melkie.demo.model;

import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<Taste> containTaste;

    public Country(String name, ArrayList<Taste> containTaste) {
        this.name = name;
        this.containTaste = containTaste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Taste> getContainTaste() {
        return containTaste;
    }

    public void setContainTaste(ArrayList<Taste> containTaste) {
        this.containTaste = containTaste;
    }
}
