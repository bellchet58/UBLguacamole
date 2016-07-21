package com.ublwarriors.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ublwarriors.guacamole.model.ConnectionParameter;

public interface ConnectionParamsService {
	public HashMap<String, String> getParamsById(Integer connId);

	public List<ConnectionParameter> addParameters(List<ConnectionParameter> params);
	
}
