package harjoitustyo.FoodTracker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeid;
	
	private String typeName;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "foodType")
	private List<Food> foodlist;
	
	public FoodType() {
		super();
	}
	
	public FoodType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public List<Food> getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(List<Food> foodlist) {
		this.foodlist = foodlist;
	}

	@Override
	public String toString() {
		return "FoodType [typeid=" + typeid + ", typeName=" + typeName + "]";
	}
	
	

}
