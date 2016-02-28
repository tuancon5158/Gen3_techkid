/**
 * Created by ASUS on 2/27/2016.
 */
/**

 */
public class Program {
    public static void main(String[] args) {


        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();

    }
}

