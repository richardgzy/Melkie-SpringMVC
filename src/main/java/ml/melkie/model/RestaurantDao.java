package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RestaurantDao {
    @Select("select restaurant_id, restaurant_name, total_seats_number, likes, restaurant_place_id from restaurant natural join restaurant_taste natural join taste where taste_id = #{tasteId}")
    ArrayList<Restaurant> getRestaurantsByTaste(Integer tasteId);

    @Select("select from")
    Integer getRestaurantSeats(String restaurantName);
}
