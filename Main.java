import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Game");
        GamePanel panel = new GamePanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();  
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  
    }
}
