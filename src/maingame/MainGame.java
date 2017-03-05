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
        HauptSpiel maingame;
        public int activescreen = 0;


        public static void main(String[] args) {
        new MainGame().start();

    }

    void start() {
        frame = new JFrame("Schere-Stein-Papier-Echse-Brunnen-Stock-Spock");
        frame1 = new MainFrame(this);
        info1 = new Info();
        frame.add(frame1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.start();

    }

    //starten eines Info-Objekts
    public void startInfo(){
        activescreen = 1;
        info1 = new Info(); //zum zurücksetzen, beugt Fehlern vor
        info1.renderInfo((Graphics2D)frame1.getGraphics());
    }

    //schließen eines Info-Objekts
    public void closeInfo(){
        activescreen = 0;
        frame.repaint();
    }

    //starten des HauptSpiels
    public void startHauptSpiel(){
        activescreen = 2;
        maingame = new HauptSpiel(this);
        maingame.renderHauptSpiel((Graphics2D) frame1.getGraphics());

    }

    //schließen des HauptSpiels
    public void closeHauptSpiel(){
        activescreen = 0;
        frame.repaint();

    }



}









//"Main Menu", "Herzlich Willkommen im Main Menu, bitte wähle eine Option.", Color.WHITE, Color.BLACK , 16