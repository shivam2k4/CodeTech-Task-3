
package webServer;

import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.Date; 

/** * Java program to create a simple HTTP Server to demonstrate how to use 
 * * ServerSocket and Socket class. 
 * 
 * * * @author Javin Paul */ 

public class SimpleHTTPServer { 
	public static void main(String args[]) throws IOException { 
		int port = 8094;
		
			ServerSocket server = new ServerSocket(port);
			System.out.println("Listening for connection on port " + port); 
			while (true) { 
				Socket socket = server.accept();
				Date today = new Date(); 
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; 
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); 
		} 
		
	} 
	
}
