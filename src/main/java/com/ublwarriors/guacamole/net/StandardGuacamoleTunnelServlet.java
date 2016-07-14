package com.ublwarriors.guacamole.net;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.net.GuacamoleSocket;
import org.glyptodon.guacamole.net.GuacamoleTunnel;
import org.glyptodon.guacamole.net.InetGuacamoleSocket;
import org.glyptodon.guacamole.net.SimpleGuacamoleTunnel;
import org.glyptodon.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.glyptodon.guacamole.protocol.GuacamoleConfiguration;
import org.glyptodon.guacamole.servlet.GuacamoleHTTPTunnelServlet;

import com.ublwarriors.guacamole.model.Connection;
import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.service.ConnectionParamsService;
import com.ublwarriors.util.Configure;
import com.ublwarriors.util.PhaseDictionary;

public class StandardGuacamoleTunnelServlet extends GuacamoleHTTPTunnelServlet {

	public ConnectionParamsService connParamService;
	
	@Override
	protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {
		 // guacd connection information
        String hostname = Configure.getInstance().get(PhaseDictionary.HOSTNAME).toString();
        int port = Integer.parseInt(Configure.getInstance().get(PhaseDictionary.PORT).toString());
        

        // VNC connection information
        Connection conn = (Connection) request.getAttribute("connection");
        int connectionId = conn.getConnectionId();
        HashMap<String, String> params = connParamService.getParamsById(connectionId);
        GuacamoleConfiguration config = new GuacamoleConfiguration();
        config.setProtocol(conn.getProtocol());
        config.setParameter(PhaseDictionary.HOSTNAME, params.get(PhaseDictionary.HOSTNAME));
        config.setParameter(PhaseDictionary.PORT, params.get(PhaseDictionary.PORT));
        config.setParameter(PhaseDictionary.PASSWORD, PhaseDictionary.PASSWORD);

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
