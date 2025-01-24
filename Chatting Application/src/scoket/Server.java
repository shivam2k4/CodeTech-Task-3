package scoket;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket server;
		try {
			server = new ServerSocket(3006);
			System.out.println("Waiting for connection");

			Socket s= server.accept();
			
			System.out.println("Connected");
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}