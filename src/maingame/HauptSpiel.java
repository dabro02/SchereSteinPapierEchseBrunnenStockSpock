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
    Button restart;
    Button end;




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
            schere = ImageIO.read(this.getClass().getResource("Pictures/Schere.png"));
            stein = ImageIO.read(this.getClass().getResource("Pictures/Stein.png"));
            papier = ImageIO.read(this.getClass().getResource("Pictures/Papier.png"));
            echse = ImageIO.read(this.getClass().getResource("Pictures/Echse.png"));
            stock = ImageIO.read(this.getClass().getResource("Pictures/Stock.png"));
            spock = ImageIO.read(this.getClass().getResource("Pictures/Spock.png"));
            brunnen = ImageIO.read(this.getClass().getResource("Pictures/Brunnen.png"));
            gewonnen = ImageIO.read(this.getClass().getResource("Pictures/Gewonnen.jpeg"));
            gewonnentüte = ImageIO.read(this.getClass().getResource("Pictures/Gewonnentüte.jpeg"));
            gewonnenglocke = ImageIO.read(this.getClass().getResource("Pictures/Gewonnenglocke.jpeg"));
            verloren = ImageIO.read(this.getClass().getResource("Pictures/Verloren.jpeg"));
        } catch (Exception e) {
            e.printStackTrace();
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
                        else if (skip == 8){
                            if(restart.buttonPointed(e.getX(),e.getY())){
                                skip =1;

                            }
                            else if(end.buttonPointed(e.getX(),e.getY())){
                                game.closeHauptSpiel();
                            }
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

        restart = new Button(650,700,150,50,Color.BLACK,Color.GREEN, "          Nochmal!");
        end = new Button(1250, 700,150,50,Color.BLACK,Color.GREEN, "         Beenden");
    }

    int test = 4;
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
            restart.render(g);
            end.render(g);
            System.out.println(test);
            if(test == 0)
            {
                g.setFont(new Font("Arial",Font.BOLD,25));
                g.drawString("Yeah! Du hast gewonnen." , 840, 200);
                g.drawImage(gewonnen, 850,300,null);
                g.drawImage(gewonnentüte , 400,700,null);
                g.drawImage(gewonnentüte, 1700,350,null);
                g.drawImage(gewonnentüte, 200,300,null);
                g.drawImage(gewonnenglocke, 1000,600,null);
                g.drawImage(gewonnenglocke, 1600,800,null);
            }
            else if(test == 1)
            {
                g.setFont(new Font("Arial",Font.BOLD,25));
                g.drawString("Schade! Du hast verloren." , 840, 200);
                g.drawImage(verloren, 850,300,null);
            }
            else if(test == 2)
            {
                g.setFont(new Font("Arial",Font.BOLD,25));
                g.drawString("Unentschieden! Versuche es nocheinmal." , 785, 200);
            }
            else {}
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
                        test = winOrLose();
                        if(test <=2 && test >= 0) {
                            skip = 8;
                        }
                    }
                    else if (skip == 8) {
            restart.buttonPointed(x,y);
            end.buttonPointed(x,y);
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
            g.clearRect((int)koordinateX + 225, (int) koordinateY, 5,225);
            g.clearRect((int)koordinateX , (int) koordinateY-5, 225,5);
            g.clearRect((int)koordinateX , (int) koordinateY+ 225, 225,5);
            g.clearRect((int)koordinateX-5 , (int) koordinateY, 5,225);
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
                test = 2 ;
                return 2;
            }
            else if (actualImage == stein)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == papier)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == echse)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == brunnen)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == stock)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == spock)
            {
                test = 0;
                return 0;
            }
        }
        else if(computerImage==stein)
        {
            if(actualImage == schere)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == stein)
            {
                test = 2 ;
                return 2;
            }
            else if (actualImage == papier)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == echse)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == brunnen)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == stock)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == spock)
            {
                test = 0;
                return 0;
            }
        }
        else if(computerImage==papier)
        {
            if(actualImage == schere)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == stein)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == papier)
            {
                test = 2 ;
                return 2;
            }
            else if (actualImage == echse)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == brunnen)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == stock)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == spock)
            {
                test = 1;
                return 1;
            }
        }
        else if(computerImage==echse)
        {
            if(actualImage == schere)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == stein)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == papier)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == echse)
            {
                test = 2 ;
                return 2;
            }
            else if (actualImage == brunnen)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == stock)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == spock)
            {
                test = 1;
                return 1;
            }
        }
        else if(computerImage==brunnen)
        {
            if(actualImage == schere)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == stein)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == papier)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == echse)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == brunnen)
            {
                test = 2 ;
                return 2;
            }
            else if (actualImage == stock)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == spock)
            {
                test = 1;
                return 1;
            }
        }
        else if(computerImage==stock)
        {
            if(actualImage == schere)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == stein)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == papier)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == echse)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == brunnen)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == stock)
            {
                test = 2 ;
                return 2;
            }
            else if (actualImage == spock)
            {
                test = 0;
                return 0;
            }
        }
        else if(computerImage==spock)
        {
            if(actualImage == schere)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == stein)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == papier)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == echse)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == brunnen)
            {
                test = 0;
                return 0;
            }
            else if (actualImage == stock)
            {
                test = 1;
                return 1;
            }
            else if (actualImage == spock)
            {
                test = 2 ;
                return 2;
            }
        }
        return 4;

    }
}