/*
implement a class called HTTPAsk. It's "main" method implements the server. 
It takes one argument: the port number. So if you want your server to run on port 8888, you would start it in the following way:
*/
import java.net.*;
import java.io.*;

import tcpclient.TCPClient;

//Sara

public class HTTPAsk {
    public static void main( String[] args) throws IOException {
        // Your code here

        ServerSocket socketServer = new ServerSocket(Integer.parseInt(args[0]));  //created a socket and opened a port, in this case for port 8888
        String portNr;
        String hostNm;
        String string;  //string parameter
        String req;


        while(true){
        	try {
        	
        		Socket socketConnection =socketServer.accept();  //client is accepted. Then connection is established with the client.
        		BufferedReader fromClientIn = new BufferedReader(new InputStreamReader(socketConnection.getInputStream())); //input stream 
         	    DataOutputStream toClientOut = new DataOutputStream(socketConnection.getOutputStream());  ///output stream
         	    StringBuilder strb = new StringBuilder();
         	    req = fromClientIn.readLine();


         	    if(req != null){ //if request is empty
         	    	hostNm= null;  //reset the values, then split them
         	    	string=null;
         	    	portNr=null;

         	    	String[] arrayStr = req.split("[?&= ]");
         	    	for(int i = 0; i < arrayStr.length; i++){
         	    		if(arrayStr[i].equals("hostname"))
         	    			hostNm = arrayStr[++i];
         	    		else if(arrayStr[i].equals("port"))
         	    			portNr = arrayStr[++i];
         	    		else if(arrayStr[i].equals("string"))
         	    			string  = arrayStr[++i];
            }
         	    	
        	
        	//fall 2
        if((hostNm != null) && (portNr != null)){
              		try{ 
        			String responseServ = TCPClient.askServer(hostNm,Integer.parseInt(portNr),string); 
               		String OkHTTP = "HTTP/1.1 200 OK\r\n\r\n";
               		toClientOut.writeBytes(OkHTTP + responseServ);
               	}
               	// else {
               	catch(IOException e){

                 String notFoundHTTP  = "HTTP/1.1 404 Not Found\r\n";
               	 toClientOut.writeBytes(notFoundHTTP);
           }
       }
               
       else {
               	String badRequestHTTP = "HTTP/1.1 400 Bad Request\r\n";
                toClientOut.writeBytes(badRequestHTTP); 
               	}
               }
               	 socketConnection.close(); //close connection
           } 

         catch (IOException e){
         System.exit(1);
     }
      }
  }
}

//on browser

//http://localhost:8888/ask?hostname=java.lab.ssvl.kth.se&port=7&string=hiii   
//http://localhost:8888/ask?hostname=java.lab.ssvl.kth.se&port=19
//http://localhost:8888/ask?hostname=java.lab.ssvl.kth.se&port=13
//http://localhost:8888/ask?hostname=whois.iis.se&port=43&string=kth.se
//http://localhost:8888/ask?hostname=whois.internic.net&port=43&string=kth.se



//on telnet
//telnet 127.0.0.1 8888

//GET /ask?hostname=time.nist.gov&port=13 HTTP/1.1				:daytime server
//GET /ask?hostname=whois.iis.se&port=43&string=kth.se HTTP/1.1 
//GET /ask?hostname=whois.internic.net&port=43&string=kth.se HTTP/1.1 
//etc.....

