/**
 * Created by ASUS on 2/27/2016.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Frame implements Runnable,MouseListener,MouseMotionListener {
    //xoa bo dem
    Graphics seconds;
    Image image;

    BufferedImage background;
    BufferedImage bullet;
    Plane plane;// khai bao tham chieu. chua co doi tuong.
    Plane plane1;

    public GameWindow() {
        //an con tro chuot
        this.hiddenmouse();
        plane= new Plane();
        plane1=new Plane();
        plane.positionX=150;
        plane.positionY=300;
        plane1.positionX=100;
        plane1.positionY=200;
        plane.speed=3;
        //Plane plane1=plane;// 1nguoi co 2 ten,
        //thiet lap tieu de cho cua so
        this.setTitle("TechKids - code the change");
        //thiet lap kich thuoc cho cua so
        this.setSize(400, 640);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //load Image tu thu muc Resource
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            plane.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
            plane1.sprite=ImageIO.read(new File("Resources/PLANE2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        //doan code de bat su kien bam phim
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    plane.direction = 3;
                } else if(e.getKeyCode() == KeyEvent.VK_D) {
                    plane.direction = 4;
                } else if(e.getKeyCode() == KeyEvent.VK_W) {
                    plane.direction = 1;
                } else if(e.getKeyCode() == KeyEvent.VK_S) {
                    plane.direction = 2;
                }
            }
            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                //khi thả phím lên thì để direction = 0 cho nó không bay nữa
                plane.direction = 0;
            }
        });
    }
    //ham ve
    //ve~ moi. thu o day
    public void update(Graphics g){
        if(image==null){
            image= createImage(this.getWidth(),this.getHeight());
             seconds=image.getGraphics();

        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);


    }
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(background,0,0,null);
        plane.draw(g);
        plane1.draw(g);

        //g.drawLine(0,0, 100, 100);
    }
    // phuong thuc an mouse
    private void hiddenmouse() {
        Toolkit g = Toolkit.getDefaultToolkit();
        Point h = new Point(0,0);
        BufferedImage hidden = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = g.createCustomCursor(hidden, h, "InvisibleCursor");
        setCursor(invisibleCursor);
    }
    //Game Loop
    //Vong Lap game
    @Override
    public void run() {
        int count = 0;
        while (true) {
            plane.move();
            repaint();
            System.out.println(count++);

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {



    }


    @Override
    public void mouseMoved(MouseEvent e) {
        plane1.positionX = e.getX();
        plane1.positionY = e.getY();


    }
}
