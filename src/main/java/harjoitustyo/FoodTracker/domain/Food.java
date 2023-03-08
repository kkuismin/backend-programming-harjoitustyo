package harjoitustyo.FoodTracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "locationid")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private FoodType foodType;
	
	private String expirationDate;
	
	public Food() {
		super();
	}
	
	public Food(String name, int quantity, String expirationDate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
	}
	
	public Food(String name, int quantity, String expirationDate, Location location, FoodType foodType) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
		this.location = location;
		this.foodType = foodType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", quantity=" + quantity + ", location=" + location + ", foodType="
				+ foodType + ", expirationDate=" + expirationDate + "]";
	}




	
}
