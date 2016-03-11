import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * export Class SpriteInterfaceImpl to RMI
 * @author jine
 */
public class SpriteInterfaceImpl extends UnicastRemoteObject implements SpiteInterface{
	private ArrayList<Sprite> sprites;
	
	//Construct a remote object
	public SpriteInterfaceImpl() throws RemoteException{
		sprites = new ArrayList<Sprite>();
	}
	/**
	 * AddSprite and GetSprites: remote invokable method
	 * @exception RemoteException if the remote invocation fails
	 */
	@Override
	public void AddSprite(int x, int y, int width, int height, Color color) throws RemoteException {
		//create a new sprite
		Sprite sprite = new Sprite(x,y,width,height,color);
		
		//add to the array list
		sprites.add(sprite);
		
		//starting the first thread
		Thread thread = new Thread(sprite);
		thread.start();
		
		System.out.println("Add a new sprite with color: "+color);
		
	}

	@Override
	public ArrayList<Sprite> GetSprites() throws RemoteException {
		return sprites;
	}
}

