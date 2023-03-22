package harjoitustyo.FoodTracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
	List<Food> findByName(String name);
	
	List<Food> findAllByOrderByLocationAsc();
}
