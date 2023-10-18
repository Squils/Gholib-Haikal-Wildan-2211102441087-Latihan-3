import greenfoot.*;
import java.util.Random;

public class MyWorld extends World {
    private Bird bird;
    private int cloudSpawnTimer = 100; // Waktu antara spawn awan (misalnya, 100 act cycles)
    private int actCycle = 0;

    public MyWorld() {
        super(600, 400, 1);
        bird = new Bird();
        addObject(bird, getWidth() / 2, getHeight() / 2);
    }

    public void act() {
        actCycle++;
        
        // Spawn awan setiap cloudSpawnTimer act cycles
        if (actCycle % cloudSpawnTimer == 0) {
            spawnCloud();
        }
        
        // ...
    }

    private void spawnCloud() {
        Cloud cloud = new Cloud();
        int y = Greenfoot.getRandomNumber(getHeight() / 5); // Posisi vertikal acak
        addObject(cloud, getWidth(), y);
    }
}
