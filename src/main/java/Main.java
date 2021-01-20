import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }
    Background background= new Background(this);

    ArrayList<Button> buttonList = new ArrayList();
    int screenChange;
    boolean ændreNavnSenere;

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
        background.mainMenu();
        background.inGame(goal);
        goal.insideGoal(ball);
        screenChanger();
    }
    public void mouseClicked(){
        background.helpMenu();
    }
    public void screenChanger(){
        if (screenChange == 0 && ændreNavnSenere == true){
            fill(255);
            buttonList.add(new Button(this, 200, 200, 50,50 ,"Controlls"));
            buttonList.add(new Button(this, 200, 200, 50,50 ,"Spil mod CPU"));
            buttonList.add(new Button(this, 200, 200, 50,50 ,"Spil mod ven"));
            buttonList.add(new Button(this, 200, 200, 50,50 ,"Highscore"));


        }


    }
}
