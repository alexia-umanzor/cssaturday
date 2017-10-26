import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    //Instance variables
    private int health = 3;
    private int hitDelay = 0;
    private Eye leftEye;
    private Eye rightEye;
    private int stunDelay = -1;
    private int lagDelay = -1;
    private int hitBlinkTime = 0;
    private int currentTransparency = 255;
    
    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        checkForCollisions();
    }    
    
    private void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if(stunDelay < 0) {
            if(mi != null) {
                if(lagDelay > 0) {
                    int stepX = (mi.getX() - getX()) / 40;
                    int stepY = (mi.getY() - getY()) / 40;
                    setLocation(stepX + getX(), stepY + getY());
                    lagDelay--;
                }
                else {
                    setLocation(mi.getX(), mi.getY());
                }
                leftEye.setLocation(getX() - 10, getY() - 8);
                rightEye.setLocation(getX() + 10, getY() - 8);
            }
        }
        else {
            stunDelay--;
        }
    }
    
    public void stun() {
        stunDelay = 50;
    }
    
    public void lagControls() {
        lagDelay = 150;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void addHealth() {
        if(health < 3) {
            switch(health){
                case 2:
                    setImage("skull.png");
                    break;
                case 1:
                    setImage("skull1.png");
                    break;
                default: //The only other option would be if they have 0 health.
                    setImage("skull2.png");
                    break;
            }
            health++;
            AvoiderWorld world = (AvoiderWorld) getWorld();
            world.updateHealthCounter();
        }
    }
    
    private void checkForCollisions() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if(hitDelay == 0 && enemy != null) {
            switch(health){
                case 3:
                    setImage("skull1.png");
                    break;
                case 2:
                    setImage("skull2.png");
                    break;
                case 1:
                    setImage("skull3.png");
                    break;
                default: //The only other option would be if they have 0 health. Then it's game over!
                    AvoiderWorld world = (AvoiderWorld) getWorld();
                    world.endGame();
                    break;
            }
            health--;
            hitDelay = 50;
            AvoiderWorld world = (AvoiderWorld) getWorld();
            world.updateHealthCounter();
        }
        if(hitDelay > 0) {
            hitDelay--;
            blinkMe();
        }
    }
    
    private void blinkMe() {
        GreenfootImage img = getImage();
        GreenfootImage leftEyeImg = leftEye.getImage();
        GreenfootImage rightEyeImg = rightEye.getImage();
        if(hitDelay == 0) {
            img.setTransparency(currentTransparency);
            leftEyeImg.setTransparency(currentTransparency);
            rightEyeImg.setTransparency(currentTransparency);
        }
        else if(hitDelay % 2 == 0) { //blink on all "even" numbers
            img.setTransparency(0);
            leftEyeImg.setTransparency(0);
            rightEyeImg.setTransparency(0);
        }
        else{
            img.setTransparency(currentTransparency);
            leftEyeImg.setTransparency(currentTransparency);
            rightEyeImg.setTransparency(currentTransparency);
        }
    }
    
    @Override
    protected void addedToWorld(World w) {
        leftEye = new Eye();
        rightEye = new Eye();
        w.addObject(leftEye, getX() - 10, getY() - 8);
        w.addObject(rightEye, getX() + 10, getY() - 8);
    }
}
