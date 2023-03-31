package harjoitustyo.FoodTracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, max=50)
	private String name;
	
	@Min(value=1)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "locationid")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Foodtype foodtype;
	
	@Column(name = "expirationdate")
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
	
	public Food(String name, int quantity, String expirationDate, Location location, Foodtype foodtype) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
		this.location = location;
		this.foodtype = foodtype;
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
	
	public Foodtype getFoodType() {
		return foodtype;
	}

	public void setFoodType(Foodtype foodtype) {
		this.foodtype = foodtype;
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
				+ foodtype + ", expirationDate=" + expirationDate + "]";
	}




	
}
