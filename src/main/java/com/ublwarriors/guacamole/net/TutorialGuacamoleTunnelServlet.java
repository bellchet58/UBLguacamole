package com.ublwarriors.guacamole.net;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.net.GuacamoleSocket;
import org.glyptodon.guacamole.net.GuacamoleTunnel;
import org.glyptodon.guacamole.net.InetGuacamoleSocket;
import org.glyptodon.guacamole.net.SimpleGuacamoleTunnel;
import org.glyptodon.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.glyptodon.guacamole.protocol.GuacamoleConfiguration;
import org.glyptodon.guacamole.servlet.GuacamoleHTTPTunnelServlet;

public class TutorialGuacamoleTunnelServlet extends GuacamoleHTTPTunnelServlet {

	@Override
    protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {

        // guacd connection information
        String hostname = "localhost";
        int port = 4822;

        // VNC connection information
        GuacamoleConfiguration config = new GuacamoleConfiguration();
        config.setProtocol("vnc");
        config.setParameter("hostname", "192.168.1.103");
        config.setParameter("port", "5900");
        config.setParameter("password", "tz8888");

        // Connect to guacd, proxying a connection to the VNC server above
        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket(hostname, port),
                config
        );

        // Create tunnel from now-configured socket
        GuacamoleTunnel tunnel = new SimpleGuacamoleTunnel(socket);
        return tunnel;

    }

	@Override
	protected void doRead(HttpServletRequest req, HttpServletResponse resp, String tunnelUUID) throws GuacamoleException {
		super.doRead(req, resp, tunnelUUID);
	}

	@Override
	protected void doWrite(HttpServletRequest req, HttpServletResponse resp, String tunnelUUID) throws GuacamoleException {
		super.doWrite(req, resp, tunnelUUID);
	}
	
	

}
