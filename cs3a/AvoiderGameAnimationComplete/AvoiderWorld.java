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
    private Counter healthCounter;
    private int enemySpawnRate = 20;
    private int enemySpeed = 2;
    private int currentLevel = 1;
    private int nextLevel = 50;
    private Avatar avatar;
    
    /**
     * Constructor for objects of class AvoiderWorld.
     * 
     */
    public AvoiderWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        setPaintOrder(Eye.class, Avatar.class, Enemy.class, Counter.class);
        
        // Initialize the music
        bgm = new GreenfootSound("sounds/bgm.mp3"); // Music credit: Contra (NES) by Konami
        bgm.playLoop(); // Play the music

        // Add the player and scoreboard to the world
        prepare();
        generateInitialStarField();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add t x x,hem to the world.
     */
    private void prepare()
    {
        avatar = new Avatar();
        addObject(avatar, getWidth() / 2, getHeight() / 2);
        scoreBoard = new Counter("Score: ");
        addObject(scoreBoard, 70, 50);
        levelCounter = new Counter("Level: ");
        levelCounter.setValue(1);
        addObject(levelCounter, 70, 20);
        healthCounter = new Counter("Lives: ");
        healthCounter.setValue(avatar.getHealth());
        addObject(healthCounter, 70, 80);
    }

    public void act() {
        generateEnemies();
        generateStars(-1);
        increaseLevel();
    }
    
    /**
     * Randomly add enemies to the world.
     */
    
    private void generateEnemies() {
        if(Greenfoot.getRandomNumber(1000) < 20) {
            Enemy e = new Enemy();
            e.setSpeed(enemySpeed);
            addObject(e, Greenfoot.getRandomNumber(getWidth() - 20)+ 10, -30);
            // Give us some points for facing yet another enemy
            scoreBoard.setValue(scoreBoard.getValue() + 1);
        }
    }
    
    private void generateStars(int yLoc) {
        if(Greenfoot.getRandomNumber(1000) < 350) {
            Star s = new Star();
            GreenfootImage image = s.getImage();
            if( Greenfoot.getRandomNumber(1000) < 300) {
                // this is a close bright star
                s.setSpeed(4);
                image.setTransparency(Greenfoot.getRandomNumber(25) + 225);
                image.scale(4, 4);
            }
            else {
                // this is a further dim star
                s.setSpeed(3);
                image.setTransparency(Greenfoot.getRandomNumber(50) + 100);
                image.scale(2, 2);
            }
            s.setImage(image);
            addObject(s, Greenfoot.getRandomNumber(getWidth() - 20) + 10, yLoc);
        }
    }
    
    private void generateInitialStarField() {
        for(int i = 0; i < getHeight(); i++) {
            generateStars(i);
        }
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
    
    public void updateHealthCounter() {
        healthCounter.setValue(avatar.getHealth());
    }
}
