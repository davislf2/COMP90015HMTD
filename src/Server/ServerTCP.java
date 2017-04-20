package Server;
import java.net.*;


import java.io.*;

public class ServerTCP extends Thread{
	int serverPort; // the server port
	ServerSocket listenSocket;
	Services TCPService;

	public ServerTCP(int port)
	{
		serverPort = port;	
		TCPService = new Services();
	}
	public void run()
	{
		try
		{
			listenSocket = new ServerSocket(serverPort);
			while(true) {
				// listen and accept the incoming connection
			      	System.out.println("Server listening for a connection");
				Socket clientSocket = listenSocket.accept();
				
				// create new connection with connected socket
				System.out.println("Received connection ");
				Connection c = new Connection(clientSocket, TCPService);
				c.run();
				}
			}
		catch(IOException e)
		{
	       System.out.println("Listen socket:"+e.getMessage());
	     }
}
}
