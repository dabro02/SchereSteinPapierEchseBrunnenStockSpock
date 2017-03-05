package maingame;

import java.awt.*;

/**
 * Created by Daniel on 05.03.2017.
 */
public class HauptSpiel {
    MainGame game;
    //Konstruktor
    HauptSpiel(MainGame game)
    {
        this.game = game;
        game.frame.setBounds(0,0,1920,1080);

    }

    //rendermethode vom maingame
    public void renderHauptSpiel(Graphics2D g)
    {
        g.setFont(new Font("Arial", Font.BOLD , 24));
        g.drawString("Hallo Benutzer und Herzlich Willkommen zum Schere-Stein-Papier-Echse-Brunnen-Stock-Spock-Spiel.", 390, 100);
        g.setFont(new Font("Arial", Font.BOLD , 20));
        g.drawString("Ihnen werden jetzt die Regeln des Spiel erklärt, wenn sie diese überspringen wollen klicken sie auf den Bildschirm", 420, 200);
        g.drawString("Wählen sie eine der vorgegebenen Begriffe.", 460, 300);

    }
}
