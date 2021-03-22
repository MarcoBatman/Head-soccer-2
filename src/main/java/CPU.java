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
   /* public void move (Background background) {

        if (up&&pos.y==p.height)
            vel.y = -5;
        if (left)
            vel.x = -background.cpulvl;
        if (right)
            vel.x = background.cpulvl;
        if (vel.x > 0)
            vel.add(resistanceX);
        if (vel.x < 0)
            vel.sub(resistanceX);

        vel.add(resistanceY);
        pos.add(vel);
        if (pos.x <= 0) {
            vel.x = 0;
            pos.x = 0;
        }

        if (pos.x >= p.width) {
            vel.x = 0;
            pos.x = p.width;
        }

        if (pos.y > p.height){
            vel.y = 0;
            pos.y = p.height ;}

    }

    */
}




