package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 02.03.2017.
 */
public class Info extends JPanel {
    Button backToMainMenu;


    Info()
    {

    }

    public void renderInfo(Graphics2D g)
    {
        g.clearRect(0,0,600,600);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD,16));
        g.drawString("Dieses Spiel wurde von Daniel Brormann ", 100,100);
        g.drawString("geschrieben und entwickelt.", 100,125);
        g.drawString("Bei Fragen und Vorschlägen für die ", 100, 150);
        g.drawString("Weiterentwicklung des Programms wenden", 100, 175);
        g.drawString("sie sich an ", 100 , 200);
        g.setColor(Color.BLUE);
        g.drawString("daniel-brormann@hotmail.com", 185,200);
        g.setColor(Color.BLACK);
        g.drawString(" .", 420 , 200);
        backToMainMenu = new Button(225, 400, 150, 50, Color.BLUE, Color.CYAN,"         Main Menu");
        backToMainMenu.render(g);
    }


    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        renderInfo(g);

    }

}
