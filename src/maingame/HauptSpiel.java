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
    JLabel scherelabel;
    Icon schereicon;



    //Konstruktor
    HauptSpiel(MainGame game)
    {
        this.game = game;
        /*try {
            schereicon = new ImageIcon(getClass().getResource("C:\\TestJavaGraphics\\Schere.png"));
            scherelabel = new JLabel(schereicon);
        }
        catch(Exception e)
        {

        }*/
        game.frame.setBounds(0,0,1920,1080);
        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(game.activescreen== 2)
                {
                    if(true)
                        if(skip == 0)
                        {skip++;}
                    else if (skip ==1)
                        {
                            if(game.maingame.scherebutton.buttonPointedpicture(e.getX(), e.getY()));
                            {
                                System.out.println("schere");
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

    }

    //rendermethode vom maingame
    public void renderHauptSpiel(Graphics2D g)
    {
            if(skip == 0) {
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString("Hallo Benutzer und Herzlich Willkommen zum Schere-Stein-Papier-Echse-Brunnen-Stock-Spock-Spiel.", 390, 100);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Ihnen werden jetzt die Regeln des Spiel erklärt, Klicken sie auf den Bildschirm um weiter zu machen.", 470, 200);
            }
            if(skip ==1){
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Wählen sie einen der Folgenden Begriffe.", 700,200);
                //bild funktioniert noch nicht ganz unbedingt gucken woran das liegt, dass er egal wo man hinclickt "schere" ausgibt!!!
                //"C:\\TestJavaGraphics\\Schere.png"
                    int xschere = 300;
                    int yschere = 300;
                    int wschere = 300;
                    int hschere = 300;
                    scherebutton = new PictureButtons(xschere,yschere,wschere,hschere);
                    scherebutton.renderpicturebutton(g);
            }


        //g.drawString("Wählen sie eine der vorgegebenen Begriffe.", 460, 300);

    }


}
