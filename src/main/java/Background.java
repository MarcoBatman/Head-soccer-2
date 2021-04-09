import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class Background {

    PApplet p;
    int screenChange = 0;
    ArrayList<Button> buttonList; // Hvad gør den her?
    int highscoreCPU;
    int cpulvl = 1;

    Background(PApplet p) {
        this.p = p;

    }


    public void displayButtons(ArrayList<Button> buttonList) {
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).drawButton();

        }
    }

    public void inGame(Goal goal, Ball ball, Character player1, Character player2,ImageLoader imageLoader) {
        if (screenChange == 1 || screenChange == 5) {
            p.image(imageLoader.wall,0,0);
            p.noStroke();
            //scoreboard
            p.rect(p.width / 2 - 50, 0, 100, 50);
            p.rect(p.width / 2 - 125, 50, 250, 100);
            p.fill(0);
            p.textSize(60);
            p.text(goal.player1Score, p.width / 2 - 75, 125);
            p.text(goal.player2Score, p.width / 2 + 75, 125);
            p.fill(255);

            goal.displayGoal();
            goal.insideGoal(ball, player1, player2);
            if (screenChange == 1) {
                //Versus buddy

                if (goal.player1Score >= 5&& goal.player1Score>=goal.player2Score+2) {
                    p.text("Player 1 wins!\nClick on the X to get\nback to the main menu", p.width / 2, p.height / 2);
                    goal.posY = 700;

                }
                if (goal.player2Score >= 5&& goal.player2Score>=goal.player1Score+2) {
                    p.text("Player 2 wins!\nClick on the X to get\nback to the main menu", p.width / 2, p.height / 2);
                    goal.posY = 700;

                }

                player1.display();
                player1.move(cpulvl);

                    player2.display();
                    player2.move(cpulvl);


                ball.move();
                ball.display();
            }
            if (screenChange == 5) {
                //Versus CPU
                if (goal.player1Score >= 5&& goal.player1Score>=goal.player2Score+2) {
                    p.textSize(36);
                    p.text("Player 1 wins!\nClick on Play versus new CPU to\nfight versus a new CPU\n that is even harder", p.width / 2, p.height / 2);
                    p.rect(p.width / 2 - 115, 325, 250, 75);
                    p.textSize(24);
                    p.fill(255, 180, 0);
                    p.text("Play versus new CPU", p.width / 2 + 10, 375);
                    p.fill(255);
                }
                if (goal.player2Score >= 5&& goal.player2Score>=goal.player1Score+2) {
                    p.textSize(36);
                    p.text("You lose.\nClick on Highscore to see\nhow far you made it!",p.width/2,p.height/2);
                    p.rect(p.width / 2 - 115, 325, 250, 75);
                    p.fill(255, 180, 0);
                    p.textSize(24);
                    p.text("To highscore",p.width/2+10,375);
                    p.fill(255);

                }



                player1.display();
                player1.move(cpulvl);
                player2.display();
                player2.move(cpulvl);
                ball.move();
                ball.display();

                p.rect(1380,15,95,50);
                p.textSize(16);
                p.fill(255, 180, 0);
                p.text("CPU Level\n"+cpulvl,1425,33);

            }

        }
    }

    public int nextCPUBattle(Goal goal) {

        if (p.mouseX > p.width / 30 + 50 && p.mouseX < p.width / 3 + 300 && p.mouseY > 325 && p.mouseY < 400 && goal.player1Score == 5) {
            screenChange = 6;
            cpulvl++;
            System.out.println(cpulvl);
            if(cpulvl>highscoreCPU)
            highscoreCPU = cpulvl;
        }
        if (p.mouseX > p.width / 30 + 50 && p.mouseX < p.width / 3 + 300 && p.mouseY > 325 && p.mouseY < 400 && goal.player2Score == 5) {
            screenChange = 2;
        }
        return screenChange;
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
                p.textSize(50);
                p.text(highscoreCPU,p.width/2,333);
            }
        }
        public void helpMenu ( int screenChange){
            //Viser kontrols
            if (screenChange == 3) {
                p.textSize(32);
                p.textAlign(PConstants.CENTER);
                p.text("Controlls", p.width / 2, 150);
                p.text("Player 1", 350, 325);
                p.text("Player 2", 1150, 325);
                p.textSize(32);
                p.text("Jump = W\nMove left = A\nMove right = D\nKick = T", 350, 375);
                p.text("Jump = ^\nMove left = <-\nMove right = ->\nKick = -", 1150, 375);

            }
        }


    }

