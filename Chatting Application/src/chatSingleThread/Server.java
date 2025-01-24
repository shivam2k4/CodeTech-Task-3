package chatSingleThread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

//single threading chat
public class Server {

	public static void main(String[] args) {
		
		ServerSocket server;
		try {
			server = new ServerSocket(3008);
			System.out.println("Waiting for connection");

			Socket s= server.accept();
			
			System.out.println("Connected");
			
			//getOutputStream => provide byte stream
			//DataOutputStream => converts byte stream to String
			//send it to the client 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			//receive it from the client 
			DataInputStream dis = new DataInputStream(s.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
			String usr, cl ="";
			
			
			while(true) {
				
				usr=br.readLine(); 
				//send it to client
				dos.writeUTF(usr); 
				
				
				//read what client sent me
				cl= dis.readUTF();
				System.out.println(cl);
				}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}