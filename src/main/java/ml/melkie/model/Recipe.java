package ml.melkie.model;

import java.util.ArrayList;

public class Recipe {

    private Integer recipe_id;
    private String recipe_name;
    private ArrayList<String> ingredients;
    private String image_url;
    private String total_time_in_seconds;
    private Double recipe_yummly_rating;
    private String direction_link;
    private final String yummly_api_statement = "Recipe search powered by Yummly";
    private final String yummly_api_logo_url = "https://static.yummly.co/api-logo.png";

    public Recipe(Integer recipe_id, String recipe_name, String direction_link) {
        this.recipe_id = recipe_id;
        this.recipe_name = recipe_name;
        this.direction_link = direction_link;
    }

    public Recipe(Integer recipe_id, String recipe_name, ArrayList<String> ingredients, String image_url, String total_time_in_seconds, Double recipe_yummly_rating, String direction_link) {
        this.recipe_id = recipe_id;
        this.recipe_name = recipe_name;
        this.ingredients = ingredients;
        this.image_url = image_url;
        this.total_time_in_seconds = total_time_in_seconds;
        this.recipe_yummly_rating = recipe_yummly_rating;
        this.direction_link = direction_link;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTotal_time_in_seconds() {
        return total_time_in_seconds;
    }

    public void setTotal_time_in_seconds(String total_time_in_seconds) {
        this.total_time_in_seconds = total_time_in_seconds;
    }

    public Double getRecipe_yummly_rating() {
        return recipe_yummly_rating;
    }

    public void setRecipe_yummly_rating(Double recipe_yummly_rating) {
        this.recipe_yummly_rating = recipe_yummly_rating;
    }

    public String getDirection_link() {
        return direction_link;
    }

    public void setDirection_link(String direction_link) {
        this.direction_link = direction_link;
    }

    public String getYummly_api_statement() {
        return yummly_api_statement;
    }

    public String getYummly_api_logo_url() {
        return yummly_api_logo_url;
    }
}
