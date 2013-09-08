package com.uiuc.dslogs.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
				InputStream inputStream= con.getInputStream();
				InputStreamReader inputStreamReader= new InputStreamReader(inputStream);
				BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
				String command= bufferedReader.readLine();
				System.out.println("Command is : " + command);
				
				OutputStream outputStream= con.getOutputStream();
				OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
				BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter);
				bufferedWriter.write("Message Received");
				System.out.println("Message Sent to client");
				bufferedWriter.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
