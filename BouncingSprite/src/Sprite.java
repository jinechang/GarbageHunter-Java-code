
//%W%	%G%
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * Sprite class implements Runnable interface
 * draw a blue sprite, make it move and bounce off the boundary of the JPanel 
 * check the position of the ball
 */
public class Sprite implements Runnable{

	public final static Random random = new Random();
	
	final static int SIZE = 10; //set the size of the sprite to 10
	final static int MAX_SPEED = 5;  //set the moving speed of the sprite to 5
	
	SpritePanel panel;  //create an instance of Class SpritePanel
	
	private int x;   //the horizontal position of the sprite
	private int y;   //the vertical position of the sprite
	
	private int dx;  //horizontal moving distance
	private int dy;  //vertical moving distance
	private Color color = Color.BLUE;    //set the sprite to blue color

	/*
	 * default constructor 
	 * generate randomly the position of the sprite and 
	 * its moving distance and direction 
	 */
    public Sprite (SpritePanel panel)
    {
    	this.panel = panel;
        x = random.nextInt(panel.getWidth());
        y = random.nextInt(panel.getHeight());
        dx = random.nextInt(2*MAX_SPEED) - MAX_SPEED;
        dy = random.nextInt(2*MAX_SPEED) - MAX_SPEED;
    }

    /*
     * draw the sprite with blue color
     */
    public void draw(Graphics g){
        g.setColor(color);             //set the sprite color to blue
	    g.fillOval(x, y, SIZE, SIZE);  //draw the sprite
    }
    
    /*
     * check whether the sprite reaches the edge of JPanel
     * if yes, bounce off the edge and continues 
     * in the opposite direction.
     */
    public void move(){
    	try{
        // check for bounce and make the ball bounce if necessary
        //
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
        if (x > panel.getWidth() - SIZE && dx > 0){
            //bounce off the right wall
        	x = panel.getWidth() - SIZE;
        	dx = - dx;
        }       
        if (y > panel.getHeight() - SIZE && dy > 0){
            //bounce off the bottom wall
        	y = panel.getHeight() - SIZE;
        	dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
        
        this.panel.repaint();
        //sleep while waiting to display the next frame of the animation
        Thread.sleep(40); //wake up roughly 25 frames per second
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}
    }//end move() method

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     * invoke the move() to make the sprite move
     * Synchronized ensure the thread not being interference by other thread
     */
	@Override
	//public synchronized void run() {
		public void run() {
		// while true, move the sprite about 25 frames per second
		while(true){
			
				move();  //call the move method
			
		}
	}//end run()
}//end class Sprite

