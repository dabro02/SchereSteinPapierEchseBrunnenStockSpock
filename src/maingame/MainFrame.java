package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainFrame extends JPanel {
    MainGame game;

    MainFrame(MainGame game){
        this.game = game;
        game.frame.setBounds(500, 200, 600, 600);
        game.frame.setResizable(false);
        getGraphics();
        //game.frame.
    }

    @Override
    protected void paintComponent(Graphics g){

    }

    public void start() {
        while(true) {
            Graphics g = getGraphics();
            g.drawRect( 100,100,100,100);
        }
    }
}




