package com.ublwarriors.guacamole.net;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.net.GuacamoleSocket;
import org.glyptodon.guacamole.net.GuacamoleTunnel;
import org.glyptodon.guacamole.net.InetGuacamoleSocket;
import org.glyptodon.guacamole.net.SimpleGuacamoleTunnel;
import org.glyptodon.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.glyptodon.guacamole.protocol.GuacamoleConfiguration;
import org.glyptodon.guacamole.servlet.GuacamoleHTTPTunnelServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.service.ConnectionParamsService;
import com.ublwarriors.util.Configure;
import com.ublwarriors.util.PhaseDictionary;

public class StandardGuacamoleTunnelServlet extends GuacamoleHTTPTunnelServlet {
	
	Logger logger = LoggerFactory.getLogger(StandardGuacamoleTunnelServlet.class);
	
	@Autowired
	public ConnectionParamsService connParamService;
	
	@Override
	protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {
		 // guacd connection information
        String hostname = Configure.getInstance().get(PhaseDictionary.HOSTNAME).toString();
        int port = Integer.parseInt(Configure.getInstance().get(PhaseDictionary.PORT).toString());
        String protocol = (String) request.getParameter("protocol");
    	String vnchost = (String) request.getParameter("hostname");
    	String vncpost = (String) request.getParameter("port");
    	String password = (String) request.getParameter("password");
    	logger.error("{},{},{},{}" ,protocol,vnchost,vncpost,password);

        // VNC connection information
        GuacamoleConfiguration config = new GuacamoleConfiguration();
        if(request.getAttribute("connection") != null)
        {
        	 Connection conn = (Connection) request.getAttribute("connection");
             int connectionId = conn.getConnectionId();
             HashMap<String, String> params = connParamService.getParamsById(connectionId);
             config.setProtocol(conn.getProtocol());
             config.setParameter(PhaseDictionary.HOSTNAME, params.get(PhaseDictionary.HOSTNAME));
             config.setParameter(PhaseDictionary.PORT, params.get(PhaseDictionary.PORT));
             config.setParameter(PhaseDictionary.PASSWORD, PhaseDictionary.PASSWORD);
        }else if (request.getParameter("protocol") != null)
        {
        	config.setProtocol(protocol);
            config.setParameter(PhaseDictionary.HOSTNAME, vnchost);
            config.setParameter(PhaseDictionary.PORT, vncpost);
            config.setParameter(PhaseDictionary.PASSWORD, password);
        }
       

        // Connect to guacd, proxying a connection to the VNC server above
        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket(hostname, port),
                config
        );

        // Create tunnel from now-configured socket
        GuacamoleTunnel tunnel = new SimpleGuacamoleTunnel(socket);
        return tunnel;
	}

}
