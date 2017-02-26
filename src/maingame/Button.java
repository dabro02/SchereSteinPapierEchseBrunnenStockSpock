package maingame;

import java.awt.*;

/**
 * Created by Daniel on 26.02.2017.
 */
public class Button {
    int x, y, w, h;
    Color c;
    String name;

    public Button(int x, int y, int w, int h, Color c, String name) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        this.name = name;



    }

  /*  boolean testClick(int mouseX, int mouseY)
    {
        if(true) {

        }
        return(mouseX)
    }*/
  void render(Graphics2D g) {
      g.setColor(c);
      g.drawRect(x, y, w, h);
      g.fillRect(x, y, w, h);
      g.setColor(Color.BLACK);
      g.drawString(name, x+ 35 , y+ 30);
  }

}
