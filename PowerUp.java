import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class PowerUp {
    private int x, y;
    private final int WIDTH = 20, HEIGHT = 20;
    private boolean isActive;

    public PowerUp(int startX, int startY) {
        x = startX;
        y = startY;
        isActive = true;
    }

    public void update() {
        y += 1; // 
    }

    public void draw(Graphics g) {
        if (isActive) {
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, WIDTH, HEIGHT);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        isActive = false;
    }
}
