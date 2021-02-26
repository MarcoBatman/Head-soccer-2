import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {
    PApplet p;
    PImage wall;
    ImageLoader(PApplet p){
       this.p=p;
    }


    void loadimage(){
        wall=p.loadImage("WALL.exe.png");


    }
}
