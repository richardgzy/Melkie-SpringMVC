package ml.melkie.demo;

import ml.melkie.demo.model.Country;
import ml.melkie.demo.model.Restaurant;
import ml.melkie.demo.model.Taste;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@SpringBootApplication
@Controller
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})


public class MelkieApplication {

	static private ArrayList<Country> countryList;
	static private Taste currentTaste;
	static private Restaurant currentRestaurant;

	public static void main(String[] args) {
		generateData();
		SpringApplication.run(MelkieApplication.class, args);
	}

	@RequestMapping("/")
	String index(Model model) {
		model.addAttribute("currentRestaurant", currentRestaurant);
		return "index";
	}

	@RequestMapping("/subscribe")
	String subscribe() {
		return "subscribe";
	}

	static private void generateData(){
//		Restaurant newRestaurant = new Restaurant("TimHoWan", "206 Bourke St, Melbourne VIC 3000", 50, 40, "timhowan.com.au", "666-666");
//		ArrayList<Restaurant> newArrayList = new ArrayList<>();
//		newArrayList.add(newRestaurant);
//
//		Taste newTaste = new Taste("Cantonese Food", newArrayList);
//		ArrayList<Taste> newArrayList2 = new ArrayList<>();
//		newArrayList2.add(newTaste);
//
//		Country china = new Country("China", newArrayList2);
//		countryList.add(china);
//		currentRestaurant = newRestaurant;
		currentRestaurant = new Restaurant("TimHoWan", "206 Bourke St, Melbourne VIC 3000", 50, 3.5, 40, "timhowan.com.au", "666-666");
	}
}
