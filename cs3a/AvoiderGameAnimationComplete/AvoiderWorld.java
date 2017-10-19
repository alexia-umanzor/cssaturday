import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderWorld extends World
{
    private GreenfootSound bgm;
    private Counter scoreBoard;
    private Counter levelCounter;
    private int enemySpawnRate = 20;
    private int enemySpeed = 2;
    private int currentLevel = 1;
    private int nextLevel = 50;

    /**
     * Constructor for objects of class AvoiderWorld.
     * 
     */
    public AvoiderWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 

        // Initialize the music
        bgm = new GreenfootSound("sounds/bgm.mp3"); // Music credit: Contra (NES) by Konami
        bgm.playLoop(); // Play the music

        // Add the player and scoreboard to the world
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add t x x,hem to the world.
     */
    private void prepare()
    {
        Avatar avatar = new Avatar();
        addObject(avatar, getWidth() / 2, getHeight() / 2);
        scoreBoard = new Counter("Score: ");
        addObject(scoreBoard, 70, 50);
        levelCounter = new Counter("Level: ");
        levelCounter.setValue(1);
        addObject(levelCounter, 70, 20);
    }

    public void act() {
        // Randomly add enemies to the world
        if(Greenfoot.getRandomNumber(1000) < 20) {
            Enemy e = new Enemy();
            e.setSpeed(enemySpeed);
            addObject(e, Greenfoot.getRandomNumber(getWidth() - 20)+ 10, -30);
            // Give us some points for facing yet another enemy
            scoreBoard.setValue(scoreBoard.getValue() + 1);
        }
        increaseLevel();
    }

    public void endGame() {
        bgm.stop();
        AvoiderGameOverWorld go = new AvoiderGameOverWorld();
        Greenfoot.setWorld(go);
    }
    
    private void increaseLevel() {
        int score = scoreBoard.getValue();
        if(score >= nextLevel) {
            enemySpawnRate += 2;
            enemySpeed++;
            currentLevel++;
            levelCounter.setValue(levelCounter.getValue() + 1);
            nextLevel += 50;
        }
    } 
}
