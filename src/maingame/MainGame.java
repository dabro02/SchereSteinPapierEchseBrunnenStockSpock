package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainGame {
        MainFrame frame1;
        Info info1;
        JFrame frame;
        int activescreen = 0;

        public static void main(String[] args) {
        new MainGame().start();

    }

    void start() {
        frame = new JFrame("Main Menu - Schere-Stein-Papier-Echse-Brunnen-Stock-Spock");
        frame1 = new MainFrame(this);
        info1 = new Info();

        frame.add(frame1);
        info1.setVisible(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.start();

    }
    /*
    Richtig hässlich und unsauber alles, aber noch verkraftbar und es läuft ;)
     */

    public void startInfo(){ //cleaner opening
        info1 = new Info(); //zum zurücksetzen, beugt Fehlern vor
        info1.renderInfo((Graphics2D)frame1.getGraphics()); //wieso nur einmal?
        activescreen = 1;
        info1.repaint();
        frame.remove(frame1);
        frame.add(info1);
    }

    public void closeInfo(){ //cleaner closing
        activescreen = 0;
        frame.add(frame1);
        frame.remove(info1);

    }


}









//"Main Menu", "Herzlich Willkommen im Main Menu, bitte wähle eine Option.", Color.WHITE, Color.BLACK , 16