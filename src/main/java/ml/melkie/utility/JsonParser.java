package ml.melkie.utility;

import ml.melkie.model.Restaurant;
import org.json.JSONObject;

public class JsonParser {

    public static Restaurant parseRestaurantinfo(String input, Restaurant incompleteRestaurant) {
//        ArrayList<String> resultArray = new ArrayList<>();


        try {
            JSONObject jo = new JSONObject(input);

            String status = jo.getString("status");
            if (status.equals("OK")){
                JSONObject result = jo.getJSONObject("result");

                String formatted_address = result.getString("formatted_address");
                Double google_rating = result.getDouble("rating");
//                String phone_number = result.getString("formatted_phone_number");
                String website_link = result.getString("website");

                incompleteRestaurant.setAddress(formatted_address);
                incompleteRestaurant.setGoogleRating(google_rating);
                incompleteRestaurant.setWebsiteLink(website_link);

            }else{
                // return error from google
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return incompleteRestaurant;
    }
}
