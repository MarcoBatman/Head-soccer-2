import processing.core.PApplet;
import processing.core.PVector;

public class Character {
    PApplet p;
    PVector pos;
    PVector vel;
    PVector resistanceX = new PVector((float) -0.5,(float) 0);
    PVector resistanceY = new PVector((float) 0,(float) -0.3);
    int player;

    Character(PApplet p, int posX, int posY, int player){
    this.p = p;
    this.pos=new PVector(posX,posY);
    this.player = player;
    }

    void move(){
    pos.add(vel);
    if(vel.x>0)
    vel.add(resistanceX);
    if(vel.y>0)
        vel.add(resistanceY);
    if(vel.x<0)
        vel.x=0;
    if(vel.y<0)
        vel.y=0;
    }

    void display(){


    }




}
