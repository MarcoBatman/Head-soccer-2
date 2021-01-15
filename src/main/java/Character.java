import processing.core.PApplet;
import processing.core.PVector;

public class Character {
    PApplet p;
    PVector pos;
    PVector vel;
    PVector resistanceX = new PVector((float) -0.5, (float) 0);
    PVector resistanceY = new PVector((float) 0, (float) 0.3);
    boolean up, down, left, right;
    int playernr;

    Character(PApplet p, int posX, int posY, int player) {
        this.p = p;
        this.pos = new PVector(posX, posY);
        this.playernr = player;
    }

    void move() {
        pos.add(vel);
        if (up)
            vel.y = -7;
        if (left)
            vel.x = -5;
        if (right)
            vel.x = 5;
        if (pos.y < 0)
            pos.y = 0;
        if (vel.x > 0)
            vel.add(resistanceX);
        if (vel.x < 0)
            vel.sub(resistanceX);
        if (vel.y > 0)
            vel.add(resistanceY);
        if (playernr == 1) {
            if (pos.x <= 0) {
                vel.x = 0;
                pos.x = 0;
            }
        }
        if (playernr == 2) {
            if (pos.x >= p.width) {
                vel.x = 0;
                pos.x = p.width;
            }
        }
        if (pos.y > p.height)
            vel.y = 0;
    }

    void display() {
        p.rect(pos.x, pos.y, 30, 100);

    }


}
