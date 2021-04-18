import processing.core.PApplet;
import processing.core.PVector;

public class Ball {
    PApplet p;
    PVector pos;
    PVector vel=new PVector(0, (float) 2);
    PVector forceY=new PVector(0, (float) 0.2);
    PVector forceX=new PVector((float) 0.02,  0);

    Ball(PApplet p,int posX, int posY){
        pos = new PVector(posX,posY);
        this.p=p;
    }


    void display(){
        //displayer bolden
        p.ellipse(pos.x,pos.y,30,30);


    }
    void move(Goal goal){
        //får bolden til at rykke sig
        vel.add(forceY);
        if(vel.x<0)
        vel.add(forceX);
        if(vel.x>0)
            vel.sub(forceX);
    if(pos.x>p.width){
        vel.x= -vel.x/3;
        pos.x=p.width-2;
    }
    if(pos.x<0){
        vel.x= -vel.x/3;
        pos.x=2;
    }
        if(pos.y>p.height){
            vel.y= -vel.y/3;
            pos.y=p.height-2;
        }
        if(pos.y<0){
            vel.y= -vel.y/3;
            pos.y=2;
        }
        if (pos.y>=goal.posY+300 && pos.x<72){
            //System.out.println("hej");
            vel.x= -vel.x/3;
            pos.x=74;

        }
        if (pos.y>=goal.posY+300 && pos.x>1428) {
            //System.out.println("hej");
            vel.x = -vel.x / 3;
            pos.x=1426;
        }
        if (pos.y>=goal.posY-10 && pos.y<=goal.posY  && pos.x<72){
            vel.y=-vel.y/2;
            pos.y-=5;

        }
        if (pos.y>=goal.posY-10 && pos.y<=goal.posY  && pos.x>1428){
            vel.y=-vel.y/2;
            pos.y-=5;
        }

        pos.add(vel);
    }

}
