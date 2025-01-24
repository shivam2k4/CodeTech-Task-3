package sendMessage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket s=new Socket ("127.0.0.1",3007);
			
			System.out.println("Connected!");
			
			
			//Serve you send to this input a message
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String msg = dis.readUTF();
			System.out.println(msg);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}