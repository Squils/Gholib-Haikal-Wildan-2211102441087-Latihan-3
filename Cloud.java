import greenfoot.*;

public class Cloud extends Actor {
    private int speed = 2; // Kecepatan gerak awan

    public void act() {
        move(-speed); // Gerak awan ke kiri
        if (isAtEdge()) {
            // Jika awan mencapai batas dunia, hapus awan
            getWorld().removeObject(this);
        }
    }
}
