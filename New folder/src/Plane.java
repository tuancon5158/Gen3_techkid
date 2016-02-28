import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ASUS on 2/28/2016.
 */
public class Plane {
    public int positionX;
    public int positionY;
    public int damage;
    public int speed;
    public int planeType;
    public BufferedImage sprite;// goi la hinh anh trong game 2D
    public int direction;
    public void move() {
         {

            if (direction == 1) {
                this.positionY -= this.speed;
            }
            if (direction == 2) {
                this.positionY += this.speed;
            }
            if (direction == 3) {
                this.positionX -= this.speed;
            }
            if (direction == 4) {
                this.positionX += this.speed;
            }


        }


    }
    void update(){
        move();
    }
    void draw(Graphics g){
        g.drawImage(this.sprite,positionX,positionY,null);
    }
    }


