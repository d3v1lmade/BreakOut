import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, diameter = 15;
    private int xVelocity = 1, yVelocity = -1;
    private final int maxVelocity = 5;

    public Ball(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public void setXVelocity(int newVelocity) {
        xVelocity = newVelocity;
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public void setYVelocity(int newVelocity) {
        yVelocity = newVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }



    public int getY() {
        return y;
    }

    public void update() {
        x += xVelocity;
        y += yVelocity;

        // Bounce off walls
        if (x < 0 || x > 800 - diameter) {
            xVelocity = -xVelocity;
        }
        if (y < 0) {
            yVelocity = -yVelocity;
        }
    }

    public void draw(Graphics g) {
        g.fillOval(x, y, diameter, diameter);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void increaseVelocity() {
        if (Math.abs(xVelocity) < maxVelocity && Math.abs(yVelocity) < maxVelocity) {
            xVelocity += (xVelocity > 0) ? 1 : -1; 
            yVelocity += (yVelocity > 0) ? 1 : -1; 
        }
    }
}
