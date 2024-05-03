import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Block {
    private int x, y;
    private final int WIDTH = 60, HEIGHT = 20;

    public Block(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getX() {
        return x;
    }   

    public int getY() {
        return y;
    }
}