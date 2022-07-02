/*
implement a web server.
The server accepts an incoming TCP connection, reads data from it until the client closes
the connection, and returns ("echoes") an HTTP response back with the data in it. 

Sara

*/
import java.net.*;
import java.io.*;

public class HTTPEcho {
    public static void main( String[] args) throws  IOException {
        // Your code here

        //int portNr= Integer.parseInt(args[0]);
        //ServerSocket socketServer= new ServerSocket(portNr);
        ServerSocket socketServer = new ServerSocket(Integer.parseInt(args[0]));  //created a socket and opened a port, in this case for port 8888
        String inClient;
        String headerHTTP="HTTP/1.1 200 OK\r\n\r\n";   //200 OK, means the request has succeeded. 
        //"HTTP marks end of line with carriage returned, followed by line feed." -->\r\n


         while(true){ //created an infinite loop


         	 Socket socketConnection =socketServer.accept();  //client is accepted. Then connection is established with the client.
         	 BufferedReader fromClientIn = new BufferedReader(new InputStreamReader(socketConnection.getInputStream())); //input stream 
         	 DataOutputStream toClientOut = new DataOutputStream(socketConnection.getOutputStream());  ///output stream
         	 StringBuilder strb = new StringBuilder();
         	 strb.append(headerHTTP);


         	 while((inClient = fromClientIn.readLine()) != null && inClient.length() != 0){ //iterate as long as it is; not empty line and inClient is not empty

         	 	//System.out.println(inClient); ///////

         	 	strb.append(inClient + "\r\n");

         	 }

         	 toClientOut.writeBytes(strb.toString());
         	 socketConnection.close();  //connection closed
         	}        
     
    }
}
/*

tester:
java HTTPEcho 8888   ----> on cmd
http://localhost:8888  ----> on browser
telnet 127.0.0.1 8888   ---> when testing with telnet

*/