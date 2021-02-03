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

    public void insideGoal(Ball ball, Player player1, Player player2){
if (ball.pos.x<70&&ball.pos.y<posY+300&&ball.pos.y>posY){
    posY=700;
    player2Score++;
    ball.pos.x = 500;
    ball.pos.y = 500;
    ball.vel.mult(0);
    System.out.println("MÅÅÅÅL p2");
    player1.pos.x=50;
    player2.pos.x=950;

}
if (ball.pos.x>930&&ball.pos.y<posY+300&&ball.pos.y>posY){
    posY=700;
    player1Score++;
    ball.pos.x = 500;
    ball.pos.y = 500;
    ball.vel.mult(0);
    System.out.println("MÅÅÅÅÅL p1");
    player1.pos.x=50;
    player2.pos.x=950;
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
