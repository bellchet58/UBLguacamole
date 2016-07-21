package com.ublwarriors.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FailureValue extends Value {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public FailureValue() {
		this.Id = -1;
	}
	
	public FailureValue(String description)
	{
		this.description = description;
		this.Id = -1;
	}

	@Override
	public String toString() {
		return "FailureValue [description=" + description + ", Id=" + Id + "]";
	}

	
	
}
