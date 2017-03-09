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
            schere = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Schere.png"));
            stein = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Stein.png"));
            papier = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Papier.png"));
            echse = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Echse.png"));
            stock = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Stock.png"));
            spock = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Spock.png"));
            brunnen = ImageIO.read(new File("C:\\Users\\Daniel\\IdeaProjects\\SchereSteinPapierEchseBrunnenStockSpock\\out\\production\\SchereSteinPapierEchseBrunnenStockSpock\\maingame\\Brunnen.png"));
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
                                //Das möchte ich machen
                                //schere.zurMitteBewegen();
                            }
                            else if (steinbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                            }
                            else if (papierbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                            }
                            else if (echsebutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                            }
                            else if (stockbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                            }
                            else if (spockbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                            }
                            else if (brunnenbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
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

    int koordinatex;
    int koordinatey;
    boolean erreicht = true;

    public boolean zurMitteBewegen(Graphics2D g, int xpicture, int ypicture, BufferedImage image)
            //TODO kann nicht auf bilder angewandt werden
    {
        while(erreicht) {
            if (koordinatex != 500) {
                if(koordinatex < 500)
                {
                    koordinatex++;
                }
                else if(koordinatex > 500)
                {
                    koordinatex--;
                }
            }
            else if (koordinatey != 500) {
                if(koordinatey < 500)
                {
                    koordinatey++;
                }
                if(koordinatey > 500)
                {
                    koordinatey--;
                }
            }
            if(koordinatex == 500 && koordinatey == 500)
            {
                erreicht = false;
            }
            g.drawImage(image, xpicture, ypicture, null);
        }

        erreicht = true;
        return erreicht;

    }


}