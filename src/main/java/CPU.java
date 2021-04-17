import processing.core.PApplet;

public class CPU extends Character {

    CPU(PApplet p, int posX, int posY,int playernr) {
        super(p, posX, posY,playernr);
    }

    //setMove funktionen funktion er at få CPU'en til at bevæge sig.
    //CPU'en bevæger sig efter boldens position og hopper eller sparker efter bolden under specielle forhold.
    void setMove(Ball ball) {

        if (playernr == 3){
            if(ball.pos.x>pos.x||(ball.pos.x==pos.x&&ball.vel.x>0)){
                right=true;
            }else {
                right = false;
            }

            if(ball.pos.x<pos.x||(ball.pos.x==pos.x&&ball.vel.x<0)){
                left=true;
            }else{
                left=false;
            }

            if(ball.pos.x<pos.x  && ball.vel.x>0 ){
                up=true;
                kick=true;
            }else{
                up=false;
                kick=false;
            }


        }

    }



}




