package chatting.application;

import java.io.*;
import java.net.*;
//MULTI threading CHAT
public class Server implements Runnable{

	ServerSocket server;
	Socket s;
	DataOutputStream dos;
	DataInputStream dis;
	BufferedReader br;
	String usr;
	Thread th;
	
	
	//Constructor with all the objects
	Server(){
		try {
			//port number =3014
			server = new ServerSocket(3014);
			System.out.println("Waiting for connection");
	
			s= server.accept();
			
			System.out.println("Connected");
			
			//getOutputStream => provide byte stream
			//DataOutputStream => converts byte stream to String
			//send it to the client 
			dos = new DataOutputStream(s.getOutputStream());
			
			//receive it from the client 
			dis = new DataInputStream(s.getInputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			th = new Thread(this);
			th.start();
			
				while(true) {
					//read what client sent me
					System.out.println(dis.readUTF());
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {

			while(true) {
				
				try {
					usr=br.readLine();
					//send it to client
					dos.writeUTF(usr); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	
	public static void main(String arg[]) {
		new Server();
	}

}