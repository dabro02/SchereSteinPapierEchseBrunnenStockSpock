package maingame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Daniel on 05.03.2017.
 */
public class HauptSpiel {
    MainGame game;
    int skip = 0;
    PictureButtons scherebutton;
    BufferedImage schere;
    PictureButtons steinbutton;
    BufferedImage stein;
    PictureButtons papierbutton;
    BufferedImage papier;
    PictureButtons echsebutton;
    BufferedImage echse;
    PictureButtons stockbutton;
    BufferedImage stock;
    PictureButtons spockbutton;
    BufferedImage spock;
    PictureButtons brunnenbutton;
    BufferedImage brunnen;




    //Konstruktor
    HauptSpiel(MainGame game) {
        this.game = game;
        game.frame.setBounds(0, 0, 1920, 1080);
        scherebutton = new PictureButtons(300, 200, 225, 225);
        steinbutton = new PictureButtons( 450,500,225,225);
        papierbutton = new PictureButtons( 650,750,225,225);
        spockbutton = new PictureButtons( 850, 150, 225,225);
        echsebutton = new PictureButtons( 1000, 750, 225,225);
        brunnenbutton = new PictureButtons( 1200, 500,225,225);
        stockbutton = new PictureButtons(1350 ,200,225,225);

        //bilder laden
        try {
            schere = ImageIO.read(MainGame.class.getResource("Pictures\\Schere.png"));
            stein = ImageIO.read(MainGame.class.getResource("Pictures\\Stein.png"));
            papier = ImageIO.read(MainGame.class.getResource("Pictures\\Papier.png"));
            echse = ImageIO.read(MainGame.class.getResource("Pictures\\Echse.png"));
            stock = ImageIO.read(MainGame.class.getResource("Pictures\\Stock.png"));
            spock = ImageIO.read(MainGame.class.getResource("Pictures\\Spock.png"));
            brunnen = ImageIO.read(MainGame.class.getResource("Pictures\\Brunnen.png"));
        } catch (Exception e) {
        }
        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (game.activescreen == 2) {
                    if (true)
                        if (skip == 0) {
                            skip++;
                        } else if (skip == 1) {
                            //clickactions: vielleicht macht man dass sich das ausgewählte Bild in die Mitte verschieben oder auf eine seite.
                            if (scherebutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 300,200, schere);
                            }
                            else if (steinbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 450,500, stein);
                            }
                            else if (papierbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 650,750, papier);
                            }
                            else if (echsebutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 1000,750, echse);
                            }
                            else if (stockbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 1350,200, stock);
                            }
                            else if (spockbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 850,150, spock);
                            }
                            else if (brunnenbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 1200,500, brunnen);
                            }
                        }
                        else if (skip == 2) {

                        }
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
    }


    //rendermethode vom maingame
    public void renderHauptSpiel(Graphics2D g) {
        //Screen 1
        if (skip == 0) {
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("Hallo Benutzer und Herzlich Willkommen zum Schere-Stein-Papier-Echse-Brunnen-Stock-Spock-Spiel.", 390, 100);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Ihnen werden jetzt die Regeln des Spiel erklärt, Klicken sie auf den Bildschirm um weiter zu machen.", 470, 200);
        }
        //Screen 2
        if (skip == 1) {
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Wählen sie einen der Folgenden Begriffe.", 775, 100);
            g.drawImage(schere, 300, 200, null);
            g.drawImage(stein, 450, 500,null);
            g.drawImage(papier, 650,750,null);
            g.drawImage(echse, 1000, 750, null);
            g.drawImage(brunnen, 1200, 500, null);
            g.drawImage(spock, 850, 150, null);
            g.drawImage(stock, 1350, 200, null);
            scherebutton.renderpicturebutton(g);
            steinbutton.renderpicturebutton(g);
            papierbutton.renderpicturebutton(g);
            echsebutton.renderpicturebutton(g);
            stockbutton.renderpicturebutton(g);
            spockbutton.renderpicturebutton(g);
            brunnenbutton.renderpicturebutton(g);
        }
    }

    //updateMethode
    public void updateMethode(int x, int y) {
        try {
            if (skip == 1) {
                scherebutton.buttonPointedpicture( x, y);
                steinbutton.buttonPointedpicture( x, y);
                papierbutton.buttonPointedpicture(x,y );
                echsebutton.buttonPointedpicture(x,y);
                stockbutton.buttonPointedpicture(x,y);
                spockbutton.buttonPointedpicture(x,y);
                brunnenbutton.buttonPointedpicture(x,y);
            }
        } catch (Exception e) {
     }
    }




    public boolean zurMitteBewegen(Graphics2D g, int xpicture, int ypicture, BufferedImage image)
            //TODO was ich noch brauche ist das mit der Delta bewegung (wie wir das mit dem Fenster auch gemacht haben) bitte noch erklären oder einfügen
    {
        g.clearRect(0,0,1920,1080);
        boolean erreicht = true;
        double koordinatex;
        double koordinatey;
        double abstandx;
        double updatedschrittex = 0;
        double abstandy;
        double updatedschrittey = 0;
        koordinatex = xpicture;
        koordinatey = ypicture;
        abstandx = koordinatex - 600;
        abstandy = koordinatey - 400;
        if( abstandx <= abstandy){
            updatedschrittex = 0.5;
            updatedschrittey = (abstandy/abstandx)/2;
            if(updatedschrittey < 0)
            {
                updatedschrittey = updatedschrittey*(-1);
            }
        }
        if( abstandx >= abstandy){
            updatedschrittey = 0.5;
            updatedschrittex = (abstandx/abstandy)/2;
            if(updatedschrittex < 0)
            {
                updatedschrittex = updatedschrittex*(-1);
            }
        }

        System.out.println(updatedschrittex+"   "+updatedschrittey);
        while(erreicht) {

            if (koordinatex != 600) {
                if(koordinatex < 600)
                {
                    koordinatex = koordinatex + updatedschrittex;
                }
                else if(koordinatex > 600)
                {
                    koordinatex = koordinatex - updatedschrittex;
                }
            }
            if (koordinatey != 400) {
                if(koordinatey < 400)
                {
                    koordinatey = koordinatey + updatedschrittey;
                }
                if(koordinatey > 400)
                {
                    koordinatey = koordinatey - updatedschrittey;
                }
            }

            if((int) koordinatex == 600 && (int) koordinatey == 400)
            {
                erreicht = false;

            }

            try {
                Thread.sleep(0,750000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.drawImage(image, (int) koordinatex, (int) koordinatey, null);
        }

        erreicht = true;
        return erreicht;

    }


}