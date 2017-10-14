import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderGameIntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderGameIntroWorld extends World
{

    //INSTANCE VARIABLES
    private GreenfootSound introMusic;
    private boolean playedMusicYet;
    
    /**
     * Constructor for objects of class AvoiderGameIntroWorld.
     * 
     */
    public AvoiderGameIntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        introMusic = new GreenfootSound("sounds/intro.mp3");
        playedMusicYet = false;
    }
    
    public void act() {
        // Restart the game if the user clicks the mouse anywhere
        if(!playedMusicYet) {
            introMusic.play();
            playedMusicYet = true;
        }
        if(Greenfoot.mouseClicked(this)) {
            introMusic.stop();
            AvoiderGameWorld world = new AvoiderGameWorld();
            Greenfoot.setWorld(world);
        }
    }
}
