package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CountryDao {
    @Select("select * from country")
    ArrayList<Country> getAllCountry();

    @Select("select * from country where country_id = #{id}")
    Country getCountryById(Integer id);
}
