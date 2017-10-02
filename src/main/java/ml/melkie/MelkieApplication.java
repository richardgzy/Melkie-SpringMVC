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

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private TasteDao tasteDao;
	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private RecipeDao recipeDao;
	@Autowired
	private GroceryDao groceryDao;

	public static void main(String[] args) {
		SpringApplication.run(MelkieApplication.class, args);
	}

	@RequestMapping("/")
	String index(Model model) {
		countryList = countryDao.getAllCountry();

		model.addAttribute("countryList", countryList);
		return "index";
	}

	@PostMapping("/taste")
	String index2(Model model, @RequestParam("country_id") String country_id){
		currentCountry = countryDao.getCountryById(Integer.parseInt(country_id));
		tasteList = tasteDao.getTasteListByCountryId(Integer.parseInt(country_id));

		model.addAttribute("currentCountry", currentCountry);
		model.addAttribute("tasteList", tasteList);
		return "index2";
	}


	@PostMapping("/result")
	public String result(@RequestParam("taste_id") String taste_id){

		return "redirect:/result/"+ taste_id + "/0/0";
	}

	@GetMapping("/result/{taste_id}/{restaurant_index_in_taste}/{recipe_index_in_taste}")
	String result(Model model, @PathVariable String taste_id, @PathVariable String restaurant_index_in_taste, @PathVariable String recipe_index_in_taste) {
		currentTaste = tasteDao.getTasteById(Integer.parseInt(taste_id));
		currentCountry = countryDao.getCountryById(currentTaste.getCountry_id());

		//get restaurant list by taste name
		restaurantList = restaurantDao.getRestaurantsByTaste(currentTaste.getTaste_id());
		//get recipe list by taste name
		recipeList = recipeDao.getRecipeListByTaste(Integer.parseInt(taste_id));
		//get grocery list by country name
		groceryList = groceryDao.getGroceryByCountry(currentCountry.getCountry_name());

		//get current restaurant information from google API

		for(Restaurant restaurant: restaurantList){
			String placeId = restaurant.getRestaurant_placeID();
			String restaurantData = APIManager.getRestaurantData(placeId);
			restaurant = JsonParser.parseRestaurantinfo(restaurantData, restaurant);
		}
		currentRestaurant = restaurantList.get(Integer.parseInt(restaurant_index_in_taste));

		//get current recipe information from yummly API
		for(Recipe recipe: recipeList){
			String name = recipe.getRecipe_name().replace('_', ' ');
			String recipeData = APIManager.getRecipeData(name);
			recipe = JsonParser.parseRecipeInfo(recipeData, recipe);
		}

		currentRecipe = recipeList.get(Integer.parseInt(recipe_index_in_taste));

		//get grocery latitude and longitude from google place API
		String[][] markers = new String[groceryList.size()][];

		for(int i = 0; i < groceryList.size(); i++){
			Grocery g = groceryList.get(i);
			String[] aMarker = new String[3];
			String groceryData = APIManager.getRestaurantData(g.getGrocery_place_id());
			g = JsonParser.parseGroceryInfo(groceryData, g);
			aMarker[0] = g.getGrocery_name();
			aMarker[1] = g.getLatitude().toString();
			aMarker[2] = g.getLongitude().toString();
			markers[i] = aMarker;
		}

		//add attribute to model
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("groceryList", groceryList);
		model.addAttribute("currentCountry", currentCountry);
		model.addAttribute("currentTaste", currentTaste);
		model.addAttribute("currentRestaurant", currentRestaurant);
		model.addAttribute("currentRecipe", currentRecipe);
		model.addAttribute("markers", markers);
		model.addAttribute("recipe_index_in_taste", recipe_index_in_taste);

		return "result";
	}

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

//	private void generateData(){
//		Taste newTaste = new Taste(1, "Cantonese Food", 1);
//		tasteList.add(newTaste);
//
////		restaurantList = restaurantDao.getRestaurantsByTaste(newTaste.getTaste_name());
//
//		//append information from google to the currentRestaurant
//		currentRestaurant = new Restaurant(1,"TimhoWannn", 22, "ChIJSS5p7clC1moRGPUzkMpfKpM");
//		String placeId = currentRestaurant.getRestaurant_placeID();
//		String data = APIManager.getRestaurantData(placeId);
//		currentRestaurant = JsonParser.parseRestaurantinfo(data, currentRestaurant);
//	}
}
