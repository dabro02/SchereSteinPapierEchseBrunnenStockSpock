package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainGame {
        MainFrame frame1;
        JFrame frame;

        public static void main(String[] args) {
        new MainGame().start();

    }

    void start() {
        frame = new JFrame("Main Menu - Schere-Stein-Papier-Echse-Brunnen-Stock-Spock");
        frame1 = new MainFrame(this);
        frame.add(frame1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.start();

    }


}









//"Main Menu", "Herzlich Willkommen im Main Menu, bitte wähle eine Option.", Color.WHITE, Color.BLACK , 16