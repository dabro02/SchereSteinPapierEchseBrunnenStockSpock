package maingame;

import java.awt.*;

/**
 * Created by Daniel on 05.03.2017.
 */
public class PictureButtons {
    int x, y, w, h;
    boolean point = false;
    public PictureButtons(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;}

        public boolean buttonPointedpicture(int mouseX, int mouseY) {
            //System.out.println(x +"  "+ y+"  "+w+"  "+h);

            if (mouseX >= x && mouseX <= x + w && mouseY >= y + 25 && mouseY <= y + 25 + h) {


                point = true;
                return point;
            }
            point = false;
            return point;

        }

        public void renderpicturebutton(Graphics2D g)
        {
            if(point)
            {
                System.out.println("hi");
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x + 1, y + 1, w, h);
                g.drawRect(x + 2, y + 2, w, h);
            }
        }

    }
