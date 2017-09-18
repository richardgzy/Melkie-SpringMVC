package ml.melkie.demo.model;

public class Restaurant {
    private String name;
    private String address;
    private int seats;
    private double googleRating;
    private int likes;
    private String websiteLink;
    private String phoneNumber;

    public Restaurant(String name, String address, int seats, double googleRating, int likes, String websiteLink, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.seats = seats;
        this.googleRating = googleRating;
        this.likes = likes;
        this.websiteLink = websiteLink;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getGoogleRating() {
        return googleRating;
    }

    public void setGoogleRating(double googleRating) {
        this.googleRating = googleRating;
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
}
