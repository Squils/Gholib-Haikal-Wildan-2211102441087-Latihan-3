import greenfoot.*;

public class Bird extends Actor {
    private int verticalSpeed = 0;
    private final int GRAVITY = 1;
    private int jumpsRemaining = 10; // Menyimpan sisa lompatan yang bisa dilakukan

    public void act() {
        handleInput(); // Memproses masukan pengguna
        applyGravity(); // Menerapkan gaya gravitasi
        updatePosition(); // Memperbarui posisi burung
    }

    private void handleInput() {
        if (Greenfoot.isKeyDown("space") && jumpsRemaining > 0) {
            // Tombol spasi ditekan dan masih ada lompatan yang tersisa
            jump();
        }
    }

    private void jump() {
        verticalSpeed = -15; // Atur kecepatan vertikal negatif untuk melompat
        jumpsRemaining--; // Kurangi sisa lompatan yang tersisa
    }

    private void applyGravity() {
        verticalSpeed += GRAVITY;
    }

    private void updatePosition() {
        setLocation(getX(), getY() + verticalSpeed);
        // Jika burung berada di tanah, reset sisa lompatan
        if (onGround()) {
            jumpsRemaining = 10;
        }
    }

    private boolean onGround() {
        int groundLevel = getWorld().getHeight() - getImage().getHeight() / 2;
        return getY() >= groundLevel;
    }
}
