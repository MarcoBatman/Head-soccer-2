import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class Background {

PApplet p;
    Background(PApplet p){
        this.p = p;

    }
    int screenChange = 1;
    ArrayList<Button> buttonList;



    public void displayButtons(Button button1){
        button1.drawButton();
    }
    public void inGame(Goal goal){
        if (screenChange == 1) {
            p.noStroke();
            p.rect(p.width / 2 - 50, 0, 100, 50);
            p.rect(p.width / 2 - 125, 50, 250, 100);
            p.fill(0);
            p.textSize(60);
            p.text(goal.player1Score, p.width / 2 - 105, 125);
            p.text(goal.player2Score, p.width / 2 + 70, 125);
            p.fill(255);
            goal.displayGoal();
        }
    }
    public void mainMenu(){
        //Main menu hvor man kan gå ind i de andre menuer
        if (screenChange == 0){
            p.textSize(30);
            p.textAlign(PConstants.CENTER);
            p.text("Welcome", p.width/2,75);

        }
    }
    public void highScoreMenu(){
        //Viser highscores (gemmes ikke hvis man lukker spillet)

        p.textSize(32);
            p.textAlign(PConstants.CENTER);
            p.text("Highscore for this sesion",p.width/2,150);
           // p.text(highscore,p.width/2,250);
    }
    public void helpMenu() {
        //Viser kontrols
            p.textSize(32);
            p.textAlign(PConstants.CENTER);
            p.text("Controlls", p.width / 2, 150);
            p.text("Player 1", 150, 200);
            p.text("Player 2", 850, 200);
            p.textSize(24);
            p.text("Jump = W\nMove left = A\nMove right = D\nKick = Spacebar", 150, 275);
            p.text("Jump = ^\nMove left = <-\nMove right = ->\nKick = Cant huske", 850, 275);

        }


}
