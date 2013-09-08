package com.uiuc.dslogs.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uiuc.dslogs.model.Node;

/**
 * Implementation of connector service to connect different nodes
 * 
 * @author Aman's Alien
 * 
 */
public class ConnectorService implements IConnectorService<Node> {

	private static final Integer TIMEOUT = 1000; //1 sec

	public Map<String, Integer> connect(List<Node> nodes) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Node node : nodes) {
			Socket socket = new Socket();
			InetSocketAddress endPoint = new InetSocketAddress(
					node.getIpAddress(), node.getSocket());

			if (endPoint.isUnresolved()) {

				System.out.println("Failure " + endPoint);
				result.put(node.getIpAddress(), -1);

			} else
				try {
					
					socket.connect(endPoint, TIMEOUT);
					System.out.printf("Success:    %s  \n", endPoint);
					OutputStream outputStream= socket.getOutputStream();
					OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
					BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter);
					bufferedWriter.write("grep");
					System.out.println("Message Sent to server");
					bufferedWriter.flush();
					

				} catch (IOException ioe) {

					System.out.printf("Failure:    %s message: %s - %s \n",
							endPoint, ioe.getClass().getSimpleName(),
							ioe.getMessage());

				} finally {

					if (socket != null)
						try {
							socket.close();
						} catch (IOException ioe) {
						}

				}
		}
		return result;
	}

}
