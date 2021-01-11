import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) { PApplet.main("Main"); }

    Goal goal= new Goal(this);
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
        goal.displayGoal();
    }

}
