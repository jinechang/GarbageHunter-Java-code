import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SpriteServer {
	/**
	 * Server Program
	 * @author jine
	 */
	
	public static void main(String[] argv){
		try{
			//server runs the registry on port 1099
			LocateRegistry.createRegistry(1099);
			
			//a client will need to look up the remote object using SpritesService 
			Naming.rebind("SpritesService", new SpriteInterfaceImpl());
			System.out.println(new SpriteInterfaceImpl());
			System.out.println("Sprites Server is ready.");
			System.out.println("Waiting for client request...");
		}catch(Exception e){
			System.out.println("Sprites Server failed: "+e);
		}
	}

}


