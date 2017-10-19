import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed = 1;
    private GreenfootImage imgA = new GreenfootImage("images/smiley1.png");    
    private GreenfootImage imgB = new GreenfootImage("images/smiley4.png");     
    private GreenfootImage imgC = new GreenfootImage("images/smiley3.png");  
    private GreenfootImage imgD = new GreenfootImage("images/smiley5.png");   
    
    public Enemy() {
        setImage(imgA);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + speed);
        changeDisposition();
        checkRemove();
    }    
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    /**
     * Change the image of the enemy based on its vertical position in the world.
     */
    private void changeDisposition() {
        int ypos = getY(); //store y position of the enemy
        int worldHeight = getWorld().getHeight();
        int marker1 = (int) (worldHeight * 0.5);
        int marker2 = (int) (worldHeight * 0.75);
        int marker3 = (int) (worldHeight * 0.90);
        if( getImage() == imgA && ypos > marker1) {
            setImage(imgB);
        }
        else if( getImage() == imgB && ypos > marker2) {
            setImage(imgC);
        }
        else if( getImage() == imgC && ypos > marker3) {
            setImage(imgD);
        }
    }
    
    private void checkRemove() {
        World w = getWorld();
        if(getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }
    }
}
