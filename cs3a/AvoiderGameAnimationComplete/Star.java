import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    private int speed = 1;
    private int twinkleTime = 0;
    private int currentTransparency = 0;
    
    public Star() {
        drawStar();
    }
    
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + speed);
        checkRemove();
        checkTwinkle();
    }    
    
    private void checkRemove() {
        World w = getWorld();
        if( getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }
    }
    
    private void checkTwinkle() {
        GreenfootImage img = getImage();
        if(twinkleTime > 0) {
            if(twinkleTime == 1) {
                img.setTransparency(currentTransparency);
            }
            twinkleTime--;
        }
        else {
            if(Greenfoot.getRandomNumber(10000) < 10) {
                twinkleTime = 10;
                currentTransparency = img.getTransparency();
                img.setTransparency(0);
            } 
        }
    }
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    private void drawStar() {
        GreenfootImage img = new GreenfootImage(10, 10);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 10, 10);
        setImage(img);
    }
}
