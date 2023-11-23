import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.util.ArrayList;

public class Body extends JComponent {
  Color color;
  int posx = 230;
  int posy = 230;
  GamePanel game;

  Body(Color color, GamePanel game) {
    this.color = color;
    this.game = game;
  }

  public void update(int x, int y) {
    posx = x;
    posy = y;
  }

  public void draw(Graphics2D g2D) {
    g2D.setColor(this.color);
    g2D.fillRect(posx, posy, 20, 20);
    g2D.dispose();
  }
}
