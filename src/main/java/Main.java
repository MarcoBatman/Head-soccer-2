import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }
    Background background= new Background(this);

    ArrayList<Button> buttonList = new ArrayList();
    int screenChange;
    boolean ændreNavnSenere;


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
        background.mainMenu();
        background.inGame(goal);
        goal.insideGoal(ball);
        screenChanger();
        player1.display();
        player1.move();
        player2.display();
        player2.move();
        
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


    @Override
    public void keyPressed() {
        player1.setMove(keyCode,true);
        player2.setMove(keyCode,true);
    }

    @Override
    public void keyReleased() {
        player1.setMove(keyCode,false);
        player2.setMove(keyCode,false);
    }
}
