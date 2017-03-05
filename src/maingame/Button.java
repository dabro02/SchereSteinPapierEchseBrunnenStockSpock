package maingame;

import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class Button {
    int x, y, w, h;
    Color surroundingColor, backgroundColor;
    String name;
    boolean point = false;
    Font font = new Font("Arial", Font.BOLD, 16);


    public Button(int x, int y, int w, int h, Color surroundingColor, Color backgroundColor, String name) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.surroundingColor = surroundingColor;
        this.backgroundColor = backgroundColor;
        this.name = name;
    }


    void render(Graphics2D g) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, w, h);

        g.setColor(surroundingColor);
        g.drawRect(x, y, w, h);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(name, x, y + 30);

        if (point) {
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x + 1, y + 1, w, h);
            g.drawRect(x + 2, y + 2, w, h);
        }


    }

    public boolean buttonPointed(int mouseX, int mouseY) {
        //System.out.println(x +"  "+ y+"  "+w+"  "+h);

        if (mouseX >= x && mouseX <= x + w && mouseY >= y + 25 && mouseY <= y + 25 + h) {
            point = true;
            return point;
        }
        point = false;
        return point;

    }

}


