import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Tuan on 2/26/16.
 */
public class Plane extends  PlaneObject{

    public Plane(){
        //khong co kieu tra ve
        //ten ham giong het ten Class
        this.positionX = 300;
        this.positionY = 300;
        this.speed = 4;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //new Plane(1,1,1,ImageIO.read(new FIle(adasdsa)))
    public Plane(int positionX, int positionY, int speed, int planeType){
        //co the co nhieu ham khoi tao co tham so
        //chi can khac nhau cac tham so truyen vao
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        switch (planeType){
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void shot(){
        Bullet bul = new Bullet(this.positionX + 30, this.positionY, 10);
        vecBul.add(bul);
    }
    private Vector<Bullet> vecBul = new Vector<Bullet>();


    private int hp;
    private int planeType;
    private int dam;
    private int speed;

    private int direction;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPlaneType() {
        return planeType;
    }

    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }

    public int getDam() {
        return dam;
    }

    public void setDam(int dam) {
        this.dam = dam;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;

    }
    public void  move(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }
    private void move(){
        switch (direction){
            case 0:
                //dung im
                break;
            case 1:
                this.positionY -= this.speed;
                break;
            case 2:
                this.positionY += this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }
    }
    public void update(){
        this.move();
        for (Bullet bul : vecBul){
            bul.update(0);
        }
    }
    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
        for (Bullet bul : vecBul){
            bul.draw(g);
        }
    }

}
