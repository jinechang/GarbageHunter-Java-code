import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SpiteInterface extends Remote{
	/**
	 * Remotely invokable method.
	 * @exception RemoteException if the remote invocation fails
	 */
	
	// add new sprite to the server
	public void AddSprite(int x, int y, int width, int height, Color color) throws RemoteException;
	
	//get sprite list from server
	public ArrayList<Sprite> GetSprites() throws RemoteException;
	
}//end interface

