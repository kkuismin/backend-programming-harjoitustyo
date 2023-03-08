package harjoitustyo.FoodTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.FoodTracker.domain.Food;
import harjoitustyo.FoodTracker.domain.FoodRepository;
import harjoitustyo.FoodTracker.domain.Location;
import harjoitustyo.FoodTracker.domain.LocationRepository;

@SpringBootApplication
public class FoodTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FoodRepository foodrepository, LocationRepository locationrepository) {
		return (args) -> {
			System.out.println("creating locations");
			locationrepository.save(new Location("Pantry"));
			locationrepository.save(new Location("Freezer"));
			locationrepository.save(new Location("Fridge"));
			
			System.out.println("adding demo data");
			foodrepository.save(new Food("Tuna", 1, "1.5.2024", locationrepository.findBylocationName("Pantry").get(0)));
			foodrepository.save(new Food("Tomato sauce", 2, "5.10.2023", locationrepository.findBylocationName("Pantry").get(0)));
			foodrepository.save(new Food("Strawberries", 1, "1.6.2023", locationrepository.findBylocationName("Freezer").get(0)));
			foodrepository.save(new Food("Tofu", 1, "31.3.2023", locationrepository.findBylocationName("Fridge").get(0)));
			foodrepository.save(new Food("Chocolate bar", 3, "22.7.2023", locationrepository.findBylocationName("Pantry").get(0)));
			for (Food food : foodrepository.findAll()) {
				System.out.println(food);
			}
		};
	}
}
