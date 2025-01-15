package dam2.adat.testCRUDEclipselink;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
	@Column(name="country_id")
    private int countryId;
    @Column(name="name")
    private String name;
    @Column(name="area")
    private BigDecimal area;
    @Column(name="national_day")
    private Date nationalDay;
    @Column(name="country_code2")
    private String countryCode2;
    @Column(name="country_code3")
    private String countryCode3;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;  // Ahora referenciamos la entidad Region, no solo el ID


    // Getters y setters
    public int getCountryId() { 
    	return countryId; 
    }
    public void setCountryId(int countryId) {
    	this.countryId = countryId;
    }

    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    public BigDecimal getArea() { 
    	return area; 
    }
    public void setArea(BigDecimal area) { 
    	this.area = area; 
    }
    public Date getNationalDay() { 
    	return nationalDay; 
    }
    public void setNationalDay(Date nationalDay) { 
    	this.nationalDay = nationalDay; 
    }
    public String getCountryCode2() { 
    	return countryCode2; 
    }
    public void setCountryCode2(String countryCode2) { 
    	this.countryCode2 = countryCode2; 
    }
    public String getCountryCode3() { 
    	return countryCode3; 
    }
    public void setCountryCode3(String countryCode3) { 
    	this.countryCode3 = countryCode3; 
    }
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

	
    public String toString() {
        return "Country [countryId=" + countryId + ", name=" + name + ", area=" + area + ", nationalDay=" + nationalDay
                + ", countryCode2=" + countryCode2 + ", countryCode3=" + countryCode3 + ", region=" + region + "]";
    }

    
    
}

