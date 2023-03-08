package harjoitustyo.FoodTracker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.FoodTracker.domain.Food;
import harjoitustyo.FoodTracker.domain.FoodRepository;
import harjoitustyo.FoodTracker.domain.FoodTypeRepository;
import harjoitustyo.FoodTracker.domain.LocationRepository;

@Controller
public class FoodController {

	@Autowired
	private FoodRepository foodrepository;
	
	@Autowired
	private LocationRepository locationrepository;
	
	@Autowired
	private FoodTypeRepository typerepository;
	
	@RequestMapping(value = "/index")
	public String returnIndexPage() {
		return "index";
	}
	
	@RequestMapping(value = { "/", "/foodlist" })
	public String showFoodList(Model model) {
		model.addAttribute("ingredients", foodrepository.findAll());
		return "foodlist";
	}
	
	@GetMapping("/addfood")
	public String addNewFood(Model model) {
		model.addAttribute("food", new Food());
		model.addAttribute("locations", locationrepository.findAll());
		model.addAttribute("foodTypes", typerepository.findAll());
		return "addfood";
	}
	
	@PostMapping("/saveFood")
	public String saveFood(Food food, Model model) {
		foodrepository.save(food);
		return "redirect:/foodlist";
	}
}
