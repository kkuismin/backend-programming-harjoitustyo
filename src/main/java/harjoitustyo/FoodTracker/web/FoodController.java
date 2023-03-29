package harjoitustyo.FoodTracker.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = { "/", "/foodlist" })
	public String showFoodList(Model model) {
		model.addAttribute("ingredients", foodrepository.findAllByOrderByLocationAsc());
		return "foodlist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addfood")
	public String addNewFood(Model model) {
		model.addAttribute("food", new Food());
		model.addAttribute("locations", locationrepository.findAll());
		model.addAttribute("foodTypes", typerepository.findAll());
		return "addfood";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/savefood")
	public String saveFood(@Valid @ModelAttribute ("food") Food food, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("locations", locationrepository.findAll());
			model.addAttribute("foodTypes", typerepository.findAll());
			return "addfood";
		}
		foodrepository.save(food);
		return "redirect:/foodlist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/edit/{id}")
	public String editFood(@PathVariable("id") Long id, Model model) {
		model.addAttribute("food", foodrepository.findById(id));
		model.addAttribute("locations", locationrepository.findAll());
		model.addAttribute("foodTypes", typerepository.findAll());
		return "editfood";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteFood(@PathVariable("id") Long id, Model model) {
		foodrepository.deleteById(id);
		return "redirect:/foodlist";
	}
	
	//REST
	@GetMapping("/foods")
	public @ResponseBody List<Food> showFoodRest() {
		return (List<Food>) foodrepository.findAll();
	}
	
	@GetMapping("/foods/{id}")
	public @ResponseBody Optional<Food> findFoodRest(@PathVariable("id") Long id) {
		return foodrepository.findById(id);
	}

}
