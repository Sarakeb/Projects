//take the HTTPAsk server you did in Task 3, and turn it into a concurrent server. 
//The server you did for Task 3 deals with one client at a time (most likely).
// A concurrent server can handle multiple clients in parallel.
//Hint: Use Java threading to implement a concurrent server that can handle many clients at the same time.
//Sara

import java.net.*;
import java.io.*;


public class ConcHTTPAsk {

	public static void main( String[] args) throws IOException {

		try{
			ServerSocket socketServer = new ServerSocket(Integer.parseInt(args[0]));

			while (true){
				Socket socketConnection =socketServer.accept();  //client is accepted. Then connection is established with the client.
				new Thread(new MyRunnable(socketConnection)).start();   //created a thread
			}

		}	

			catch(IOException e){
				System.out.print("error");
		}
	}
}


