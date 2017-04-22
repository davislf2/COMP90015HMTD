package Server;
import java.net.*;
import java.io.*;
import java.util.Arrays;

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
		     System.out.println("server reading command from client ");
		     
		  // read a line of data from the stream
		     String data = in.readUTF();  
		     
		     
		     // put switch here?
		     

		     // modify aS (service object) to do stuffs 
		     
		     
		     // putting stuffs as response
		     
		     
		     // fetch command needs to be done here as it's 
		     // a connection
		     String URI = "the uri";
		     String command = "fetch";
		     if (command.equals("fetch")){
			   try {
				 File f = new File(URI);
				 RandomAccessFile byteFile = new RandomAccessFile(f,"r");
				 byte[] sendingBuffer = new byte[1024*1024];
				 int left;
				 while((left = byteFile.read(sendingBuffer)) > 0){
				       System.out.println("file left " + left);
				       out.write(Arrays.copyOf(sendingBuffer, left));
				 }
				 byteFile.close();

			   } catch (FileNotFoundException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			   }

			   System.out.println("server writing data");
		     }
		     // for other commands
		     else{
		     out.writeUTF(data);
		     }
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


