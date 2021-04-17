import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class Background {

    PApplet p;
    int screenChange = 0;
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
        //inGame funktionen holder styr på alt det der handler om spillet og tegner det, den modtager bolden, spillerene og en baggrund.
        // Vi har inddelt det så hvis screenChange er 1 eller 5 kommer spillet frem, og an på hvilken en screenChange det er kommer an på hvilken gamemode man spiller.
    public void inGame(Goal goal, Ball ball, Character player1, Character player2,ImageLoader imageLoader) {
        if (screenChange == 1 || screenChange == 5) {
            p.image(imageLoader.wall,0,0);
            p.noStroke();
            //scoreboard
            p.fill(255);
            p.rect(p.width / 2 - 50, 0, 100, 50);
            p.rect(p.width / 2 - 125, 50, 250, 100);
            p.fill(0);
            p.textSize(60);
            p.text(goal.player1Score, p.width / 2 - 75, 125);
            p.text(goal.player2Score, p.width / 2 + 75, 125);
            p.fill(255);
            goal.insideGoal(ball, player1, player2);
            goal.displayGoal();

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
                player1.move(cpulvl,player2);

                    player2.display();
                    player2.move(cpulvl,player1);


                ball.move(goal);
                ball.display();
            }
            if (screenChange == 5) {
                //Versus CPU

                if (goal.player1Score >= 5&& goal.player1Score>=goal.player2Score+2) {
                    p.textSize(36);
                    p.text("Player 1 wins!\nClick on Play versus new CPU to\nfight versus a new CPU\n that is even harder", p.width / 2, p.height / 2);
                    p.rect(p.width / 2 - 115, 325, 250, 75);
                    p.textSize(24);
                    p.fill(0);
                    p.text("Play versus new CPU", p.width / 2 + 10, 375);
                    p.fill(255);
                }
                if (goal.player2Score >= 5&& goal.player2Score>=goal.player1Score+2) {
                    p.textSize(36);
                    p.text("You lose.\nClick on Highscore to see\nhow far you made it!",p.width/2,p.height/2);
                    p.rect(p.width / 2 - 115, 325, 250, 75);
                    p.fill(0);
                    p.textSize(24);
                    p.text("To highscore",p.width/2+10,375);
                    p.fill(255);

                }



                player1.display();
                player1.move(cpulvl,player2);
                player2.display();
                player2.move(cpulvl,player1);
                ball.move(goal);
                ball.display();

                p.rect(1380,15,95,50);
                p.textSize(16);
                p.fill(0);
                p.text("CPU Level\n"+cpulvl,1425,33);

            }

        }
    }
        //nextCPUBattle er en funktion der sørger for at man kan spille en form for "endless run" mod CPU'en, da den efter spillet gør så spilleren kan spille mod en sværere CPU
        //nextCPUBattle gemmer også hvor langt man er kommet og putter det ind i highscore menuen
    public int nextCPUBattle(Goal goal) {

        if (p.mouseX > p.width / 30 + 50 && p.mouseX < p.width / 3 + 300 && p.mouseY > 325 && p.mouseY < 400 && goal.player1Score >= 5&&screenChange==5) {
            screenChange = 6;
            cpulvl ++;
            System.out.println(cpulvl);
            if(cpulvl>highscoreCPU)
            highscoreCPU = (cpulvl-1);
        }
        if (p.mouseX > p.width / 30 + 50 && p.mouseX < p.width / 3 + 300 && p.mouseY > 325 && p.mouseY < 400 && goal.player2Score >= 5) {
            screenChange = 2;

        }
        return screenChange;
    }
        //mainMenu funktionen tegner vores main menu ved hjælp fra ImageLoader klassen, som giver os et billede.
        public void mainMenu ( int screenChange, ImageLoader imageLoader){
            //Main menu hvor man kan gå ind i de andre menuer
            if (screenChange == 0) {
                p.image(imageLoader.mainMenuBackground,0,0);
                p.textSize(30);
                p.textAlign(PConstants.CENTER);
                p.text("Welcome to Obeseball", p.width / 2, 75);
            }
        }
        //highScoreMenu holder styr på ens highscore.
        public void highScoreMenu ( int screenChange){
            //Viser highscores (gemmes ikke hvis man lukker spillet)
            if (screenChange == 2) {
                p.textSize(32);
                p.textAlign(PConstants.CENTER);
                p.text("Highscore for this session", p.width / 2, 150);
                p.textSize(50);
                p.text(highscoreCPU,p.width/2,333);
            }
        }
        //helpMenu viser hvordan man styre spillet
    public void helpMenu ( int screenChange){
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

