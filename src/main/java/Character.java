import processing.core.PApplet;
import processing.core.PVector;

public class Character {
    PApplet p;
    PVector pos;
    PVector vel = new PVector(0, 0);
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

        if (up)
            vel.y = -40;
        if (left)
            vel.x = -5;
        if (right)
            vel.x = 5;
        if (vel.x > 0)
            vel.add(resistanceX);
        if (vel.x < 0)
            vel.sub(resistanceX);

        vel.add(resistanceY);
        pos.add(vel);
        if (pos.x <= 0) {
            vel.x = 0;
            pos.x = 0;
        }

        if (pos.x >= p.width) {
            vel.x = 0;
            pos.x = p.width;
        }

        if (pos.y > p.height)
            vel.y = 0;
        pos.y = p.height - 100;

    }

    void display() {
        p.rect(pos.x, pos.y, 30, 100);

    }


}
