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
      g.setColor(c);
      g.drawRect(x, y, w, h);
      g.setColor(k);
      g.fillRect(x+1, y+1, w-1, h-1);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Arial", Font.BOLD, 16));
      g.drawString(name, x , y+ 30);



  }

  public boolean buttonPointed(Graphics2D g,int x, int y, int w, int h){
      boolean l = false;
      int mouseX;
      int mouseY;

      PointerInfo a = MouseInfo.getPointerInfo();
      Point b = a.getLocation();
      mouseX = (int) b.getX();
      mouseY = (int) b.getY();
      //System.out.println(x +"  "+ y+"  "+w+"  "+h);




            if(mouseX >= 500 + x && mouseX <= 500+x+w && mouseY >= 225+y && mouseY <= 225 + y+ h)
            {
                l = true;
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x+1,y+1,w,h);
                g.drawRect(x+2,y+2,w,h);
            }

      //mouseX >= x && mouseX <= x+w && mouseY >= y && mouseY <= y + h
      return l;

  }


}
