package Server;
import java.net.*;
import java.io.*;
public class Connection extends Thread {
      
      // initialize input output stream
	  DataInputStream in;
	  DataOutputStream out;
	  Socket clientSocket;
	  Services availableServices;
	  
	  public Connection (Socket aClientSocket, Services aS) {
	    try {
		  availableServices = aS;
		  clientSocket = aClientSocket;
		  in =  new DataInputStream( clientSocket.getInputStream());
		  out = new DataOutputStream( clientSocket.getOutputStream());
	    } catch(IOException e) {
	       System.out.println("Connection:"+e.getMessage());
	} 
	    }
	public void run(){
		try {           // an echo server
		     System.out.println("server reading data from client ");
		     
		  // read a line of data from the stream
		     String data = in.readUTF();  
		     
		     
		     // put switch here?
		     

		     // modify aS (service object) to do stuffs 
		     
		     
		     // putting stuffs as response
		     
		     
		     System.out.println("server writing data");
		     out.writeUTF(data);
		     synchronized(availableServices){
		    	 
		     }
		  }catch (EOFException e){
		     System.out.println("EOF:"+e.getMessage());
		  } catch(IOException e) {
		     System.out.println("readline:"+e.getMessage());
		  } finally{
		    try {
		      clientSocket.close();
		    }catch (IOException e){/*close failed*/}
		}
		}
	}


