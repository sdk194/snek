import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.util.ArrayList;

public class Snake extends JComponent {
  Color color;
  int posx = 250;
  int posy = 250;
  int speed = 4;
  GamePanel game;
  KeyHandler keyH;

  Snake(Color color, GamePanel game, KeyHandler keyH) {
    this.color = color;
    this.game = game;
    this.keyH = keyH;
  }

  public void update() {
    if (keyH.up == true) {
      posy -= speed;
    }
    else if (keyH.down == true) {
      posy += speed;
    }
    else if (keyH.left == true) {
      posx -= speed;
    }
    else if (keyH.right == true) {
      posx += speed;
    }
  }

  public void draw(Graphics2D g2D) {
    g2D.setColor(this.color);
    g2D.fillRect(posx, posy, 20, 20);
    g2D.dispose();
  }

  public int getX() {
    return this.posx;
  }

  public int getY() {
    return this.posy;
  }
}
