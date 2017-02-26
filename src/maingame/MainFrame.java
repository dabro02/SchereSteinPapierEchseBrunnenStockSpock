package maingame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class MainFrame extends JPanel {
    String title;
    JLabel text;
    JFrame meinFrame;
    Color c;
    Button start;
    Button info;
    Button einstellungen;
    Button beenden;
    MainGame game;
    int x;
    int y;
    int w;
    int h;


    public MainFrame(String title, String text, int x , int y, int w, int h, Color c, Color schriftfarbe , int schriftgröße , MainGame game )
    {
        setLayout(null);
        this.title = title;
        this.c = c;
        //MainFrame
        this.x =x;
        this.y =y;
        this.w =w;
        this.h =h;
        this.game = game;
        game.frame.setBounds(x, y, w,h);

        game.frame.setBackground(c);
        start = new Button(250 , 50 , 100, 50 , Color.DARK_GRAY , "Start");
        this.start=start;



        this.text = new JLabel(text);
        this.text.setBounds(100,10,600,30);
        //this.text.setFont(new Font("1", Font.ITALIC, schriftgröße));
        add(this.text);


    }
    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        start.render(g);
    }


}




