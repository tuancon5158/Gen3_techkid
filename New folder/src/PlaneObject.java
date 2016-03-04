/**
 * Created by ASUS on 3/4/2016.
 */
import java.awt.image.BufferedImage;

/**
 * Created by TrungNT on 3/2/2016.
 */
public abstract class PlaneObject extends GameObject {
    //ke thua GameObject de dung thuoc tinh toa do va Anh nen
    protected int speed;
    protected int heath;
    protected int damage; //do sat thuong
    protected int planeType;

    //toa do x
    public void setPostionX(int x)
    {
        this.positionX = x;
    }

    public int getPostionX()
    {
        return positionX;
    }

    //toa do y
    public void setPostionY(int y)
    {
        this.positionY = y;
    }

    public int getPostionY()
    {
        return positionY;
    }

    //toc do speed
    public void setSpeed(int td)
    {
        this.speed = td;
    }

    public int getSpeed()
    {
        return speed;
    }

    //suc manh
    public void setHeath(int healthy)
    {
        this.heath = healthy;
    }

    public int getHeath()
    {
        return heath;
    }

    //do sat thuong
    public void setDamage(int st)
    {
        this.damage = st;
    }

    public int getDamage()
    {
        return damage;
    }
}
