import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Clover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clover extends PowerItem
{
    public Clover(int targetX, int targetY, int expireTime) {
        super(targetX, targetY, expireTime);
    }
    
    protected double curveX(double f) {
        return f;
    }
    
    protected double curveY(double f) {
        return Math.sin(4 * f);
    }
    
    protected void checkHitAvatar() {
        Avatar a = (Avatar) getOneIntersectingObject(Avatar.class);
        if(a != null) {
            a.lagControls();
            getWorld().removeObject(this);
        }
    } 
}
