import processing.core.PApplet;

public class CPU extends Character {

    CPU(PApplet p, int posX, int posY,int playernr) {
        super(p, posX, posY,playernr);
    }

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

            if(ball.pos.x<pos.x && ball.pos.dist(pos)<20 && ball.vel.x>0 ){
                up=true;
            }else{
                up=false;
            }


        }

    }
}




