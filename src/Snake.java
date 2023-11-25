import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.lang.Math;

public class Snake extends JComponent {
  Color color;
  int posx = 250;
  int posy = 250;
  int speed = 4;
  GamePanel game;
  KeyHandler keyH;
  Square head;
  Square food;
  ArrayList<Square> body = new ArrayList<Square>();

  Snake(Color color, GamePanel game, KeyHandler keyH) {
    this.color = color;
    head = new Square(this.posx, this.posy);
    food = new Square(this.posx, this.posy, Color.RED);
    this.game = game;
    this.keyH = keyH;
    body.add(new Square(230, 250));
    body.add(new Square(210, 250));
  }

  public void feed() {
    int sumx = head.getPosX() - food.getPosX();
    if (sumx < 0) {
      sumx = sumx * -1;
    }
    int sumy = head.getPosY() - food.getPosY();
    if (sumy < 0) {
      sumy = sumy * -1;
    }
    if (sumx < 20 && sumy < 20) {
      food.color = Color.BLACK;
    }
  }

  public void updateStates() {
    if (food.color == Color.BLACK) {
      food.posx =(int)(Math.random() * 500);
      food.posy = (int)(Math.random() * 500);
      food.color = Color.RED;
      int tailx = body.get(body.size() - 1).getPosX();
      int taily = body.get(body.size() - 1).getPosY();
      body.add(new Square(tailx, taily));
    }
  }

  public void createSnakeBody(Graphics2D g) {
    for(Square i : body) {
      g.fillRect(i.getPosX(), i.getPosY(), 20, 20);
    }
  }

  public void bodyUp() {
    for (int i = body.size() - 1; i > 0; i-=1) {
      int prevX = body.get(i - 1).getPosX();
      int prevY = body.get(i - 1).getPosY();
      body.get(i).followUp(prevX, prevY);
    }
    body.get(0).followUp(head.getPosX(), head.getPosY());
  }

    public void bodyDown() {
    for (int i = body.size() - 1; i > 0; i-=1) {
      int prevX = body.get(i - 1).getPosX();
      int prevY = body.get(i - 1).getPosY();
      body.get(i).followDown(prevX, prevY);
    }
    body.get(0).followDown(head.getPosX(), head.getPosY());
  }

  public void bodyLeft() {
    for (int i = body.size() - 1; i > 0; i-=1) {
      int prevX = body.get(i - 1).getPosX();
      int prevY = body.get(i - 1).getPosY();
      body.get(i).followLeft(prevX, prevY);
    }
    body.get(0).followLeft(head.getPosX(), head.getPosY());
  }

    public void bodyRight() {
    for (int i = body.size() - 1; i > 0; i-=1) {
      int prevX = body.get(i - 1).getPosX();
      int prevY = body.get(i - 1).getPosY();
      body.get(i).followRight(prevX, prevY);
    }
    body.get(0).followRight(head.getPosX(), head.getPosY());
  }

  public void update() {
    feed();

    if (keyH.up == true) {
      bodyUp();
      head.moveUp();

    }
    else if (keyH.down == true) {
      bodyDown();
      head.moveDown();
    }
    else if (keyH.left == true) {
      bodyLeft();
      head.moveLeft();
    }
    else if (keyH.right == true) {
      bodyRight();
      head.moveRight();
    }

    updateStates();
  }

  public void draw(Graphics2D g2D) {
    g2D.setColor(food.color);
    g2D.fillRect(food.getPosX(), food.getPosY(), 10, 10);

    g2D.setColor(this.color);
    g2D.fillRect(head.getPosX(), head.getPosY(), 20, 20);
    createSnakeBody(g2D);
    //g2D.fillRect(body.get(0).getPosX(), body.get(0).getPosY(), 20, 20);
    //g2D.fillRect(body.get(1).getPosX(), body.get(1).getPosY(), 20, 20);
    //g2D.fillRect(230, 230, 20, 20);
  }
}
