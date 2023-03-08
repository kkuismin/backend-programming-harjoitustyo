package harjoitustyo.FoodTracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodTypeRepository extends CrudRepository<FoodType, Long> {
	
	List <FoodType> findByTypeName(String typeName);
	
}
