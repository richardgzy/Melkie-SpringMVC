package ml.melkie;

import ml.melkie.model.Country;
import ml.melkie.model.User;
import ml.melkie.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public String hello( Model model){
        User user = this.userDao.getOneUser("yyy");

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "hello";
    }
}
