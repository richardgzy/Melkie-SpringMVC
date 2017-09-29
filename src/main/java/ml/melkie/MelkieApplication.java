package ml.melkie;

import ml.melkie.model.*;
import ml.melkie.utility.APIManager;
import ml.melkie.utility.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

@SpringBootApplication(scanBasePackages={"ml.melkie", "ml.melkie.model"})
@Controller

public class MelkieApplication {

	static private ArrayList<Country> countryList = new ArrayList<>();
	static private ArrayList<Taste> tasteList = new ArrayList<>();
	static private ArrayList<Restaurant> restaurantList  = new ArrayList<>();
	static private ArrayList<Recipe> recipeList  = new ArrayList<>();
	static private ArrayList<Grocery> groceryList  = new ArrayList<>();

	static private Country currentCountry;
	static private Taste currentTaste;
	static private Restaurant currentRestaurant;
	static private Recipe currentRecipe;
	static private Grocery currentGrocery;

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private TasteDao tasteDao;
	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private RecipeDao recipeDao;
//	@Autowired
//	private GroceryDao groceryDao;

	public static void main(String[] args) {
		SpringApplication.run(MelkieApplication.class, args);
	}

	@RequestMapping("/")
	String index(Model model) {
		countryList = countryDao.getAllCountry();

		generateData();
		model.addAttribute("countryList", countryList);
//		model.addAttribute("currentCountry", currentCountry);
//		model.addAttribute("SubmitForm", new SubmitForm());
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("currentRestaurant", currentRestaurant);
		return "index";
	}

	@PostMapping("/post")
	public String submitCountry(HttpServletRequest request){
		System.out.println(request.getParameter("theCountry"));
		return "result";
	}

	@PostMapping("/result")
	public String result(HttpServletRequest request, Model model){
		System.out.println(request.getParameter("theCountry"));

//
//		currentCountry = new Country(1,"China",6666);
//		currentTaste = new Taste(1, "Cantonese food", 1);
//
//		restaurantDao.getRestaurantsByTaste(currentTaste.getTaste_name());


		SubmitForm submitForm = new SubmitForm();

		model.addAttribute("submitForm", submitForm);
//		model.addAttribute("currenttaste", currentTaste);
		return "result";
	}

	@GetMapping("/result/{taste_id}/{restaurant_index_in_taste}/{recipe_index_in_taste}")
	String result(Model model, @PathVariable String taste_id, @PathVariable String restaurant_index_in_taste, @PathVariable String recipe_index_in_taste) {

		currentTaste = tasteDao.getTasteById(Integer.parseInt(taste_id));
		currentCountry = countryDao.getCountryById(currentTaste.getCountry_id());

		//get restaurant list by taste name
		restaurantList = restaurantDao.getRestaurantsByTaste(currentTaste.getTaste_name());
		//get recipe list by taste name
		recipeList = recipeDao.getRecipeListByTaste(currentTaste.getTaste_name());
		//get grocery list by country name
//		groceryList - groceryDao.getGroceryByCountry(currentCountry.getCountry_name())''

		//get current restaurant information from google API
		currentRestaurant = restaurantList.get(Integer.parseInt(restaurant_index_in_taste));
		String placeId = currentRestaurant.getRestaurant_placeID();
		String restaurantData = APIManager.getRestaurantData(placeId);
		currentRestaurant = JsonParser.parseRestaurantinfo(restaurantData, currentRestaurant);

		//get restaurant seats from open data
		currentRestaurant.setRestaurant_seats(66);

		//get current recipe information from yummly API
		currentRecipe = recipeList.get(Integer.parseInt(recipe_index_in_taste));
//		String name = currentRecipe.getRecipe_name().replace('_', ' ');
//		String recipeData = APIManager.getRecipeData(name);
//		currentRecipe = JsonParser.parseRecipeInfo(recipeData, currentRecipe);

		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("currentCountry", currentCountry);
		model.addAttribute("currentTaste", currentTaste);
		model.addAttribute("currentRestaurant", currentRestaurant);
		model.addAttribute("currentRecipe", currentRecipe);

		return "result";
	}


//	@PostMapping(value = "/")
//	String create(Model model) {
//
//		model.addAttribute("countryList", countryList);
////		model.addAttribute("currentCountry", currentCountry);
//		model.addAttribute("SubmitForm",new SubmitForm());
//		model.addAttribute("restaurantList", restaurantList);
//		model.addAttribute("currentRestaurant", currentRestaurant);
//		return "index";
//	}

	@RequestMapping("/index2/result/{taste_id}")
	String recipePage(Model model, @PathVariable String taste_id) {
		countryList = countryDao.getAllCountry();

		model.addAttribute("countryList", countryList);
		model.addAttribute("currentCountry", currentCountry);
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("currentRestaurant", currentRestaurant);
		return "index2";
	}

	@RequestMapping("/culture_and_tips")
	String cultureAndTipsPage() {
		return "CultureAndTips";
	}

	@RequestMapping("/articles/{article_id}")
	String findArticles(@PathVariable String article_id) {
		return "portfolio-item" + article_id;
	}

    @RequestMapping("/articles")
    String findArticles() {
        return "portfolio-item" + "1";
    }

	private void generateData(){
		Taste newTaste = new Taste(1, "Cantonese Food", 1);
		tasteList.add(newTaste);

//		restaurantList = restaurantDao.getRestaurantsByTaste(newTaste.getTaste_name());

		//append information from google to the currentRestaurant
		currentRestaurant = new Restaurant(1,"TimhoWannn", 22, "ChIJSS5p7clC1moRGPUzkMpfKpM");
		String placeId = currentRestaurant.getRestaurant_placeID();
		String data = APIManager.getRestaurantData(placeId);
		currentRestaurant = JsonParser.parseRestaurantinfo(data, currentRestaurant);
	}
}
