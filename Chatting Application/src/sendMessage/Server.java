package sendMessage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket server;
		try {
			server = new ServerSocket(3007);
			System.out.println("Waiting for connection");

			Socket s= server.accept();
			
			System.out.println("Connected");
			
			//getOutputStream => provide byte stream
			//DataOutputStream => converts byte stream to String
			//send it to the client input
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Welcome to Socket");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}