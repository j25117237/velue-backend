package com.velue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "packaging")
public class Packaging {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long packing_id;
	private String packing_type;
	private String packing_description;

	public long getPacking_id() {
		return packing_id;
	}

	public void setPacking_id(long packing_id) {
		this.packing_id = packing_id;
	}

	public String getPacking_type() {
		return packing_type;
	}

	public void setPacking_type(String packing_type) {
		this.packing_type = packing_type;
	}

	public String getPacking_description() {
		return packing_description;
	}

	public void setPacking_description(String packing_description) {
		this.packing_description = packing_description;
	}

}
