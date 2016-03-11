

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/* class SpritePanel extends JPanel
 * for every mouse click event, a sprite is created and 
 * begins moving. When the ball hits the edge of the JPanel,
 * it bounces off the edge and continues in the opposite direction.  
 */
public class SpritePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Sprite sprite; 
	
	/*
	 * SpritePanel constructor
	 */
	public SpritePanel(){
		addMouseListener(new Mouse()); //add MouseListener
	}
	
	//method newSprite for creating a new ball with a mouse click event
	//private synchronized void newSprite (MouseEvent event){
	private void newSprite (MouseEvent event){
		sprite = new Sprite(this); //create a new ball
		
		new Thread(sprite).start(); //new Thread run
		
		System.out.println("New ball created");
	}
	
	public void animate(){
	    while (true){
	        repaint();
	    }
	}
	
	private class Mouse extends MouseAdapter {
		@Override
	    public void mousePressed( final MouseEvent event ){
	        newSprite(event);
	    }
	}


	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
			sprite.draw(g);
		
	}
}

