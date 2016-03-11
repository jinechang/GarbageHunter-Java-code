import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class SpriteClientPanel extends JPanel implements Runnable,Serializable{
	private ArrayList<Sprite> spriteList;
	private Random random = new Random();
	private Color color;
	
	private SpriteClient client;
	
	public SpriteClientPanel(SpriteClient client){
		this.client=client;
		
		//create color of the sprite randomly
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		color = new Color(r,g,b);
		
		spriteList = new ArrayList<Sprite>();
		addMouseListener(new Mouse());
		
	}
	
	//when a mouse is pressed, create a new sprite
	private class Mouse extends MouseAdapter {
		@Override
		public void mousePressed( final MouseEvent event ){
			newSprite(event);
		} 
	} 
	
	private void newSprite(MouseEvent event) {
		try{
			System.out.println(event);
			//client.sprites.AddSprite(event.getX(), event.getY(), this.getWidth(), this.getHeight(), color);
			client.sprites.AddSprite(event.getX(), event.getY(), 400, 400, color);
			System.out.println("New Sprite is created with color: " +color);
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		catch(NullPointerException ne){
			System.out.println("Client didn't connect to server yet.");
		}
		
		
	}

	@Override
	public void run() {
		try{
			while(true){
				spriteList = client.sprites.GetSprites();
				repaint();
				try{
					Thread.sleep(40);
				}catch(InterruptedException exception){
					exception.printStackTrace();
				}
			}
		}catch (RemoteException e){
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (Sprite sprite:spriteList){
			sprite.draw(g);
		}
	}

}

