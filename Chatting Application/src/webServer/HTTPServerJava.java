package webServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HTTPServerJava {
    public static void main(String args[]) throws IOException, ParseException {

        ServerSocket server = new ServerSocket(8095);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try (Socket socket = server.accept()) {
                Date today = new Date();
               // Date newYear = new Date("12/25/19 00:00:00");
                Date newYear = java.text.DateFormat.getDateInstance().parse("12/25/19 00:00:00");
              

                long duration  = newYear.getTime() - today.getTime();

                long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);

                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + diffInDays + " days left for Christmas!";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}