package ml.melkie.utility;

import com.github.kevinsawicki.http.HttpRequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class APIManager {
    //yummly API credentials
    private static final String yummlyrequestUrl = "http://api.yummly.com/v1/api/recipes?";
    private static final String yummlyApplicationID = "_app_id=dc620bd3";
    private static final String yummlyApplicationKey = "&_app_key=763b7adb0c8657d89a257a25d9f92abc";
    private static final String yummlyMaxResult = "&maxResult=1";
    private static final String yummlyRequeirePictures = "&requirePictures=true";
    private static final String yummlyRequireSourceSiteUrl = "&requiresourceSiteUrl=true";

    //google places API credentials
    private static final String googleRequestUrl = "https://maps.googleapis.com/maps/api/place/details/json";
    private static final String googlePlaceID = "?placeid=";
    private static final String googleAPIKey = "&key=AIzaSyA6zqqgmN3jTpT4_heXYHVaQ52lfjDi__U";

    //google photo API (for getting restaurant photo)
    private static final String googlePhotorequestUrl = "https://maps.googleapis.com/maps/api/place/photo?";
    private static final String restaurantPhotoMaxHeight = "maxheight=250";
    private static final String restaurantPhotoMaxWidth = "&maxwidth=250";

    private static String getDataFromUrl(String url){
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            con = (HttpURLConnection) (new URL(url)).openConnection();
//            con.setRequestMethod("GET");
//            con.setDoInput(true);
//            con.setDoOutput(true);
//            con.connect();
//
//            //read the response
//            StringBuffer buffer = new StringBuffer();
//            is = con.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String line = null;
//            while ((line = br.readLine()) != null)
//                buffer.append(line);
//
//            is.close();
//            con.disconnect();
//            return buffer.toString();
            String result = "";
            Scanner reader = new Scanner(con.getInputStream());
            while(reader.hasNextLine()){
                result += reader.nextLine();
            }

            return result;
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }

            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }
        return "Data Not Available";
    }


    public static String getRestaurantData(String placeID) {
        String query = googleRequestUrl + googlePlaceID + placeID + googleAPIKey;

        return getDataFromUrl(query);
    }

//    public static ArrayList<String> getRestaurantImage(ArrayList<String> photoReferenceList) {
//        for (String s : photoReferenceList){
//            String query = googlePhotorequestUrl + restaurantPhotoMaxHeight + restaurantPhotoMaxWidth + googleAPIKey;
//
//        }
//
//        return ;
//    }

    public static String getRecipeData(String recipeName) {
        String query = yummlyrequestUrl + yummlyApplicationID + yummlyApplicationKey + "&q=" + recipeName + yummlyMaxResult + yummlyRequeirePictures + yummlyRequireSourceSiteUrl;

//        String da = HttpRequest.get(query).body();


        return getDataFromUrl(query);
    }
}
