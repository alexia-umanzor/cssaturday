import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerItems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PowerItem extends SmoothMover
{
    // Instance Variables
    protected double targetX, targetY, expireTime;
    protected double origX, origY;
    protected double duration;
    protected int counter;
    
    public PowerItem(int targetX, int targetY, int expireTime) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.expireTime = expireTime;
        counter = 0;
        duration = this.expireTime;
    }
    
    @Override
    protected void addedToWorld(World w) {
        origX = getX();
        origY = getY();
    }
    
    /**
     * Act - do whatever the PowerItems wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        easing();
        checkHitAvatar();
        checkExpire();
    }    
    
    //These methods are abstract, since each subclass will have their own implementation
    protected abstract double curveX(double f);
    
    protected abstract double curveY(double f);
    
    protected abstract void checkHitAvatar();
    
    protected void easing() {
        counter++;
        double fX = counter / duration;
        double fY = counter / duration;
        fX = curveX(fX);
        fY = curveY(fY);
        // if orig is (10, 10) and target is (100, 100) and duration is 4
        // first setLocation is (100 * (1 / 4) + (10 * 1 - (1 / 4))
        // so it's setLocation(25 + 7.5 = 32.5, same idea for y value)
        setLocation((targetX * fX) + (origX * (1 - fX)), (targetY * fY) + (origY * (1 - fY)));
    }
    
    private void checkExpire() {
        if(expireTime < 0) {
            World w = getWorld();
            if( w != null) {
                w.removeObject(this);
            }
        }
        else {
            expireTime--;
        }
    }
}
