package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainGame {
    JFrame frame;
    MainFrame mainframe;


    public static void main(String[] args) {
        new MainGame().start();


    }

    void start() {
        frame = new JFrame();
        mainframe = new MainFrame("start","Herzlich Willkommen im Main Menu, bitte wähle eine Option.", 500, 200, 600, 600, Color.WHITE , Color.BLACK, 16, this);
        frame.add(mainframe);
        frame.setVisible(true);

    }
}








//"Main Menu", "Herzlich Willkommen im Main Menu, bitte wähle eine Option.", Color.WHITE, Color.BLACK , 16