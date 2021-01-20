import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }
    Background background= new Background(this);
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
        background.displayScoreBoard(goal);
        goal.displayGoal();
        goal.insideGoal(ball);
        player1.display();
        player1.move();
        player2.display();
        player2.move();
    }
    public void mouseClicked(){
        background.helpMenu();
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
