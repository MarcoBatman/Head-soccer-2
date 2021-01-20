import processing.core.PApplet;

public class Goal {
    int moveY = 0;
    float posY = 700;
    int player1Score =0;
    int player2Score = 0;
    float vel = (float) -0.5;
PApplet p;
    Goal(PApplet p){
    this.p =p;

    }

    public void displayGoal(){
        //Spiller 1 mål

        p.rect(0,posY,10,300);
        p.rect(0,posY+300,70,-10);
        p.rect(0,posY,70,20);

        //Spiller 2 mål
        p.rect(1000,posY,-10,300);
        p.rect(1000,posY,-70,-20);
        p.rect(1000,posY+300,-70,-10);

        //Pedestaler til målene
        p.fill(118,118,118);
        p.rect(1000,posY+300,-70,400);
        p.rect(0,posY+300,70,400);
        moveGoal();
        p.fill(255);

    }
    public void insideGoal(Ball ball){
if (ball.pos.x<70&&ball.pos.y<posY&&ball.pos.y>posY){
        player2Score++;
    }
if (ball.pos.x>930&&ball.pos.y<posY&&ball.pos.y>posY){
        player1Score++;
    }

    }
    public void moveGoal(){
        if (posY<=400) {
            vel = (float) 0.5;
        }
        if (posY>=700) {
            vel = (float) - 0.5;
        }
        posY+=vel;
    }

}
