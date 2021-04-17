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


    CPU cpu = new CPU(this,1425,1500,3);
    Player player1 = new Player(this,75,1500,1);

    Player player2 = new Player(this,1425,1500,2);

    ImageLoader imageLoader = new ImageLoader(this);

    Goal goal= new Goal(this);
    Ball ball = new Ball(this,width/2,500);


    @Override
    public void settings() {
        super.settings();
        size(1500,1000);
    }

    @Override
    public void setup() {
        super.setup();
        imageLoader.loadimage();
    }

    @Override
    public void draw() {
        clear();


        background.mainMenu(screenChange, imageLoader);
        if(screenChange==1){
            player1.hitPlayer(player2);
        player2.hitPlayer(player1);
        background.inGame(goal, ball,player1,player2,imageLoader);
            player1.hitball(ball);
            player2.hitball(ball);
        }
        if(screenChange==5) {
        cpu.setMove(ball);
            player1.hitPlayer(cpu);
            cpu.hitPlayer(player1);
       // cpu.move(background);
        background.inGame(goal, ball, player1, cpu,imageLoader);
            player1.hitball(ball);
            cpu.hitball(ball);
        }
        //goal.insideGoal(ball, player1, player2);
        //goal.insideGoal(ball,player1,cpu);
        background.helpMenu(screenChange);
        background.highScoreMenu(screenChange);



        buttonsInmenues();
        background.displayButtons(buttonList);

        screenChanger();


    }

    public void mouseClicked(){
        if (clicked == false){
            for (int i = 0; i <buttonList.size();i++){
                buttonList.get(i).registerClick(mouseX,mouseY);
            }
            clicked = true;
        }
        screenChange = background.nextCPUBattle(goal);
        goal.player1Score ++;
        System.out.println(screenChange);
        if (screenChange!=5&&screenChange!=1) {
            player1.pos.x = 50;
            player2.pos.x = 1450;
            cpu.pos.x=1450;
            ball.pos.x=width/2;
            ball.pos.y=500;
            ball.vel.x=0;
            ball.vel.y=0;
        }
    }
    public void mouseReleased(){
        clicked = false;
    }
    public void buttonsInmenues() {
        if (screenChange == 0 && buttonStopper == true) {
            //Mainmenu
            fill(255);
            buttonList.add(new Button(this, 500, 200, 200, 50, "Spil mod ven"));
            buttonList.add(new Button(this, 800, 200, 200, 50, "Spil mod CPU"));
            buttonList.add(new Button(this, 500, 500, 200, 50, "Highscore"));
            buttonList.add(new Button(this, 800, 500, 200, 50, "Controls"));
            fill(0);
            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;

        }
        if (screenChange == 1 ||screenChange==5 && buttonStopper == true){
            //Spil (mod ven og CPU)
            buttonList.add(new Button(this, 50, 50, 50, 50, "X"));

            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;

        }


        if (screenChange == 2 && buttonStopper == true){
            //Help
            buttonList.add(new Button(this, width/3+75, 750, 333, 50, "Back to main menu"));
            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;
        }
        if (screenChange == 3 && buttonStopper == true){
            //Highscore
            buttonList.add(new Button(this, width/3+75, 750, 333, 50, "Back to main menu"));
            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;
        }
        if (screenChange == 6){
            //Næste CPU battle
            buttonList.add(new Button(this, width/2-115,325 , 250, 75, "Start the next level"));

            //Gør så den kun tegner knapperne på skærmen 1 gang
            buttonStopper= false;

        }

    }

    public void screenChanger(){
        buttonEffect(0,0,1); //Fra main menu til spil mod ven
        buttonEffect(1,0,5); //Fra main menu til spil mod CPU
        buttonEffect(2,0,2); //Fra main menu til kontrolls menuen
        buttonEffect(3,0,3); //Fra main menu til highscore
        buttonEffect(0,1,0); //Fra spillet (2 player) til main menu
        buttonEffect(0,5,0); //Fra spillet (CPU) til main menu
        buttonEffect(0,2,0); //Fra kontrolls menuen til main menu
        buttonEffect(0,3,0); //Fra highscore til main menu
        buttonEffect(0, 6, 0); //Fra næste bane menu til main menu
        buttonEffect(1,6,5); //Fra CPU til CPU igen (næste bane)
        changedScreen = false;
    }

    public void buttonEffect(int nrButton, int onScreen, int toScreen){
    if (screenChange==onScreen&&changedScreen == false){
        if (buttonList.get(nrButton).isButtonPressed()){
            screenChange = toScreen;
            background.screenChange=toScreen;
            buttonList.clear();
            buttonStopper = true;
            changedScreen = true;
            goal.player2Score = 0;
            goal.player1Score = 0;
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
