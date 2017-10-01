package ml.melkie.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RecipeDao {

    @Select("select recipe_id, recipe_name, direction_link from recipe natural join recipe_taste natural join taste where taste_id= #{tasteId}")
    ArrayList<Recipe> getRecipeListByTaste(Integer tasteId);
}
