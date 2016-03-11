package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Todd
 */
public class EchoClient {

	private Socket connection;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverName;
	public static final String DEFAULT_SERVER_NAME = "localhost";
	private int portNum;
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		switch (args.length) {
		case 2:
			(new EchoClient(args[0], Integer.parseInt(args[1]))).runClient();
			break;
		case 1:
			(new EchoClient(DEFAULT_SERVER_NAME, Integer.parseInt(args[0]))).runClient();
			break;
		default:
			(new EchoClient(DEFAULT_SERVER_NAME, server.EchoServer.DEFAULT_PORT)).runClient();
		}
	}

	public EchoClient(String serverName, int portNum) {
		this.serverName = serverName;
		this.portNum = portNum;
	}

	public void runClient() {
		try {
			//create a socket
			connection = new Socket(InetAddress.getByName("Jine-THINK"),8084);
			//connection = new Socket(InetAddress.getByName(serverName), portNum); 
			//get the outputStream of the Socket connection
			output = new ObjectOutputStream(connection.getOutputStream()); 
			//get the inputStream of the Socket connection
			input = new ObjectInputStream(connection.getInputStream());  
			
			System.out.println("Connected to Server successfully. Enter CTRL+Z to Quit.");
			do {
				System.out.print("Input> ");
				//Get string from user
				message = keyboard.readLine();  
				if (message != null){
					//Send string object to server
					output.writeObject(message);
					output.flush();
					//Read string object from server
					message = (String) input.readObject();
					//Display string to user
					System.out.println(message);  
				}
			} while (message != null);
			
			input.close();
			output.close();
			connection.close();
			
		}catch(java.net.ConnectException ce){
			System.out.println("There is no running Server");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		
		}
		
	}
}
