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
        //Spiller 1 mål
        p.rect(0,700,50,20);
        p.rect(0,1000,20,20);
        p.rect(0,1000,50,20);

        //Spiller 2 mål
        p.rect(1000,700,-50,-20);
        p.rect(1000,1000,-20,-20);
        p.rect(1000,1000,-50,-20);


    }
    public void insideGoal(){


    }
}
