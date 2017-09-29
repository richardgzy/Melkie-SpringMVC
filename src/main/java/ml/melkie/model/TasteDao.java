package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface TasteDao {

    @Select("select * from taste where taste_id = #{taste_id}")
    Taste getTasteById(Integer taste_id);

    @Select("select * from taste where taste_name = #{tasteName}")
    Taste getTasteByName(String tasteName);

    @Select("select * from taste natural join country where country_name = #{countryName}")
    ArrayList<Taste> getTasteListByCountryName(String countryName);
}
