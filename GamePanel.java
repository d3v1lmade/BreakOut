import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private final int WIDTH = 800, HEIGHT = 600;
    private Timer timer;
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Block> blocks;
    private ArrayList<PowerUp> powerUps;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        paddle = new Paddle(350, 550);
        ball = new Ball(400, 300);
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();

        // Populate the blocks
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                blocks.add(new Block(i * 70 + 50, j * 30 + 50));
            }
        }

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });

        timer = new Timer(1000 / 60, this);  // Updates at about 60 FPS
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.update();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.setYVelocity(-ball.getYVelocity()); 
            ball.increaseVelocity();
        }

        // Block collisions
        ArrayList<Block> blocksToRemove = new ArrayList<>();
    for (Block block : blocks) {
        if (ball.getBounds().intersects(block.getBounds())) {
            ball.setYVelocity(-ball.getYVelocity()); 
            blocksToRemove.add(block);
            ball.increaseVelocity(); 
            if (Math.random() < 0.3) {  
                powerUps.add(new PowerUp(block.getX(), block.getY()));
            }
        }
    }
    blocks.removeAll(blocksToRemove);

        
        ArrayList<PowerUp> powerUpsToRemove = new ArrayList<>();
        for (PowerUp powerUp : powerUps) {
            powerUp.update();
            if (powerUp.getBounds().intersects(paddle.getBounds())) {
                applyPowerUp(powerUp);
                powerUpsToRemove.add(powerUp);
            }
        }
        powerUps.removeAll(powerUpsToRemove);
    }

    private void applyPowerUp(PowerUp powerUp) {
        // Example: Increase ball speed
        ball.setXVelocity(ball.getXVelocity() + 1);
        ball.setYVelocity(ball.getYVelocity() - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        for (Block block : blocks) {
            block.draw(g);
        }
        for (PowerUp powerUp : powerUps) {
            if (powerUp.isActive()) {
                powerUp.draw(g);
            }
        }

        if (blocks.isEmpty()) {
            drawGameOver(g, "You Win!");
        }

        // Check for game over condition if the ball hits the bottom of the screen
        if (ball.getY() > HEIGHT) {
            drawGameOver(g, "Game Over!");
        }
    }

    private void drawGameOver(Graphics g, String message) {
        g.setColor(Color.RED);
        g.drawString(message, WIDTH / 2 - 50, HEIGHT / 2);
        timer.stop();
    }
}
