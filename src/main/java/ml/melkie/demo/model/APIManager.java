package ml.melkie.demo.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIManager {
    //yummly API credentials
    private static final String yummlyrequestUrl = "dc620bd3";
    private static final String yummlyApplicationID = "dc620bd3";
    private static final String yummlyApplicationKey = "763b7adb0c8657d89a257a25d9f92abc";
    //google API credentials
    private static final String googleRequestUrl = "https://maps.googleapis.com/maps/api/place/details/json";
    private static final String googlePlaceID = "?placeid=";
    private static final String googleAPIKey = "&key=AIzaSyA6zqqgmN3jTpT4_heXYHVaQ52lfjDi__U";



    public static String getRestaurantData(String placeID) {
        HttpURLConnection con = null;
        InputStream is = null;

        String query = googleRequestUrl + googlePlaceID + placeID + googleAPIKey;

        try {
            con = (HttpURLConnection) (new URL(query)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            //read the response
            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null)
                buffer.append(line);

            is.close();
            con.disconnect();
            return buffer.toString();
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
}
