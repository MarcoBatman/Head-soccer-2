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
    float[] sizelist = new float[3];
    PVector p3;
    PVector p1;
    PVector p2;


    Character(PApplet p, int posX, int posY, int player) {
        this.p = p;
        this.pos = new PVector(posX, posY);
        this.playernr = player;
        sizelist[0] = 100;
        sizelist[1] = 50;
        sizelist[2] = 40;
    }

    void move() {

        if (up&&pos.y==p.height)
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

        if (pos.y > p.height){
            vel.y = 0;
        pos.y = p.height ;}

    }

    void display() {
        p.ellipse(pos.x, pos.y, 80, 80);
        p.ellipse(pos.x,pos.y-50,30,30);
        if(playernr==1){
        p.ellipse(pos.x+30,pos.y+30,20,20); }
        if(playernr==2||playernr==3){
        p.ellipse(pos.x-30,pos.y+30,20,20);}
    }

    void hitball(Ball ball){
        
        p1 = new PVector(pos.x,pos.y);
        p2= new PVector(pos.x,pos.y-50);
        if(playernr==1) {
           p3 = new PVector(pos.x + 30, pos.y + 30);
        }else{

             p3 = new PVector(pos.x-30,pos.y+30);
        }
        PVector[] poslist = new PVector[3];
        poslist[0] = p1;
        poslist[1] = p2;
        poslist[2] = p3;

        for (int i = 0 ; i < 3; i++) {
            float distance = p.dist(poslist[i].x, poslist[i].y, ball.pos.x, ball.pos.y);
            if (distance < sizelist[i]/2 ) {
                float X = (float) (poslist[i].x + 2.5 * 10 + sizelist[i]);
                float Y = (float) (poslist[i].y + 2.5 * 10 + sizelist[i]);
                float ax = (float) ((X - ball.pos.x) * 0.05);
                float ay = (float) ((Y - ball.pos.y) * 0.05);
                if(ball.pos.x>pos.x){
                ball.vel.x += ax;
                ball.vel.y += ay;}
                if(ball.pos.x<pos.x){
                    ball.vel.x -= ax;
                    ball.vel.y -= ay;}
            }
        }

    }


}
