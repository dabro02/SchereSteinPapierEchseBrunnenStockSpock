package maingame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainFrame extends JPanel {
    MainGame game;
    Button start;
    Button info;
    Button beenden;
    BufferedImage schereklein,papierklein,spockklein,steinklein,echseklein,brunnenklein, stockklein;

    MainFrame(MainGame game){
        this.game = game;
        game.frame.setBounds(700, 200, 600, 600);
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
                    //
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
        //importieren der kleinen Bilder
        try{
        schereklein = ImageIO.read(this.getClass().getResource("Pictures/Schereklein.png"));
        steinklein = ImageIO.read(this.getClass().getResource("Pictures/Steinklein.png"));
        papierklein = ImageIO.read(this.getClass().getResource("Pictures/Papierklein.png"));
        echseklein = ImageIO.read(this.getClass().getResource("Pictures/Echseklein.png"));
        stockklein = ImageIO.read(this.getClass().getResource("Pictures/Stockklein.png"));
        spockklein = ImageIO.read(this.getClass().getResource("Pictures/Spockklein.png"));
        brunnenklein = ImageIO.read(this.getClass().getResource("Pictures/Brunnenklein.png"));}
        catch(Exception e) {}
        //erstellung der Menu-Buttons
        this.start =            new Button( 225, 100, 150, 50, Color.BLUE, Color.CYAN, "              Start");
        this.info =             new Button( 225, 185, 150, 50, Color.BLUE, Color.CYAN, "      Informationen");
        this.beenden =          new Button( 225, 270, 150, 50, Color.BLUE, Color.CYAN, "          Beenden");
    }

    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        if(game.activescreen == 0) {
            g.drawImage(schereklein,50,50,null);
            g.drawImage(steinklein,50,225,null);
            g.drawImage(papierklein,50,400,null);
            g.drawImage(echseklein,375,50,null);
            g.drawImage(brunnenklein,385,225,null);
            g.drawImage(stockklein,375,400,null);
            g.drawImage(spockklein,212,380,null);
            start.render(g);
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
                try {
                    game.maingame.updateMethode(x, y);
                }
                catch(Exception e) {}
                repaint();
            }
            //if Start
            else if(game.activescreen == 3){

                repaint();
            }

        }
    }






}




