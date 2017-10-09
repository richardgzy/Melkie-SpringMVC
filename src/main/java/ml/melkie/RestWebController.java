package ml.melkie;

import ml.melkie.model.Customer;
import ml.melkie.model.Recipe;
import ml.melkie.model.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestWebController {

    List<Customer> cust = new ArrayList<Customer>();

    @RequestMapping(value = "/ajax/getallcustomer", method = RequestMethod.GET)
    public Response getResource() {
        Response response = new Response("Done", cust);
        return response;
    }

    @RequestMapping(value = "/ajax/postcustomer", method = RequestMethod.POST)
    public Response postCustomer(@RequestBody Customer customer) {
        cust.add(customer);
        // Create Response Object
        Response response = new Response("Done", customer);
        return response;
    }
//
//    @RequestMapping(value = "/postimage", method = RequestMethod.POST)
//    public Response postRecipe(@RequestBody String index) {
//        ArrayList<Recipe> recipeList = MelkieApplication.recipeList;
//
//        Response response = new Response("Done", "hi");
//        return response;
//    }
}
