import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

/**
 * @author Jine
 *
 */

public class Sprite implements Runnable,Serializable{

	public final static Random random = new Random(); 
	
	final static int SIZE = 10;     
	final static int MAX_SPEED = 5;
	
	//left and top position of Sprite
	private int x;
	private int y;
	
	//speed and color
	private int dx;
	private int dy;
	private Color color;
	
	//size of panel
	private int widthPanel;
	private int heightPanel;
	
	//size of sprite
	private int sizeSprite;
	
	
	/**
	 * constructor
	 */
    public Sprite (int x, int y, int widthPanel, int heightPanel, Color color)
    {
    	this.color = color;
    	
    	//determine starting position and speed of sprite
    	this.x=x;
    	this.y=y;
    	this.widthPanel=widthPanel;
    	this.heightPanel=heightPanel;
    	this.color=color;
    	
    	//moving speed of Sprite
        dx = random.nextInt(2*MAX_SPEED) - MAX_SPEED; 
        dy = random.nextInt(2*MAX_SPEED) - MAX_SPEED; 
        
        //size of sprite
        sizeSprite = random.nextInt(30-SIZE +1)+SIZE;
    } // end of constructor

    //redraw a sprite by repainting of panel
    public void draw(Graphics g){
        g.setColor(color);            //set the color
	    g.fillOval(x, y, sizeSprite, sizeSprite); 
    }

 // check for bounce and make the ball bounce if necessary
    public void move(){
        if (x < 0 && dx < 0){
            //bounce off the left wall 
            x = 0;
            dx = -dx;
        }
        if (y < 0 && dy < 0){
            //bounce off the top wall
            y = 0;
            dy = -dy;
        }
        if (x > widthPanel - SIZE && dx > 0){
            //bounce off the right wall
        	x = widthPanel - SIZE;
        	dx = - dx;
        }       
        if (y > heightPanel - SIZE && dy > 0){
            //bounce off the bottom wall
        	y = heightPanel - SIZE;
        	dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
    }

    //invoke move() to create a sprite and move itself
	@Override
	public void run() {
		while(true){
			try{
				move();
				
				//sleep while waiting to display the next frame of the animation
				Thread.sleep(40); 
			} // end try
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}//end while
	}//end run

}
