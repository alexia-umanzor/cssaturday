import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderGameWorld extends World
{
    //Instance Variables / Fields
    private GreenfootSound bgmusic;
    
    /**
     * Constructor for objects of class AvoiderGameWorld.
     * 
     */
    public AvoiderGameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        setAvatar(); 
        bgmusic = new GreenfootSound("sounds/clotho.mp3");
        //bgmusic.playLoop();
        
    }
    
    public void act() {
        // pseudo-randomly generate enemies
        if(Greenfoot.getRandomNumber(1000) < 20) {
            Enemy e = new Enemy();
            addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
        }
    }
    
    private void setAvatar() {
        Avatar a = new Avatar();
        addObject(a, 300, 350);
    }
    
    public void endGame() {
        bgmusic.stop();
        AvoiderGameOverWorld go = new AvoiderGameOverWorld();
        Greenfoot.setWorld(go);
    }
}
