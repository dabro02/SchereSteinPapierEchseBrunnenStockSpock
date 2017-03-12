package maingame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Daniel on 05.03.2017.
 */
public class HauptSpiel {
    MainGame game;
    int skip = 0;
    int card = 0;
    BufferedImage actualImage;
    BufferedImage computerImage;
    BufferedImage gewonnen;
    BufferedImage gewonnentüte;
    BufferedImage gewonnenglocke;
    BufferedImage verloren;
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
            gewonnen = ImageIO.read(MainGame.class.getResource("Pictures\\Gewonnen.jpeg"));
            gewonnentüte = ImageIO.read(MainGame.class.getResource("Pictures\\Gewonnentüte.jpeg"));
            gewonnenglocke = ImageIO.read(MainGame.class.getResource("Pictures\\Gewonnenglocke.jpeg"));
            verloren = ImageIO.read(MainGame.class.getResource("Pictures\\Verloren.jpeg"));
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
                                card = 7;
                            }
                            else if (steinbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                card = 1;
                            }
                            else if (papierbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                card = 2;
                            }
                            else if (echsebutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                card = 3;
                            }
                            else if (stockbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                card = 4;
                            }
                            else if (spockbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                card = 5;
                            }
                            else if (brunnenbutton.buttonPointedpicture(e.getX(), e.getY())) {
                                skip = 2;
                                card = 6;
                            }
                        }
                        else if (skip == 6) {
                            skip = 7;
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
        else if (skip == 1) {
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
        else if(skip == 3)
        {
            g.drawImage(actualImage, 600, 400, null);
            skip = 4;
        }
        else if (skip == 5)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            skip = 6;
        }
        else if (skip == 6)
        {
            g.drawImage(actualImage, 600, 400, null);
            g.drawImage(computerImage, 1200, 400, null);
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.drawString("Klicken um das Ergebnis einzusehen.",785,200);
        }
        else if (skip == 8)
       {
            g.drawImage(actualImage, 600, 400, null);
            g.drawImage(computerImage, 1200, 400, null);
            g.setFont(new Font("Arial",Font.BOLD,25));
            if(winOrLose() == 1)
            {
                g.drawString("Yeah! Du hast gewonnen." , 810, 200);
                g.drawImage(gewonnen, 500,200,null);
                g.drawImage(gewonnen, 1100,200,null);
                g.drawImage(gewonnentüte , 400,700,null);
                g.drawImage(gewonnentüte, 1000,600,null);
                g.drawImage(gewonnentüte, 200,300,null);
                g.drawImage(gewonnenglocke, 1700,350,null);
                g.drawImage(gewonnenglocke, 1600,800,null);
            }
            else if(winOrLose() == 0)
            {
                g.drawString("Schade! Du hast verloren." , 830, 200);
                g.drawImage(verloren, 500,200,null);
                g.drawImage(verloren, 1200,200,null);
            }
            else if(winOrLose() == 2)
            {
                g.drawString("Unentschieden! Versuche es nocheinmal." , 785, 200);
            }
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
                brunnenbutton.buttonPointedpicture(x,y);}
                else if (skip == 2) {
                    if (card == 7) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 300, 200, schere);

                    } else if (card == 1) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 450, 500, stein);

                    } else if (card == 2) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 650, 750, papier);

                    } else if (card == 3) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 1000, 750, echse);

                    } else if (card == 4) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 1350, 200, stock);

                    } else if (card == 5) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 850, 150, spock);

                    } else if (card == 6) {
                        zurMitteBewegen((Graphics2D) game.frame1.getGraphics(), 1200, 500, brunnen);

                    }
                }
                else if (skip == 4)
                    {
                        computerSelect();
                        skip = 5;
                    }
                else if(skip == 7)
                    {
                        if(winOrLose() <=2 && winOrLose() >= 0) {
                            skip = 8;
                        }
                    }

        } catch (Exception e) {
     }
    }





    public void zurMitteBewegen(Graphics2D g, int xPicture, int yPicture, BufferedImage image)
    {
        double start = System.nanoTime();
        double prozentsatz = 0;
        g.clearRect(0,0,1920,1080);
        double koordinateX;
        double koordinateY;
        koordinateX = xPicture;
        koordinateY = yPicture;
        while(prozentsatz<=1) {
            prozentsatz = (System.nanoTime()-start)/(1*1000*1000000);
            //System.out.println(prozentsatz);
            koordinateX = (600-xPicture)*prozentsatz+xPicture;

            koordinateY = (400-yPicture)*prozentsatz+yPicture;

            g.drawImage(image, (int) koordinateX, (int) koordinateY, null);
        }
        skip = 3;
        actualImage = image;
    }

    public void computerSelect()
    {
        Random random = new Random();


        switch (random.nextInt(7))
        {
            case 0:
                computerImage = schere;
                break;
            case 1:
                computerImage = stein;
                break;
            case 2:
                computerImage = papier;
                break;
            case 3:
                computerImage = echse;
                break;
            case 4:
                computerImage = brunnen;
                break;
            case 5:
                computerImage = stock;
                break;
            case 6:
                computerImage = spock;
                break;
            default:
                break;
        }
    }

    public int winOrLose()
    {
        if(computerImage==schere)
        {
            if(actualImage == schere)
            {
                return 2;
            }
            else if (actualImage == stein)
            {
                return 0;
            }
            else if (actualImage == papier)
            {
                return 1;
            }
            else if (actualImage == echse)
            {
                return 1;
            }
            else if (actualImage == brunnen)
            {
                return 0;
            }
            else if (actualImage == stock)
            {
                return 1;
            }
            else if (actualImage == spock)
            {
                return 0;
            }
        }
        else if(computerImage==stein)
        {
            if(actualImage == schere)
            {
                return 1;
            }
            else if (actualImage == stein)
            {
                return 2;
            }
            else if (actualImage == papier)
            {
                return 0;
            }
            else if (actualImage == echse)
            {
                return 1;
            }
            else if (actualImage == brunnen)
            {
                return 0;
            }
            else if (actualImage == stock)
            {
                return 1;
            }
            else if (actualImage == spock)
            {
                return 0;
            }
        }
        else if(computerImage==papier)
        {
            if(actualImage == schere)
            {
                return 0;
            }
            else if (actualImage == stein)
            {
                return 1;
            }
            else if (actualImage == papier)
            {
                return 2;
            }
            else if (actualImage == echse)
            {
                return 0;
            }
            else if (actualImage == brunnen)
            {
                return 1;
            }
            else if (actualImage == stock)
            {
                return 0;
            }
            else if (actualImage == spock)
            {
                return 1;
            }
        }
        else if(computerImage==echse)
        {
            if(actualImage == schere)
            {
                return 0;
            }
            else if (actualImage == stein)
            {
                return 0;
            }
            else if (actualImage == papier)
            {
                return 1;
            }
            else if (actualImage == echse)
            {
                return 2;
            }
            else if (actualImage == brunnen)
            {
                return 1;
            }
            else if (actualImage == stock)
            {
                return 0;
            }
            else if (actualImage == spock)
            {
                return 1;
            }
        }
        else if(computerImage==brunnen)
        {
            if(actualImage == schere)
            {
                return 1;
            }
            else if (actualImage == stein)
            {
                return 1;
            }
            else if (actualImage == papier)
            {
                return 0;
            }
            else if (actualImage == echse)
            {
                return 0;
            }
            else if (actualImage == brunnen)
            {
                return 2;
            }
            else if (actualImage == stock)
            {
                return 0;
            }
            else if (actualImage == spock)
            {
                return 1;
            }
        }
        else if(computerImage==stock)
        {
            if(actualImage == schere)
            {
                return 0;
            }
            else if (actualImage == stein)
            {
                return 0;
            }
            else if (actualImage == papier)
            {
                return 1;
            }
            else if (actualImage == echse)
            {
                return 1;
            }
            else if (actualImage == brunnen)
            {
                return 1;
            }
            else if (actualImage == stock)
            {
                return 2;
            }
            else if (actualImage == spock)
            {
                return 0;
            }
        }
        else if(computerImage==spock)
        {
            if(actualImage == schere)
            {
                return 1;
            }
            else if (actualImage == stein)
            {
                return 1;
            }
            else if (actualImage == papier)
            {
                return 0;
            }
            else if (actualImage == echse)
            {
                return 0;
            }
            else if (actualImage == brunnen)
            {
                return 0;
            }
            else if (actualImage == stock)
            {
                return 1;
            }
            else if (actualImage == spock)
            {
                return 2;
            }
        }
        return 4;

    }
}