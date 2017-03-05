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

    }
