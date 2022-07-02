/*
1) Open a TCP connection to a server at a given host address and port number.
2) Take any data that the server sends, and and print the data.
3) TCPAsk takes an optional string as parameter. This string is
   sent as data to the server when the TCP connection is opened, followed by a newline character (linefeed '\n').
*/
   //Sara 

package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

    public static String askServer(String hostname, int port, String ToServer) throws  IOException {  	
    	//for de fall, da ToServer ar tom
//	    	if(ToServer == null){   //om Toserver ar null, 
//	         return askServer(hostname, port);
//	        }

        int lineCounter=0;
        int size= 50;

    	//skapar en socket som tar 2 parameter, hostname och port
    	Socket socketClient= new Socket (hostname, port);
    	//System.out.println("Connected");
    	socketClient.setSoTimeout(1000);  //satter timeOut till 5000ms
    	//output stream
    	DataOutputStream outToServer = new DataOutputStream(socketClient.getOutputStream());
    	//input stream
    	BufferedReader inFromServer =new BufferedReader(new InputStreamReader(socketClient.getInputStream())); 
    	//skicka linjen till servern
		outToServer.writeBytes(ToServer + '\n'); 

		
    	StringBuilder strb = new StringBuilder();
    	String s= null;		

	         
		try {
			

while((s = inFromServer.readLine()) != null && lineCounter < size) { //tills det inte finns nagon data att lasa, och nar size ar storre.
                strb.append(s + "\n");
                lineCounter++; //rakna antal linjer.
        }

            socketClient.close();
            return strb.toString();


        }
        catch( IOException e){  //catch the exception  
        socketClient.close();      	
         return strb.toString();

        }      
        
}


//sker da vi inte har String ToServer 
    public static String askServer(String hostname, int port) throws  IOException {
        return askServer(hostname, port, "");
    	
    }

}



/*
Sara
tester:
java TCPAsk time.nist.gov 13
java TCPAsk whois.iis.se 43 kth.se
java TCPAsk java.lab.ssvl.kth.se 7 hii
java TCPAsk java.lab.ssvl.kth.se 9 hii
java TCPAsk java.lab.ssvl.kth.se 19
etc...

*/