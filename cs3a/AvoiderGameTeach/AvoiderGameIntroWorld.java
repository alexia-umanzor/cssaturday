import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderGameIntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderGameIntroWorld extends World
{

    /**
     * Constructor for objects of class AvoiderGameIntroWorld.
     * 
     */
    public AvoiderGameIntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act() {
        // Restart the game if the user clicks the mouse anywhere
        if(Greenfoot.mouseClicked(this)) {
            AvoiderGameWorld world = new AvoiderGameWorld();
            Greenfoot.setWorld(world);
        }
    }
}
