package com.uiuc.dslogs.listener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Aman's Alien
 * 
 */
public class CommandListener {

	public void startService(final Integer socket) {
		new Thread(new Runnable() {
			public void run() {
				startServer(socket);
			}
		}).start();
	}

	public void startServer(Integer socket) {
		try {

			ServerSocket serverSocket = new ServerSocket(socket);
			System.out.println("Listening on port : "
					+ serverSocket.getLocalPort());

			while (true) {
				Socket con = serverSocket.accept();
				System.out.println("Accepting connection on port : " + socket);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
