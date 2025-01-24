package scoket;

import java.io.IOException;
import java.net.*;

public class Clent {

	public static void main(String[] args) {
		
		try {
			Socket s=new Socket ("127.0.0.1",3000);
			
			System.out.println("Connected!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}