import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tuan on 2/26/16.
 */
public class Bullet extends GameObject{

    public int speed;




    public Bullet(int positionX, int positionY, int speed) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move()
        {
            //di chuyen thang
            this.positionY -= this.speed;
        }

        //phuong thuc di chuyen cua dan Bullet: di chuyen cheo sang trai

    private void moveCheoTrai() {
        this.positionY -= this.speed;
        this.positionX -= 4;
    }

    //phuong thuc di chuyen cua dan Bullet: di chuyen cheo sang phai
    private void moveCheoPhai() {
        this.positionY -= this.speed;
        this.positionX += 4;
    }



    public void update(int status){

        switch (status)
        {
            case 0:
                this.move();
                break;
            case 1:
                this.moveCheoTrai();
                break;
            case 2:
                this.moveCheoPhai();
                break;
        }
        this.move();
    }

    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
