package com.velue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weight")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weightId;
    public String weightName;
    private String weightDescription;

    public Long getWeightId() {
        return weightId;
    }

    public void setWeightId(Long weightId) {
        this.weightId = weightId;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setUnitName(String weightName) {
        this.weightName = weightName;
    }

    public String getWeightDescription() {
        return weightDescription;
    }

    public void setWeightDescription(String weightDescription) {
        this.weightDescription = weightDescription;
    }
}
