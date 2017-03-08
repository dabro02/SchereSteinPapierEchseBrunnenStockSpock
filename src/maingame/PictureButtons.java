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
            //System.out.println(mouseX + "  "+ mouseY);

            if (mouseX >= x && mouseX <= x + w && mouseY >= y + 25 && mouseY <= y + 25 + h) {
                //System.out.println("ja es hat geklappt");
                point = true;
                return point;
            }
            return point;


        }

        public void renderpicturebutton(Graphics2D g)
        {
            if(point)
            {
                //System.out.println("hi");
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x + 1, y + 1, w, h);
                g.drawRect(x + 2, y + 2, w, h);
                point = false;
            }
        }

    }
