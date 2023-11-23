import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    GamePanel game;

    MyFrame() {
        game = new GamePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(game);
        this.pack();
        game.startGameThread();
    }
}
