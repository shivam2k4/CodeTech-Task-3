package chatSingleThread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
//single threading chat client
public class Client {

	public static void main(String[] args) {
		
		try {
			Socket s=new Socket ("127.0.0.1",3007);
			
			System.out.println("Connected!");
			
			
			//getOutputStream => provide byte stream
			//DataOutputStream => converts byte stream to String
			//send it to the server 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			//receive it from the server 
			DataInputStream dis = new DataInputStream(s.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String usr, cl ="";

			
			while(true) {
				
				usr=br.readLine(); 
				//send it to server
				dos.writeUTF(usr); 
				
				
				//read what server sent me
				cl= dis.readUTF();
				System.out.println(cl);
				}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}