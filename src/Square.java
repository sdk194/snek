import java.awt.Color;
import java.awt.Graphics2D;

public class Square {
    int posx;
    int posy;
    int speed = 4;
    Color color;

    Square(int x, int y) {
        this.posx = x;
        this.posy = y;
    }

    Square(int x, int y, Color color) {
        this.posx = x;
        this.posy = y;
        this.color = color;
    }

    public void moveUp() {
        posy -= speed;
    }

    public void moveDown() {
        posy += speed;
    }

    public void moveLeft() {
        posx -= speed;
    }

    public void moveRight() {
        posx += speed;
    }

    public void followUp(int x, int y) {
        while (this.posx != x) {
            if (this.posx < x) {
                this.posx += this.speed;
            }
            else {
                this.posx -= this.speed;
            }
        }
        this.posy = y + 20;
    }

    public void followDown(int x, int y) {
        while (this.posx != x) {
            if (this.posx < x) {
                this.posx += this.speed;
            }
            else {
                this.posx -= this.speed;
            }
        }
        this.posy = y - 20;
    }

    public void followLeft(int x, int y) {
        this.posx = x + 20;
        while (this.posy != y) {
            if (this.posy < y) {
                this.posy += this.speed;
            }
            else {
                this.posy -= this.speed;
            }
        }
    }

    public void followRight(int x, int y) {
        this.posx = x - 20;
        while (this.posy != y) {
            if (this.posy < y) {
                this.posy += this.speed;
            }
            else {
                this.posy -= this.speed;
            }
        }
    }

    public int getPosX() {
        return this.posx;
    }

    public int getPosY() {
        return this.posy;
    }
}
