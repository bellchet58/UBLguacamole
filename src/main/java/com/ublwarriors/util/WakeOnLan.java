package com.ublwarriors.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WakeOnLan {
	
	Logger logger = LoggerFactory.getLogger(WakeOnLan.class);
	
	private  int PORT = 9;    
	
	public void wakeOnLan(String ipStr, String macStr, int PORT)
	{
		if(PORT > 0 )
		{
			this.PORT = PORT;
		}
        if (ipStr == null || macStr == null) {
            logger.debug("Usage: java WakeOnLan <broadcast-ip> <mac-address>");
            logger.debug("Example: java WakeOnLan 192.168.0.255 00:0D:61:08:22:4A");
            logger.debug("Example: java WakeOnLan 192.168.0.255 00-0D-61-08-22-4A");
        }												
        
        
        try {
            byte[] macBytes = getMacBytes(macStr);
            byte[] bytes = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
            }
            
            InetAddress address = InetAddress.getByName(ipStr);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, PORT);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
            
            logger.debug("Wake-on-LAN packet sent.");
        }
        catch (Exception e) {
            logger.debug("Failed to send Wake-on-LAN packet: + e");
        }
	}
	

	private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = macStr.split("(\\:|\\-)");
        if (hex.length != 6) {
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }
}