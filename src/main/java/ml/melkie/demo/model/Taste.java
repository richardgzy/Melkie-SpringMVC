package ml.melkie.demo.model;

import java.util.ArrayList;

public class Taste {

    private String name;
    private ArrayList<Restaurant> containRestaurant;

    public Taste(String name, ArrayList<Restaurant> containRestaurant) {
        this.name = name;
        this.containRestaurant = containRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Restaurant> getContainRestaurant() {
        return containRestaurant;
    }

    public void setContainRestaurant(ArrayList<Restaurant> containRestaurant) {
        this.containRestaurant = containRestaurant;
    }
}
