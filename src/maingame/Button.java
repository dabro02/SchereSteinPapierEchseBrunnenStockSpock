package maingame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Daniel on 26.02.2017.
 */
public class Button {
    int x, y, w, h;
    Color c, k;
    String name;
    boolean point = false;


    public Button(int x, int y, int w, int h, Color c,Color k, String name) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        this.k = k;
        this.name = name;



    }


  void render(Graphics2D g) {
      g.setColor(k);
      g.fillRect(x, y, w, h);

      g.setColor(c);
      g.drawRect(x, y, w, h);

      g.setColor(Color.BLACK);
      g.setFont(new Font("Arial", Font.BOLD, 16));
      g.drawString(name, x , y+ 30);

      if(point) {
          g.setColor(Color.DARK_GRAY);
          g.drawRect(x+1,y+1,w,h);
          g.drawRect(x+2,y+2,w,h);
      }



  }

  public boolean buttonPointed(int mouseX, int mouseY){
      //System.out.println(x +"  "+ y+"  "+w+"  "+h);

      if(mouseX >= x && mouseX <= x+w && mouseY >= y+25 && mouseY <= y+25+ h) {
          point = true;
          return point;
      }
      point = false;
      return point;

  }


}
