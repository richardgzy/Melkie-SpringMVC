package ml.melkie;

import ml.melkie.model.Country;
import ml.melkie.model.CountryDao;
import ml.melkie.model.Restaurant;
import ml.melkie.model.Taste;
import ml.melkie.utility.APIManager;
import ml.melkie.utility.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@SpringBootApplication(scanBasePackages={"ml.melkie", "ml.melkie.model"})
@Controller

public class MelkieApplication {

	static private ArrayList<Country> countryList = new ArrayList<>();
	static private ArrayList<Taste> tasteList = new ArrayList<>();
	static private ArrayList<Restaurant> restaurantList  = new ArrayList<>();
	static private Country currentCountry;
	static private Taste currentTaste;
	static private Restaurant currentRestaurant;

	@Autowired
	private CountryDao countryDao;

	public static void main(String[] args) {
		generateData();

		SpringApplication.run(MelkieApplication.class, args);
	}

	@RequestMapping("/")
	String index(Model model) {
		countryList = countryDao.getAllCountry();

		model.addAttribute("countryList", countryList);
		model.addAttribute("currentCountry", currentCountry);
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("currentRestaurant", currentRestaurant);
		return "index";
	}

//	@PostMapping(value = "/")
//	public String create(@RequestParam("country") String country,
//						 @RequestParam("taste") String taste) {
//		//save title and content to repository
//		System.out.println(country+","+taste);
//		return "redirect:/#EatOutside";
//	}

	@RequestMapping("/index2")
	String index2(Model model) {
		countryList = countryDao.getAllCountry();

		model.addAttribute("countryList", countryList);
		model.addAttribute("currentCountry", currentCountry);
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("currentRestaurant", currentRestaurant);
		System.out.println(currentCountry.getCountry_name());
		return "index2";
	}

	@RequestMapping("/culture_and_tips")
	String cultureAndTipsPage() {
		return "CultureAndTips";
	}

	@RequestMapping("/tab")
	String tab() {
		return "tab";
	}

	@RequestMapping("/articles/{article_id}")
	String findArticles(@PathVariable String article_id) {
		return "portfolio-item" + article_id;
	}

    @RequestMapping("/articles")
    String findArticles() {
        return "portfolio-item" + "1";
    }

	static private void generateData(){
		Restaurant newRestaurant = new Restaurant("TimHoWan", "206 Bourke St, Melbourne VIC 3000", 50, 40, 58, "timhowan.com.au", "666-666", "ChIJSS5p7clC1moRGPUzkMpfKpM");
		ArrayList<Restaurant> newArrayList = new ArrayList<>();
		newArrayList.add(newRestaurant);

		Taste newTaste = new Taste("Cantonese Food", newArrayList);
		ArrayList<Taste> newArrayList2 = new ArrayList<>();
		newArrayList2.add(newTaste);
		newTaste.setContainRestaurant(newArrayList);

		Country china = new Country(1, "China", 10);
		countryList.add(china);
		currentRestaurant = newTaste.getContainRestaurant().get(0);

		//append information from google to the currentRestaurant
		String placeId = currentRestaurant.getPlaceID();
		String data = APIManager.getRestaurantData(placeId);
		currentRestaurant = JsonParser.parseRestaurantinfo(data, currentRestaurant);
	}

	private String print(){
		System.out.println("test");
		return "eee";
	}
}
