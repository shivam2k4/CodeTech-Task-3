package chatting.application;


import java.io.*;
import java.net.*;
//multithreading client chat
public class Client implements Runnable{

	Socket s;
	DataOutputStream dos;
	DataInputStream dis;
	BufferedReader br;
	String usr;
	Thread th;
	
	
	//Constructor with all the objects
	Client(){
		try {
			System.out.println("Waiting for connection");
				
			//Local host= "127.0.0.1" and port number =3014
			s= new Socket("127.0.0.1",3014);
			
			System.out.println("Connected");
			
			//getOutputStream => provides byte stream
			//DataOutputStream => converts byte stream to String
			//send it to the client 
			dos = new DataOutputStream(s.getOutputStream());
			
			//receive it from the client 
			dis = new DataInputStream(s.getInputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			th = new Thread(this);
			th.start();
			
				while(true) {
					//read what SERVER sent me
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
		new Client();
	}

}