import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {
    PApplet p;
    PImage wall;
    PImage mainMenuBackground;
    ImageLoader(PApplet p){
       this.p=p;
    }

// loader vores billeder
    void loadimage(){
        wall=p.loadImage("WALL.exe.png");
        mainMenuBackground=p.loadImage("ObeseBallMainMenu.png");

    }
}
