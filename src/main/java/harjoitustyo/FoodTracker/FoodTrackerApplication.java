package harjoitustyo.FoodTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.FoodTracker.domain.Food;
import harjoitustyo.FoodTracker.domain.FoodRepository;

@SpringBootApplication
public class FoodTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FoodRepository foodrepository) {
		return (args) -> {
			System.out.println("adding demo data");
			foodrepository.save(new Food("Tuna", 1, "Pantry", "1.5.2024"));
			foodrepository.save(new Food("Tomato sauce", 2, "Pantry", "5.10.2023"));
			foodrepository.save(new Food("Strawberries", 1, "Freezer", "1.6.2023"));
			foodrepository.save(new Food("Tofu", 1, "Fridge", "31.3.2023"));
			for (Food food : foodrepository.findAll()) {
				System.out.println(food);
			}
		};
	}
}
