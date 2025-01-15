package dam2.adat.testCRUDEclipselink;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="regions")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
	@Column(name="region_id")
	private int regionId;
	@Column(name="name")
	private String name;
	@Column(name="continent_id")
	private int continentId;
	
	@OneToMany(mappedBy = "region")
	private List<Country> countries;
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContinentId() {
		return continentId;
	}
	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}
	
	public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
	
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", name=" + name + ", continentId=" + continentId + "]";
	}
	
	
	
}
