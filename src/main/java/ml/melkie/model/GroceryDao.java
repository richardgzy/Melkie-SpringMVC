package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GroceryDao {
    @Select("select * from where country_name = #{country_name}")
    ArrayList<Grocery> getGroceryByCountry(String countryName);
}
