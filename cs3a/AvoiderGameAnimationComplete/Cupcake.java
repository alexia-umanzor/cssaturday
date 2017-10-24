import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cupcake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cupcake extends PowerItem
{
    public Cupcake(int targetX, int targetY, int expireTime) {
        super(targetX, targetY, expireTime);
    }
    
    protected double curveX(double f) {
        return f;
    }
    
    protected double curveY(double f) {
        return f;
    }
    
    protected void checkHitAvatar() {
        Avatar a = (Avatar) getOneIntersectingObject(Avatar.class);
        if(a != null) {
            a.stun();
            getWorld().removeObject(this);
        }
    }
}