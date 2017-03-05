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

    }
}
