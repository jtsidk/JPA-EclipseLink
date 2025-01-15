package com.ejemplo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "regions") // debe coincidir con nombre tabla en bd
public class Region {

    @Id
    @Column(name = "region_id") // nombre de la columna en la tabla
    private int regionId;

    @Column(name = "name")
    private String name;

    @Column(name = "continent_id")
    private int continentId;

    @OneToMany(mappedBy = "region") // relación OneToMany con Country
    private List<Country> countries;

    // Getters y Setters
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
}

