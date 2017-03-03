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
        frame.add(info1);
        frame.add(frame1);
        info1.setVisible(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.start();

    }

    public void startInfo(){
        info1.renderInfo((Graphics2D)frame1.getGraphics());
        activescreen = 1;
        frame1.setVisible(false);
        info1.setVisible(true);
        info1.repaint();
        frame.remove(0);
    }

    public void closeInfo(){
        activescreen = 0;
        info1.setVisible(false);
        frame.add(frame1);
        frame1.setVisible(true);


    }

    public Info getInfo(){
        return this.info1;
    }
    public void setInfo(Info info){
        this.info1 = info;
    }


}









//"Main Menu", "Herzlich Willkommen im Main Menu, bitte wähle eine Option.", Color.WHITE, Color.BLACK , 16