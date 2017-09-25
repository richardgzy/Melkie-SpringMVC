package ml.melkie.demo.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<String> parseRestaurantinfo(String input, Restaurant incompleteRestaurant) {
        ArrayList<String> resultArray = new ArrayList<>();

        try {
            JSONObject jo = new JSONObject(input);

            String status = jo.getString("status");
            if (status.equals("OK")){
                JSONObject result = jo.getJSONObject("result");

                String formatted_address = result.getString("formatted_address");
                Double google_rating = result.getDouble("rating");
                String phone_number = result.getString("formatted_phone_number");
                String website_link = result.getString("website");



            }else{
                // return error from google
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultArray;
    }
}
