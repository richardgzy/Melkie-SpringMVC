package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RestaurantDao {
    @Select("select restaurant_id, restaurant_name, likes, restaurant_place_id from restaurant natural join restaurant_taste natural join taste where taste_name = #{tasteName}")
    ArrayList<Restaurant> getRestaurantsByTaste(String tasteName);

    @Select("select from")
    Integer getRestaurantSeats(String restaurantName);
}
