import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
    private int x, y;
    private final int WIDTH = 100, HEIGHT = 10;
    private final int SPEED = 5;

    public Paddle(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public void moveLeft() {
        x -= SPEED;
    }

    public void moveRight() {
        x += SPEED;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
    }

    public void keyReleased(KeyEvent e) {
        
    }
}
