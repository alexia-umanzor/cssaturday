import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    //instance variables
    private GreenfootSound deathSound;
    
    public Avatar() {
        deathSound = new GreenfootSound("sounds/death.wav");
    }
    
    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        followMouse();
        checkForCollisions();
    }  
    
    private void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if(mi != null) {
            setLocation(mi.getX(), mi.getY());
        }
    }
    
    private void checkForCollisions() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if(enemy != null) {
            deathSound.play();
            AvoiderGameWorld world = (AvoiderGameWorld) getWorld();
            world.endGame();
        } 
    }
}