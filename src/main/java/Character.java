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

        if (up&&pos.y==p.height-100)
            vel.y = -5;
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

        if (pos.y > p.height-100){
            vel.y = 0;
        pos.y = p.height - 100;}

    }

    void display() {
        p.ellipse(pos.x, pos.y, 80, 80);
        p.ellipse(pos.x,pos.y-50,30,30);
        if(playernr==1){
        p.ellipse(pos.x+30,pos.y+30,20,20);}
        if(playernr==2||playernr==3){
        p.ellipse(pos.x-30,pos.y+30,20,20);}
    }

    void hitball(Ball ball){

        if(ball.pos.x+10 >= pos.x && ball.pos.x-10<=pos.x+30&&ball.pos.y>=pos.y && ball.pos.y <= pos.y + 100) {
            PVector temp = new PVector(pos.x+15,pos.y+50);
            ball.vel.mult(2);
            ball.vel.rotate(p.acos(ball.vel.x*vel.x+ball.vel.y*vel.y)/((p.sqrt(ball.vel.x*ball.vel.x+ball.vel.y*ball.vel.y)*(p.sqrt(vel.x*vel.x+vel.y*vel.y)))));
        }
    }


}
