package ml.melkie.demo;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select * from users where name = #{name}")
    User getOneUser(String name);
}
