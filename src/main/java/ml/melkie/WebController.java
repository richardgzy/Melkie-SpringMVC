package ml.melkie;

import ml.melkie.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {
    @RequestMapping(value="/ajax",method = RequestMethod.GET)
    public String homepage(Model model){
        Customer currentCustomer = new Customer("Richard", "Guo");
        model.addAttribute("currentCustomer", currentCustomer);
        return "ajax";
    }
}
