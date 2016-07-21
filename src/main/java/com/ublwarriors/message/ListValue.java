package com.ublwarriors.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ublwarriors.util.PhaseDictionary;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ListValue<T> extends Value {
	private List<T> list;

	public ListValue()
	{
		this.Id = PhaseDictionary.ID4LIST;
	}
	
	public ListValue(List<T> list) {
		this.Id = PhaseDictionary.ID4LIST;
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ListValue [list=" + list + ", Id=" + Id + "]";
	}

	
	
	
	
}
