import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderGameWorld extends World
{

    /**
     * Constructor for objects of class AvoiderGameWorld.
     * 
     */
    public AvoiderGameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
    }
    
    public void act() {
        // pseudo-randomly generate enemies
        if(Greenfoot.getRandomNumber(1000) < 20) {
            Enemy e = new Enemy();
            addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
        }
    }
}
