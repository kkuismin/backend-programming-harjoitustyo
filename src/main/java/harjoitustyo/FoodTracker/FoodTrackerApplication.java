package harjoitustyo.FoodTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.FoodTracker.domain.Food;
import harjoitustyo.FoodTracker.domain.FoodRepository;
import harjoitustyo.FoodTracker.domain.Foodtype;
import harjoitustyo.FoodTracker.domain.FoodtypeRepository;
import harjoitustyo.FoodTracker.domain.Location;
import harjoitustyo.FoodTracker.domain.LocationRepository;
import harjoitustyo.FoodTracker.domain.AppUser;
import harjoitustyo.FoodTracker.domain.AppUserRepository;

@SpringBootApplication
public class FoodTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTrackerApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner demo(AppUserRepository userrepository, FoodRepository foodrepository, LocationRepository locationrepository, FoodTypeRepository typerepository) {
		return (args) -> {
			System.out.println("creating users");
			userrepository.save(new AppUser("John", "Doe", "user", "$2a$10$44CXRQzFklqLdg8EP2n35upJSOrSSd.q.GcBjVnoYpqhx8jpInMhy", "USER"));
			userrepository.save(new AppUser("Jane", "Doe", "admin", "$2a$10$wRPxDuKJ5uVaholbnaD89ulbEvAyHqI0i6SS6XnKk1gGF6.Rr76hm", "ADMIN"));
			
			System.out.println("creating locations");
			locationrepository.save(new Location("Freezer"));
			locationrepository.save(new Location("Fridge"));
			locationrepository.save(new Location("Pantry"));
			
			System.out.println("creating food types");
			typerepository.save(new FoodType("Dairy"));
			typerepository.save(new FoodType("Drinks"));
			typerepository.save(new FoodType("Fruits, Vegetables and Berries"));
			typerepository.save(new FoodType("Grains"));
			typerepository.save(new FoodType("Proteins"));
			typerepository.save(new FoodType("Snacks"));
			typerepository.save(new FoodType("Spices"));
			
			System.out.println("adding demo data");
			foodrepository.save(new Food("Tuna", 1, "1.5.2024", locationrepository.findBylocationName("Pantry").get(0), typerepository.findByTypeName("Proteins").get(0)));
			foodrepository.save(new Food("Oat flakes", 2, "5.10.2023", locationrepository.findBylocationName("Pantry").get(0), typerepository.findByTypeName("Grains").get(0)));
			foodrepository.save(new Food("Strawberries", 1, "1.6.2023", locationrepository.findBylocationName("Freezer").get(0), typerepository.findByTypeName("Fruits, Vegetables and Berries").get(0)));
			foodrepository.save(new Food("Tofu", 1, "31.3.2023", locationrepository.findBylocationName("Fridge").get(0), typerepository.findByTypeName("Proteins").get(0)));
			foodrepository.save(new Food("Chocolate bar", 3, "22.7.2023", locationrepository.findBylocationName("Pantry").get(0), typerepository.findByTypeName("Snacks").get(0)));
			foodrepository.save(new Food("Orange juice", 2, "2.4.2023", locationrepository.findBylocationName("Fridge").get(0), typerepository.findByTypeName("Drinks").get(0)));
			foodrepository.save(new Food("Butter", 2, "30.4.2023", locationrepository.findBylocationName("Fridge").get(0), typerepository.findByTypeName("Dairy").get(0)));
			
			for (Food food : foodrepository.findAll()) {
				System.out.println(food);
			}
		};
	} */
}
