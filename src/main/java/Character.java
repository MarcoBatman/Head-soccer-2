import processing.core.PApplet;
import processing.core.PVector;

public class Character {
    int count;
    boolean onwayback;
    boolean stopped;
    PApplet p;
    PVector pos;
    PVector vel = new PVector(0, 0);
    PVector resistanceX = new PVector((float) -0.5, (float) 0);
    PVector resistanceY = new PVector((float) 0, (float) 0.3);
    boolean up, down, left, right, kick;
    int playernr;
    float[] sizelist = new float[3];
    PVector p3;
    PVector p1;
    PVector p2;
    float movementModifire;


    Character(PApplet p, int posX, int posY, int player) {
        this.p = p;
        this.pos = new PVector(posX, posY);
        this.playernr = player;
        sizelist[0] = 100;
        sizelist[1] = 50;
        sizelist[2] = 40;
    }

    void move(int cpulvl,Character player2) {
        movementModifire  = (float) (cpulvl*0.2+1);
        if (up&&pos.y==p.height-33){
            vel.y = -10;}
        if (left&&!stopped){
            vel.x = -5;
        if(playernr==3){
            vel.x*=movementModifire;
        }
        }
        if (right&&!stopped){
            vel.x = 5;
            if(playernr==3){
                vel.x*=movementModifire;}
        }
        if (vel.x > 0){
            vel.add(resistanceX);}
        if (vel.x < 0){
            vel.sub(resistanceX);}
        if(kick||count>0){
            if(!onwayback)
               count++;
            if (onwayback)
                count--;
             if (count==20)
                 onwayback=true;
             if (count==0)
                 onwayback=false;
        }

        vel.add(resistanceY);
        hitPlayer( player2);
        pos.add(vel);
        if (pos.x <= 0) {
            vel.x = 0;
            pos.x = 0;
        }

        if (pos.x >= p.width) {
            vel.x = 0;
            pos.x = p.width;
        }

        if (pos.y > p.height-33){
            vel.y = 0;
        pos.y = p.height-33 ;}
stopped=false;
    }

    void display() {


        if(playernr==1){
            p.ellipse(pos.x, pos.y, 80, 80);
            p.ellipse(pos.x,pos.y-50,30,30);
                    p.ellipse(pos.x+30+count,pos.y+30,20,20);

        }
        if(playernr==2||playernr==3){
            if (playernr==2) {
                p.fill(0, 255, 0);
            }
            if (playernr==3){
                p.fill(0,0,255);
            }
            p.ellipse(pos.x, pos.y, 80, 80);
            p.ellipse(pos.x,pos.y-50,30,30);
        p.ellipse(pos.x-30-count,pos.y+30,20,20);}
        p.fill(255);
    }

    void hitPlayer(Character player2){

        if(pos.x<player2.pos.x&&pos.dist(player2.pos)<80){
           vel.x-= 5;

        }

        if(pos.x>player2.pos.x&&pos.dist(player2.pos)<80){
            vel.x+= 5;

        }

    }
    void hitball(Ball ball){
        
        p1 = new PVector(pos.x,pos.y);
        p2= new PVector(pos.x,pos.y-50);
        if(playernr==1) {

           p3 = new PVector(pos.x + 30+count, pos.y + 30);
        }else{

             p3 = new PVector(pos.x-30-count,pos.y+30);
        }
        PVector[] poslist = new PVector[3];
        poslist[0] = p1;
        poslist[1] = p2;
        poslist[2] = p3;

        for (int i = 0 ; i < 3; i++) {
            float distance = p.dist(poslist[i].x, poslist[i].y, ball.pos.x, ball.pos.y);
            if (distance < sizelist[i]/2 ) {
                float X = (float) (poslist[i].x + 2.5 * 30 + sizelist[i]);
                float Y = (float) (poslist[i].y + 2.5 * 30 + sizelist[i]);
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
