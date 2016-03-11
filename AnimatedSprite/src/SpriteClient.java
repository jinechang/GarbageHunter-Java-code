import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

public class SpriteClient {
	
	private JFrame frame;
	private SpriteClientPanel panel;
	public SpiteInterface sprites = null;
	
	public SpriteClient(){
		frame = new JFrame("Bouncing Sprite");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new SpriteClientPanel(this);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args){
		String serverName = "localhost";
		
		if(args.length == 1)
			serverName = args[0];
		
		SpriteClient client = new SpriteClient();
		
		try{
			//query a registry and return a remote reference to the server object
			client.sprites = (SpiteInterface)Naming.lookup("rmi://"+serverName + "/SpritesService");
			
			System.out.println("Connected to RMI Server: "+client.sprites.toString());
		}catch(MalformedURLException murle){
			murle.printStackTrace();
		}catch(RemoteException re){
			re.printStackTrace();
		}catch(NotBoundException nbe){
			nbe.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Exception: " + e);
		}
		
		//create and start thread to draw sprites
		Thread thread = new Thread(client.panel);
		thread.start();
	}

}

