
/*
 This app bounces a blue ball inside a JPanel.  The ball is created and begins
 moving with a mousePressed event.  When the ball hits the edge of
 the JPanel, it bounces off the edge and continues in the opposite
 direction.  
*/

import javax.swing.JFrame;

public class BouncingSprites {
	
    private JFrame frame; 
    private SpritePanel panel = new SpritePanel(); //create a SpritePanel object

    /*
     * create an JFrame object and add a SpritePanel object to it
     */
    public BouncingSprites() {
        frame = new JFrame("Bouncing Ball"); //create a JFrame object
        frame.setSize(400, 400); //set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the frame when exit
        frame.add(panel); //add panel to the frame
        frame.setVisible(true); //set the frame visible
    }
 
    
    public static void main(String[] args) {
        new BouncingSprites().panel.animate();
    }//end main()
}//end class BouncingSprites

