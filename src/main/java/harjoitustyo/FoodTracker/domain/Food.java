package harjoitustyo.FoodTracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private int quantity;
	
	private String location;
	
	private String expirationDate;
	
	public Food() {
		super();
	}
	
	public Food(String name, int quantity, String location, String expirationDate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.location = location;
		this.expirationDate = expirationDate;
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

	public String getLocation() {
		return location;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", quantity=" + quantity + ", location=" + location
				+ ", expirationDate=" + expirationDate + "]";
	}


	
}
