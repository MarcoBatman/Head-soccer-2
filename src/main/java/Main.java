import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }
    Background background= new Background(this);

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
        background.displayScoreBoard(goal);
        goal.displayGoal();
        goal.insideGoal(ball);
    }
    public void mouseClicked(){
        background.helpMenu();
    }

}
