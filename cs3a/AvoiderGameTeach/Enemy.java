import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    //Instance Variable
    private int speed;
   
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX(), getY() + speed);
        checkRemove();
        turn(5);
    }    
    
    private void checkRemove() {
        World w = getWorld();
        if(getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
