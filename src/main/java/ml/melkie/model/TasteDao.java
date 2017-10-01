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

    @Select("select * from taste")
    ArrayList<Taste> getAllTaste();

    @Select("select taste_id, taste_name, country_id from taste natural join country where country_id = #{countryId}")
    ArrayList<Taste> getTasteListByCountryId(Integer countryId);
}
