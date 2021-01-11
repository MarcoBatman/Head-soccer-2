import processing.core.PApplet;

public class Goal {

PApplet p;
    Goal(PApplet p){
    this.p =p;


    }

    public void displayGoal(){
        //Spiller 1 mål
        p.rect(0,700,10,300);
        p.rect(0,1000,70,-20);
        p.rect(0,700,70,20);

        //Spiller 2 mål
        p.rect(1000,700,-10,300);
        p.rect(1000,700,-70,-10);
        p.rect(1000,1000,-70,-10);


    }
    public void insideGoal(){


    }
}
