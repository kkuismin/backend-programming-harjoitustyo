package harjoitustyo.FoodTracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodtypeRepository extends CrudRepository<Foodtype, Long> {
	
	List <Foodtype> findByTypeName(String typeName);
	
}
