import processing.core.PApplet;
import processing.core.PConstants;

public class Button {


    PApplet p;
    boolean pressed;
    float x, y, w, h;
    String text;

    Button(PApplet p, float x, float y, float w, float h, String t) {
        this.h = h;
        this.p = p;
        this.text = t;
        this.w = w;
        this.x = x;
        this.y = y;

    }
    //drawButton tegner vores knap
    public void drawButton() {
        p.textSize(24);
        p.fill(255);
        p.rect(x, y, w, h);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text(text, x + w / 2, y + h / 2);
        p.fill(255);
    }


    //isButtonPressed gør så knappen virker ved at retunere en boolean
    boolean isButtonPressed() {
        return pressed;


    }
    //registrerClick tjekker om musen er indenfor vores knap
    void registerClick(float xin, float yin) {

        if (xin > x && xin < x + w && yin < y + h && yin > y) {
            pressed = true;
        }
    }

}
