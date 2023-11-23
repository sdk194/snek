import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
  public boolean up, down, left, right;
  
  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    
    switch(code) {
      case KeyEvent.VK_UP:
        up = true;
        down = false;
        left = false;
        right = false;
        break;

      case KeyEvent.VK_DOWN:
        down = true;
        up = false;
        left = false;
        right = false;
        break;

      case KeyEvent.VK_LEFT:
        left = true;
        up = false;
        right = false;
        down = false;
        break;

      case KeyEvent.VK_RIGHT:
        right = true;
        left = false;
        up = false;
        down = false;
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    /*
    int code = e.getKeyCode();

    switch(code) {
      case KeyEvent.VK_UP:
        up = false;
        break;

      case KeyEvent.VK_DOWN:
        down = false;
        break;

      case KeyEvent.VK_LEFT:
        left = false;
        break;

      case KeyEvent.VK_RIGHT:
        right = false;
        break;
    }
    */
  }
}
