package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainGame {
        MainFrame frame1;
        Info info;
        JFrame frame;

        public static void main(String[] args) {
        new MainGame().start();

    }

    void start() {
        frame = new JFrame("Main Menu - Schere-Stein-Papier-Echse-Brunnen-Stock-Spock");
        frame1 = new MainFrame(this);
        info = new Info();
        frame.add(info);
        frame.add(frame1);
        info.setVisible(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.start();

    }

    public void startInfo(){
        info.renderInfo((Graphics2D)frame1.getGraphics());
        frame1.setVisible(false);
        info.setVisible(true);
        info.repaint();
        frame.remove(0);
    }

    public void closeInfo(){
        info.setVisible(false);
        frame1.setVisible(true);

    }

    public Info getInfo(){
        return this.info;
    }
    public void setInfo(Info info){
        this.info = info;
    }


}









//"Main Menu", "Herzlich Willkommen im Main Menu, bitte wähle eine Option.", Color.WHITE, Color.BLACK , 16