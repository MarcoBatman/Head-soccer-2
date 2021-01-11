import processing.core.PApplet;
import processing.core.PVector;

public class Ball {
    PApplet p;
    PVector pos;
    PVector vel;

    Ball(PApplet p,int posX, int posY){
        pos = new PVector(posX,posY);
        this.p=p;
    }


    void display(){
        p.ellipse(pos.x,pos.y,10,10);


    }
    void move(){
     pos.add(vel);

    }
}
