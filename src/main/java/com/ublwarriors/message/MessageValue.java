package com.ublwarriors.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ublwarriors.util.PhaseDictionary;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MessageValue extends Value{
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public MessageValue() {
		this.Id = PhaseDictionary.ID4MESSAGE;
	}
	public MessageValue(String description) {
		this.Id = PhaseDictionary.ID4MESSAGE;
		this.description = description;
	}

	@Override
	public String toString() {
		return "MessageValue [description=" + description + ", Id=" + Id + "]";
	}

	
	
}
