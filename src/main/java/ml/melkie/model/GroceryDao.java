package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GroceryDao {
    @Select("select grocery_id, grocery_name, place_id from grocery natural join grocery_country natural join country where country_name = #{country_name}")
    ArrayList<Grocery> getGroceryByCountry(String countryName);
}
