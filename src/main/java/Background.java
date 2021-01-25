import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class Background {

PApplet p;
    int screenChange = 0;
    ArrayList<Button> buttonList;

    Background(PApplet p){
        this.p = p;

    }


    public void displayButtons(ArrayList<Button> buttonList){
        for (int i = 0; i <buttonList.size() ; i++) {
            buttonList.get(i).drawButton();

        }
    }
    public void inGame(Goal goal, int screenChange, Ball ball){
        if (screenChange == 1) {
            p.noStroke();
            p.rect(p.width / 2 - 50, 0, 100, 50);
            p.rect(p.width / 2 - 125, 50, 250, 100);
            p.fill(0);
            p.textSize(60);
            p.text(goal.player1Score, p.width / 2 - 75, 125);
            p.text(goal.player2Score, p.width / 2 + 75, 125);
            p.fill(255);
            goal.displayGoal();
            goal.insideGoal(ball);
        }
    }
    public void mainMenu(int screenChange){
        //Main menu hvor man kan gå ind i de andre menuer
        if (screenChange == 0){

            p.textSize(30);
            p.textAlign(PConstants.CENTER);
            p.text("Welcome", p.width/2,75);

        }
    }
    public void highScoreMenu(int screenChange) {
        //Viser highscores (gemmes ikke hvis man lukker spillet)
        if (screenChange == 4) {
            p.textSize(32);
            p.textAlign(PConstants.CENTER);
            p.text("Highscore for this sesion", p.width / 2, 150);
            // p.text(highscore,p.width/2,250);
        }
    }
    public void helpMenu(int screenChange) {
        //Viser kontrols
        if (screenChange==3) {
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


}
