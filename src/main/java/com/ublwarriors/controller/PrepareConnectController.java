package com.ublwarriors.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.util.PhaseDictionary;

@Controller
public class PrepareConnectController extends ServiceSupport{
	@RequestMapping(value="/user/index")
	public String toSettingIndex()
	{
		return "index";
	}
	
	@RequestMapping(value="setting")
	public String toSetting()
	{
		return "setting";
	}
	
	
	@RequestMapping(value="prepareParam/{connectionId}", method=RequestMethod.GET)
	public ModelAndView prepareParam(@PathVariable Integer connectionId)
	{
		ModelAndView view = new ModelAndView("remoteControlClient");
		if(connectionId!=null)
		{
			HashMap<String, String> map = connParamService.getParamsById(connectionId);
			Connection conn = connService.getConnectionById(connectionId);
			if(!conn.getProtocol().equals("")&& map.containsKey(PhaseDictionary.HOSTNAME) && map.containsKey(PhaseDictionary.PORT))
			{
				view.addAllObjects(map);
				view.addObject("protocol", conn.getProtocol());
			}else {
				return new ModelAndView("error");
			}
		}
		return view;
	}
}
