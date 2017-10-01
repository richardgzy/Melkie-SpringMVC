package ml.melkie.model;

public class Grocery {
    private Integer grocery_id;
    private String grocery_name;
    private String grocery_place_id;
    private Double latitude;
    private Double longitude;

    public Grocery(Integer grocery_id, String grocery_name, String grocery_place_id) {
        this.grocery_id = grocery_id;
        this.grocery_name = grocery_name;
        this.grocery_place_id = grocery_place_id;
    }

    public Grocery(Integer grocery_id, String grocery_name, String grocery_place_id, Double latitude, Double longitude) {
        this.grocery_id = grocery_id;
        this.grocery_name = grocery_name;
        this.grocery_place_id = grocery_place_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getGrocery_id() {
        return grocery_id;
    }

    public void setGrocery_id(Integer grocery_id) {
        this.grocery_id = grocery_id;
    }

    public String getGrocery_name() {
        return grocery_name;
    }

    public void setGrocery_name(String grocery_name) {
        this.grocery_name = grocery_name;
    }

    public String getGrocery_place_id() {
        return grocery_place_id;
    }

    public void setGrocery_place_id(String grocery_place_id) {
        this.grocery_place_id = grocery_place_id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
