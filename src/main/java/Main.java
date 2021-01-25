import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }
    Background background= new Background(this);

    ArrayList<Button> buttonList = new ArrayList();
    int screenChange = 0;
    boolean buttonStopper = true;
    boolean changedScreen = false;
    boolean clicked = false;


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
        player1.display();
        player1.move();
        player2.display();
        player2.move();
        background.helpMenu(screenChange);
        background.highScoreMenu(screenChange);

        player1.hitball(ball);
        player2.hitball(ball);
        ball.move();
        ball.display();
      //  buttonsInmenues();
        background.displayButtons(buttonList);
        //System.out.println(buttonList.size());
        screenChanger();


    }
    public void mouseClicked(){
        if (clicked == false){
            for (int i = 0; i <buttonList.size();i++){
                buttonList.get(i).registerClick(mouseX,mouseY);
            }
            clicked = true;
            System.out.println("hej");

        }
    }
    public void buttonsInmenues() {
        if (screenChange == 0 && buttonStopper == true) {
            //Mainmenu

            buttonList.add(new Button(this, 300, 200, 50, 50, "Spil mod ven"));
            buttonList.add(new Button(this, 600, 200, 50, 50, "Spil mod CPU"));
            buttonList.add(new Button(this, 300, 500, 50, 50, "Highscore"));
            buttonList.add(new Button(this, 600, 500, 50, 50, "Controlls"));

            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;

        }
        if (screenChange == 1 && buttonStopper == true){
            //Spil
            buttonList.add(new Button(this, 50, 50, 50, 50, "X"));
            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;
        }

        if (screenChange == 2 && buttonStopper == true){
            //Help
            buttonList.add(new Button(this, width/3, 750, 333, 50, "Back to main menu"));
            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;
        }
        if (screenChange == 3 && buttonStopper == true){
            //Highscore
            buttonList.add(new Button(this, width/3, 750, 333, 50, "Back to main menu"));
            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;
        }

    }

    public void screenChanger(){
        buttonEffect(0,0,1); //Fra main menu til spil mod ven
        buttonEffect(1,0,1); //Fra main menu til spil mod CPU
        buttonEffect(2,0,2); //Fra main menu til kontrolls menuen
        buttonEffect(3,0,3); //Fra main menu til highscore
        buttonEffect(0,1,0); //Fra spillet til main menu
        buttonEffect(0,2,0); //Fra kontrolls menuen til main menu
        buttonEffect(0,3,0); //Fra highscore til main menu
        changedScreen = false;
    }

    public void buttonEffect(int nrButton, int onScreen, int toScreen){
    if (screenChange==onScreen&&changedScreen == false){
        if (buttonList.get(nrButton).isButtonPressed()){
            screenChange = toScreen;
            buttonList.clear();
            buttonStopper = true;
            changedScreen = true;
        }
    }
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
