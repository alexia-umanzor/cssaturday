import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Eye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eye extends Actor
{
    
    public Eye() {
        drawEye(2, 2);
    }
    
    /**
     * Act - do whatever the Eye wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()  
    {
        // Add your action code here.
        lookAtEnemies();
    }    
    
    private void drawEye(int dx, int dy) {
        GreenfootImage img = new GreenfootImage(10, 10);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 10, 10);
        img.setColor(Color.BLACK);
        img.fillOval(dx, dy, 6, 6);
        setImage(img);
    }
    
    private void lookAtEnemies() {
        List<Enemy> eList = getObjectsInRange(120, Enemy.class);
        if(!eList.isEmpty()) { //is there at least one enemy nearby?
            Enemy e = eList.get(0); //get the first (i.e., nearest) enemy in the list
            if(e.getX() < getX()) { //if the enemy is to the left of me     
                if(e.getY() < getY()) { //if the enemy is above me
                    drawEye(1, 1);
                }
                else { //otherwise they are below me
                    drawEye(1, 3);
                }            
            }
            else {
                if(e.getY() < getY()) { //if the enemy is above me
                    drawEye(3, 1);
                }
                else { //otherwise they are below me
                    drawEye(3, 3);
                } 
            }
        }
        else {
            drawEye(2, 2);
        }
    }
}
