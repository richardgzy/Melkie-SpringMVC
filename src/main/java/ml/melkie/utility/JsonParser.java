package ml.melkie.utility;

import ml.melkie.model.Recipe;
import ml.melkie.model.Restaurant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public static Restaurant parseRestaurantinfo(String input, Restaurant incompleteRestaurant) {

        try {
            JSONObject jo = new JSONObject(input);

            String status = jo.getString("status");
            if (status.equals("OK")){
                JSONObject result = jo.getJSONObject("result");

                String formatted_address = result.getString("formatted_address");
                Double google_rating = result.getDouble("rating");
                String phone_number = "";
                if(result.has("formatted_phone_number")){
                    phone_number = result.getString("formatted_phone_number");
                }else{
                    phone_number = "Not available";
                }
                String website_link = result.getString("website");

                incompleteRestaurant.setRestaurant_address(formatted_address);
                incompleteRestaurant.setPhoneNumber(phone_number);
                incompleteRestaurant.setRestaurant_googleRating(google_rating);
                incompleteRestaurant.setWebsiteLink(website_link);

            }else{
                // return error from google
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return incompleteRestaurant;
    }

    public static Recipe parseRecipeInfo(String input, Recipe incompleteRecipe){
        try {
            JSONObject jo = new JSONObject(input);
            JSONObject matchesResult = jo.getJSONObject("matches");

            JSONObject imageUrlJO = matchesResult.getJSONObject("imageUrlsBySize");
            String imageUrl = imageUrlJO.getString("90");

            JSONArray ingredientsJO = imageUrlJO.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();

            for(int i = 0; i < ingredientsJO.length(); i++){
                ingredients.add(ingredientsJO.getString(i));
            }

            double rating = matchesResult.getDouble("rating");
            String total_time_in_seconds = matchesResult.getString("totalTimeInSeconds");

            incompleteRecipe.setImage_url(imageUrl);
            incompleteRecipe.setIngredients(ingredients);
            incompleteRecipe.setRecipe_yummly_rating(rating);
            incompleteRecipe.setTotal_time_in_seconds(total_time_in_seconds);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return incompleteRecipe;
    }
}
