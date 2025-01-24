package webServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ===> This program retrieves a web page from a web server, such as www.google.com <===
 * 
 * Comppile:
 * javac SimpleSocketClientExample
 * 
 * Run: 
 * java webServer.SimpleSocketClientExample www.thidev.tk /  
 */

public class SimpleScoketClientExample
{
    public static void main( String[] args )
    {
    	//Check if user entered server (www.thidev.tk) and path( /  ) 
        if( args.length < 2 ) {
     
            System.out.println( "Usage: SimpleSocketClientExample <server> <path>" );
            System.exit( 0 );
        }
        String server = args[ 0 ];
        String path = args[ 1 ];

        System.out.println( "Loading contents of URL: " + server + "    path: " + path );

        try
        {
			//ServerSocket server = new ServerSocket(port);

            // Connect to the server
           Socket socket = new Socket( server, 80 );

            // Create input and output streams to read from and write to the server
           //We used the PrintStream to execute our GET method 
            PrintStream out = new PrintStream( socket.getOutputStream() );
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

            // Follow the HTTP protocol of GET <path> HTTP/1.0 followed by an empty line
            out.println( "GET " + path + " HTTP/1.0" );
            out.println();

            // Read data from the server until we finish reading the document
            String line = in.readLine();
            while( line != null )
            {
                System.out.println( line );
                line = in.readLine();
            }

            // Close our streams
            in.close();
            out.close();
            socket.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}