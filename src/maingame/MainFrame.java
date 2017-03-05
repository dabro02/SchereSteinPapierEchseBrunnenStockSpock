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
    Button beenden;

    MainFrame(MainGame game){
        this.game = game;
        game.frame.setBounds(500, 200, 600, 600);
        game.frame.setResizable(false);
        getGraphics();
        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //funktionen alle MainMenu Buttons
                if(game.activescreen == 0){
                    if(start.buttonPointed(e.getX(), e.getY())) {
                        game.startHauptSpiel();
                    }

                    else if(einstellungen.buttonPointed(e.getX(), e.getY())) {
                        System.out.println("hi einstellungen");
                    }

                    else if(info.buttonPointed(e.getX(), e.getY())) {
                        game.startInfo();

                    }

                    else if(beenden.buttonPointed(e.getX(), e.getY())) {
                        System.exit(0);
                    }

                }
                //funktionen backToMainMenu butten in der Info-class
                else if(game.activescreen == 1){
                    if(game.info1.backToMainMenu.buttonPointed(e.getX(), e.getY())){
                        game.closeInfo();
                    }

                }
                else if(game.activescreen == 2){
                    //continue regeln
                }

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
        //erstellung der Menu-Buttons
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
            g.setFont(new Font("Arial", Font.BOLD , 24));
            g.drawString("Main Menu", 235, 50);
        }
       else if(game.activescreen == 1){
            game.info1.renderInfo(g);
            }
        else if(game.activescreen == 2){
           game.maingame.renderHauptSpiel(g);
        }


    }



    //update-loop
    public void start() {

        while(true) {
            int y = 0;
            int x = 0;
            try {
                y = game.frame.getMousePosition().y;
                x = game.frame.getMousePosition().x;
            }
            catch(Exception e){}
            //if menu
            if(game.activescreen == 0) {
                start.buttonPointed(x, y);
                einstellungen.buttonPointed(x, y);
                info.buttonPointed(x, y);
                beenden.buttonPointed(x, y);
                repaint();
            }
            //if Informationen
            else if(game.activescreen == 1) {
                game.info1.backToMainMenu.buttonPointed(x, y);
                repaint();
            }
            //if Einstellungen
            else if(game.activescreen == 2){

                repaint();
            }
            //if Start
            else if(game.activescreen == 3){

                repaint();
            }

        }
    }






}




