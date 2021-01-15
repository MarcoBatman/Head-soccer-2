import processing.core.PApplet;

public class Player extends Character {

    Player(PApplet p, int posX, int posY,int playernr) {
        super(p, posX, posY, playernr);
    }




    boolean setMove(int k, boolean b) {


        switch (k) {
          case +'W':
          case 38:
            return up = b;

          case +'S':
          case 40:
            return down = b;

            case +'A':
            case 37:
                return left = b;

            case +'D':
            case 39:
                return right = b;

            default:
                return b;
        }

    }

}
