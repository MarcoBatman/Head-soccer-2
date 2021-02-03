import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class Background {

    PApplet p;
    int screenChange = 0;
    ArrayList<Button> buttonList;
    int scoreVSCPU;

    Background(PApplet p) {
        this.p = p;

    }


    public void displayButtons(ArrayList<Button> buttonList) {
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).drawButton();

        }
    }

    public void inGame(Goal goal, Ball ball, Player player1, Player player2) {
        if (screenChange == 1 || screenChange == 5) {

            p.noStroke();
            p.rect(p.width / 2 - 50, 0, 100, 50);
            p.rect(p.width / 2 - 125, 50, 250, 100);
            p.fill(0);
            p.textSize(60);
            p.text(goal.player1Score, p.width / 2 - 75, 125);
            p.text(goal.player2Score, p.width / 2 + 75, 125);
            p.fill(255);
            if (screenChange == 1) {
                //Versus buddy
                if (goal.player2Score < 5 && goal.player1Score < 5) {
                    goal.displayGoal();
                    goal.insideGoal(ball, player1, player2);
                }

                if (goal.player1Score == 5) {
                    p.text("Player 1 wins!\nClick on the X to get\nback to the main menu", p.width / 2, p.height / 2);
                    goal.posY = 700;

                }
                if (goal.player2Score == 5) {
                    p.text("Player 2 wins!\nClick on the X to get\nback to the main menu", p.width / 2, p.height / 2);
                    goal.posY = 700;

                }
                player1.display();
                player1.move();
                player2.display();
                player2.move();
                ball.move();
                ball.display();
            }
            if (screenChange == 5) {
                //Versus CPU
                if (goal.player1Score == 5) {
                    p.text("Player 1 wins!\nClick on Play again to\nfight versus a new CPU", p.width / 2, p.height / 2);
                    goal.posY = 700;
                }
                if (goal.player1Score < 5) {
                    goal.displayGoal();
                    goal.insideGoal(ball, player1, player2);
                }
                player1.display();
                player1.move();
                ball.move();
                ball.display();
                //cpu.display();
                //cpu.move();
            }

        }
    }
        public void mainMenu ( int screenChange){
            //Main menu hvor man kan gå ind i de andre menuer
            if (screenChange == 0) {

                p.textSize(30);
                p.textAlign(PConstants.CENTER);
                p.text("Welcome", p.width / 2, 75);

            }
        }
        public void highScoreMenu ( int screenChange){
            //Viser highscores (gemmes ikke hvis man lukker spillet)
            if (screenChange == 2) {
                p.textSize(32);
                p.textAlign(PConstants.CENTER);
                p.text("Highscore for this sesion", p.width / 2, 150);
                // p.text(highscore,p.width/2,250);
            }
        }
        public void helpMenu ( int screenChange){
            //Viser kontrols
            if (screenChange == 3) {
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

