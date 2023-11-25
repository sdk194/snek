import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.lang.Runnable;


public class GamePanel extends JPanel implements Runnable {
  Thread gameThread;
  KeyHandler keyH = new KeyHandler();
  int FPS = 60;
  Snake player = new Snake(Color.BLUE, this, keyH);
  Body bod = new Body(Color.BLUE, this);

  GamePanel() {
    this.setPreferredSize(new Dimension(500, 500));
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    double drawInterval = 1000000000 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    int drawCount = 0;
    long timer = 0;
    
    while (gameThread != null) {
      //System.out.println("running");
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;

      if (delta > 0) {
        update();
        repaint();
        delta--;
        drawCount++;
      }

      if (timer >= 1000000000) {
        System.out.println("FPS: " + drawCount);
        drawCount = 0;
        timer = 0;
      }
    }
  }

  public void update() {
    //bod.update(player.getX(), player.getY());
    player.update();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g;
    player.draw(g2D);
    //bod.draw(g2D);
  }
}
