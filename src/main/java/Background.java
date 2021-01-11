import processing.core.PApplet;

public class Background {

PApplet p;
    Background(PApplet p){
        this.p = p;

    }
    public void displayScoreBoard(Goal goal){
        p.noStroke();
        p.rect(p.width/2-50,0,100,50);
        p.rect(p.width/2-125,50,250,100);
        p.fill(0);
        p.textSize(60);
        p.text(goal.player1Score,p.width/2-100,125);
        p.text(goal.player2Score,p.width/2+60,125);
        p.fill(255);
    }
}
