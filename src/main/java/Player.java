import processing.core.PApplet;

public class Player extends Character {

    Player(PApplet p, int posX, int posY,int playernr) {
        super(p, posX, posY, playernr);
    }




    boolean setMove(int k, boolean b) {

if(playernr==1)
        switch (k) {
          case +'W':

            return up = b;

          case +'S':

            return down = b;

            case +'A':

                return left = b;

            case +'D':

                return right = b;

            default:
                return b;
        }else{
            if(playernr==2){
            switch (k) {

                case 38:
                    return up = b;


                case 40:
                    return down = b;


                case 37:
                    return left = b;


                case 39:
                    return right = b;

                default:
                    return b;
            }}else
        return b;}
    }

}
