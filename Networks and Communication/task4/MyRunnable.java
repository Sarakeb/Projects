//take the HTTPAsk server you did in Task 3, and turn it into a concurrent server. 
//The server you did for Task 3 deals with one client at a time (most likely).
// A concurrent server can handle multiple clients in parallel.
//Hint: Use Java threading to implement a concurrent server that can handle many clients at the same time.
//Sara

import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

public class MyRunnable implements Runnable {
	 String hostNm=null;
	 String portNr= null;
	 String string=null;  //string parameter
     String req;

     Socket socketConnection;
      public MyRunnable(Socket socketConnection) {
      this.socketConnection = socketConnection;
  }


       public void run() {

       	try{
       		BufferedReader fromClientIn = new BufferedReader(new InputStreamReader(socketConnection.getInputStream())); //input stream 
         	DataOutputStream toClientOut = new DataOutputStream(socketConnection.getOutputStream());  ///output stream
         	StringBuilder strb = new StringBuilder();
         	req = fromClientIn.readLine();

         	if(req != null){ //if request is empty
         	    	

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


//java ConcHTTPAsk 8888
////http://localhost:8888/ask?hostname=java.lab.ssvl.kth.se&port=13



