package maingame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainFrame extends JPanel {
    MainGame game;
    Button start;
    Button einstellungen;
    Button info;
    Info info1;
    Button beenden;
    boolean running;

    MainFrame(MainGame game){
        this.game = game;
        game.frame.setBounds(500, 200, 600, 600);
        game.frame.setResizable(false);
        getGraphics();
        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(game.activescreen == 0){
                if(start.buttonPointed(e.getX(), e.getY()))
                 {
                     System.out.println("hi start");

                 }
                if(einstellungen.buttonPointed(e.getX(), e.getY()))
                 {
                     System.out.println("hi einstellungen");
                 }
                if(info.buttonPointed(e.getX(), e.getY()))
                 {
                     game.startInfo();

                 }
                if(beenden.buttonPointed(e.getX(), e.getY()))
                 {

                     System.exit(0);
                 }}

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
        });
        this.start =            new Button( 225, 100, 150, 50, Color.BLUE, Color.CYAN, "              Start");
        this.einstellungen =    new Button( 225, 185, 150, 50, Color.BLUE, Color.CYAN, "         Einstellung");
        this.info =             new Button( 225, 270, 150, 50, Color.BLUE, Color.CYAN, "      Informationen");
        this.beenden =          new Button( 225, 355, 150, 50, Color.BLUE, Color.CYAN, "          Beenden");
    }

    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        if(game.activescreen == 0) {
            start.render(g);
            einstellungen.render(g);
            info.render(g);
            beenden.render(g);
        }
        if(game.activescreen == 1)
            game.info.backToMainMenu.render(g);




    }


    public void start() {
        running  = true;

        while(running) {
            int y = 0;
            int x = 0;
            try {
                y = game.frame.getMousePosition().y;
                x = game.frame.getMousePosition().x;
            }
            catch(Exception e){
            }
            if(game.activescreen == 0) {
                start.buttonPointed(x, y);
                einstellungen.buttonPointed(x, y);
                info.buttonPointed(x, y);
                beenden.buttonPointed(x, y);
            }
            if(game.activescreen == 1)
                game.info.backToMainMenu.buttonPointed(x,y);
            try{

            }
            catch(Exception e){}
            if(game.activescreen == 0)
                 repaint();
            if(game.activescreen == 1)
                game.info.repaint();

        }
    }






}




