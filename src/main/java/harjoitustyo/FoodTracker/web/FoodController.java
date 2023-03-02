package harjoitustyo.FoodTracker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.FoodTracker.domain.FoodRepository;

@Controller
public class FoodController {

	@Autowired
	private FoodRepository foodrepository;
	
	@RequestMapping(value = "/index")
	public String returnIndexPage() {
		return "index";
	}
	
	@RequestMapping(value = { "/", "/foodlist" })
	public String showFoodList(Model model) {
		model.addAttribute("ingredients", foodrepository.findAll());
		return "foodlist";
	}
}
