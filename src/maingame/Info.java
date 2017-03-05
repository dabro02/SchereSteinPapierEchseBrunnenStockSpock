package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 02.03.2017.
 */
public class Info {
    Button backToMainMenu;


    Info() {
        backToMainMenu = new Button(225, 400, 150, 50, Color.BLUE, Color.CYAN,"         Main Menu");
    }

    //rendermethode des Info-Objekts
    public void renderInfo(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD,16));
        g.drawString("Dieses Spiel wurde von Daniel Brormann ", 150,100);
        g.drawString("geschrieben und entwickelt.", 150,125);
        g.drawString("Bei Fragen und Vorschlägen für die ", 150, 150);
        g.drawString("Weiterentwicklung des Programms wenden", 150, 175);
        g.drawString("sie sich an ", 150 , 200);
        g.setColor(Color.BLUE);
        g.drawString("daniel-brormann@hotmail.com", 235,200);
        g.setColor(Color.BLACK);
        g.drawString(" .", 467 , 200);
        backToMainMenu.render(g);

    }











}
