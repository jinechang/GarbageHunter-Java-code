package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * 
 * @author Todd
 * @modified by Jine Chang
 */
public class EchoServer{

	private Socket connection;
	private ServerSocket server;
	private int portNum;
	public static final int DEFAULT_PORT = 8082;

	public static void main(String[] args) {
		if (args.length > 0) {
			(new EchoServer(Integer.parseInt(args[0]))).runServer();
		} else {
			(new EchoServer(DEFAULT_PORT)).runServer();
		}
	}//end main

	public EchoServer(int portNum) {
		this.portNum = portNum;
	}//end EchoServer

	public void runServer() {
		System.out.println("Echo Server Started...");
		try {
			//Server creates a ServerSocket
			server = new ServerSocket(portNum);
			while(true){
				//wait for a connection
				connection = server.accept();
				System.out.println("New connection is created");
				//create a new Thread for this connection
				new Thread(new Runnable(){
					public void run(){
						connec(connection);
					}
				}).start();
				
			}//end while
		}catch (java.net.BindException be){
			System.out.println("Port "+DEFAULT_PORT+ "in use");
		} catch (java.net.SocketException e1) {
			System.out.println("Server is waiting...");
			e1.printStackTrace();

		} catch (IOException e1) {
				e1.printStackTrace();
		}  
		
	}// end runServer()
	
	public void connec(Socket connection) {
		ObjectOutputStream output;
		ObjectInputStream input;
		String message = "";
		int messagenum = 0;
		
		try{
			//get the outputStream of the Socket connection
			output = new ObjectOutputStream(connection.getOutputStream());  
			//get the inputStream of the Socket connection
			input = new ObjectInputStream(connection.getInputStream()); 
			
			do {
				try {
					//Server receives objects (Strings) from client
					message = (String) input.readObject(); 
				}catch (EOFException e){
					message = null;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if (message != null){
					output.writeObject(++messagenum + " From Server> " + message);//Server transmits objects (Strings) to client
					output.flush();
				}
			} while (message != null);
			
			input.close();
			output.close();
			connection.close();	
			
		} //end try
		catch(java.io.StreamCorruptedException sce){
			sce.printStackTrace();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}//end catch
		System.out.println("A client disconnects to server");
	}//end connect
	
}//end class EchoServer
