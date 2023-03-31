package harjoitustyo.FoodTracker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long locationid;

	@Column(name = "locationname")
	private String locationName;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Food> foodlist;

	public Location() {
		super();
	}
	
	public Location(String locationName) {
		super();
		this.locationName = locationName;
	}

	public Long getLocationid() {
		return locationid;
	}

	public void setLocationid(Long locationid) {
		this.locationid = locationid;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public List<Food> getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(List<Food> foodlist) {
		this.foodlist = foodlist;
	}

	@Override
	public String toString() {
		return "Location [locationid=" + locationid + ", locationName=" + locationName + "]";
	}
	
	
}
