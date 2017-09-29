package ml.melkie.model;

public class Restaurant {
    private Integer restaurant_id;
    private String restaurant_name;
    private String restaurant_address;
    private Integer restaurant_seats;
    private double restaurant_googleRating;
    private Integer likes;
    private String websiteLink;
    private String phoneNumber;
    private String restaurant_placeID;

    public Restaurant(Integer restaurant_id, String restaurant_name, Integer likes, String restaurant_placeID) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.likes = likes;
        this.restaurant_placeID = restaurant_placeID;
    }

    public Restaurant(Integer restaurant_id, String restaurant_name, String restaurant_address, int restaurant_seats, double restaurant_googleRating, int likes, String websiteLink, String phoneNumber, String restaurant_placeID) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.restaurant_address = restaurant_address;
        this.restaurant_seats = restaurant_seats;
        this.restaurant_googleRating = restaurant_googleRating;
        this.likes = likes;
        this.websiteLink = websiteLink;
        this.phoneNumber = phoneNumber;
        this.restaurant_placeID = restaurant_placeID;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public int getRestaurant_seats() {
        return restaurant_seats;
    }

    public void setRestaurant_seats(int restaurant_seats) {
        this.restaurant_seats = restaurant_seats;
    }

    public double getRestaurant_googleRating() {
        return restaurant_googleRating;
    }

    public void setRestaurant_googleRating(double restaurant_googleRating) {
        this.restaurant_googleRating = restaurant_googleRating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRestaurant_placeID() {
        return restaurant_placeID;
    }

    public void setRestaurant_placeID(String restaurant_placeID) {
        this.restaurant_placeID = restaurant_placeID;
    }
}
