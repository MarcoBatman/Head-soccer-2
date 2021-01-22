import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }
    Background background= new Background(this);

    ArrayList<Button> buttonList = new ArrayList();
    int screenChange = 0;
    boolean ændreNavnSenere = true;


    Player player1 = new Player(this,50,height,1);
    Player player2 = new Player(this,950,height,2);
    Goal goal= new Goal(this);
    Ball ball = new Ball(this,500,500);


    @Override
    public void settings() {
        super.settings();
        size(1000,1000);
    }

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void draw() {
        clear();

        background.mainMenu(screenChange);
        background.inGame(goal, screenChange);
        goal.insideGoal(ball);
        screenChanger();
        player1.display();
        player1.move();
        player2.display();
        player2.move();
        background.helpMenu(screenChange);
        background.highScoreMenu(screenChange);
        buttonsInmenues();
        background.displayButtons(buttonList);

    }
    public void mouseClicked(){
        screenChange++;
    }
    public void buttonsInmenues() {
        if (screenChange == 0 && ændreNavnSenere == true) {
            //Mainmenu
            fill(0);
            buttonList.add(new Button(this, 600, 500, 50, 50, "Controlls"));
            buttonList.add(new Button(this, 600, 200, 50, 50, "Spil mod CPU"));
            buttonList.add(new Button(this, 300, 200, 50, 50, "Spil mod ven"));
            buttonList.add(new Button(this, 300, 500, 50, 50, "Highscore"));


        }
        if (screenChange == 1 && ændreNavnSenere == true){
            //Spil
            buttonList.add(new Button(this, width/3, 750, 333, 50, "X"));

        }

        if (screenChange == 2 && ændreNavnSenere == true){
            //Help
            buttonList.add(new Button(this, width/3, 750, 333, 50, "Back to main menu"));
        }
        if (screenChange == 3 && ændreNavnSenere == true){
            //Highscore
            buttonList.add(new Button(this, width/3, 750, 333, 50, "Back to main menu"));

        }

    }

    public void screenChanger(){

    }


    public void keyPressed() {
        player1.setMove(keyCode,true);
        player2.setMove(keyCode,true);
    }

    public void keyReleased() {
        player1.setMove(keyCode,false);
        player2.setMove(keyCode,false);
    }
}
