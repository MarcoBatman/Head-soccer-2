import processing.core.PApplet;

public class Goal {

PApplet p;
int x,y,w,h;


    Goal(PApplet p, int x, int y, int w, int h){
    this.p =p;
    this.x = x;
    this.y =y;
    this.w =w;
    this.h =h;

    }

    public void displayGoal(){
        p.rect(0,700,50,20);

    }
    public void insideGoal(){


    }
}
