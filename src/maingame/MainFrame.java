package maingame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainFrame extends JPanel {
    MainGame game;
    Button start;
    Button einstellungen;
    Button info;
    Button beenden;

    MainFrame(MainGame game){
        this.game = game;
        game.frame.setBounds(500, 200, 600, 600);
        game.frame.setResizable(false);
        getGraphics();

        //game.frame.
        this.start =            new Button( 225, 100, 150, 50, Color.BLUE, Color.CYAN, "              Start");
        this.einstellungen =    new Button( 225, 185, 150, 50, Color.BLUE, Color.CYAN, "         Einstellung");
        this.info =             new Button( 225, 270, 150, 50, Color.BLUE, Color.CYAN, "      Informationen");
        this.beenden =          new Button( 225, 355, 150, 50, Color.BLUE, Color.CYAN, "          Beenden");
    }

    @Override
    protected void paintComponent(Graphics g){
        start.render((Graphics2D) g);
        einstellungen.render((Graphics2D) g);
        info.render((Graphics2D) g);
        beenden.render((Graphics2D) g);




    }

    boolean j = true;
    boolean k = true;
    boolean l = true;
    boolean ö = true;

    public void start() {

        while(true) {
            Graphics g = getGraphics();
            start.buttonPointed((Graphics2D) g,225,100,150,50);
            einstellungen.buttonPointed((Graphics2D) g, 225,185,150,50);
            info.buttonPointed((Graphics2D) g,225, 185+85 , 150, 50);
            beenden.buttonPointed((Graphics2D) g,225, 185+85+85 , 150, 50);
            repaint();

        }
    }






}




