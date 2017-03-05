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
    int y = 0;
    int x = 0;


    //Konstruktor
    HauptSpiel(MainGame game)
    {
        this.game = game;
        game.frame.setBounds(0,0,1920,1080);
        try {
            y = game.frame.getMousePosition().y;
            x = game.frame.getMousePosition().x;
        }
        catch(Exception e){}
        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(game.activescreen== 2)
                {
                    if(true)
                        if(skip == 0)
                            skip++;
                    else if (skip ==1)
                        if(scherebutton.buttonPointedpicture(x,y));
                        {
                            System.out.println("hallo es hat geklappt");
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
                //bild funktioniert noch nicht ganz
                BufferedImage schere = null;
                try{
                    schere = ImageIO.read(new File("C:\\TestJavaGraphics\\Schere.png"));
                    g.drawImage(schere, 300,300, null );
                    scherebutton = new PictureButtons(300,300,300,300);
                    if(scherebutton.buttonPointedpicture(x,y))
                    {
                        System.out.println("hallo");
                        g.setColor(Color.DARK_GRAY);
                        g.drawRect(300 + 1, 300 + 1, 300, 300);
                        g.drawRect(300 + 2, 300 + 2, 300, 300);
                    }
                }
                catch(Exception e)
                {
                    return;
                }

            }


        //g.drawString("Wählen sie eine der vorgegebenen Begriffe.", 460, 300);

    }


}
