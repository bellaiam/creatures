// Defines behavior of husky critters.
// Constuctor - defines a Husky.
// Behavior:
//      Movement - A husky moves 60 steps to the west or east, then one step south, and repeat.
//      Eating - A husky always eats.
//      Fighting - A husky ROAR if the opponent is an Ant or hungry Hippo, SCRATCH if full hippo
//          POUNCE otherwise in a fight.
//      Color - A husky is green when moves to the east and orange otherwise.
//      String - A husky is displayed by the symbol 00.
import java.awt.*;

public class Husky extends Critter {
    private int moveCount;      // Represents the number of moves the husky takes.
    private boolean isEast;     // Represents if the husky move to be east or not.
    private Direction direct;   // Represents the direction of the moves the husky takes.
    
    // Constructs a new Husky.
    public Husky() {
        this.moveCount = -1;
        direct = Direction.EAST;
    }

    // Moves 60 steps to the west or east, then one step south, and repeat.
    // Returns direction east 60 times, then south 1 time, then west 60 times,
    // then south 1 time, then repeat.
    public Direction getMove() {
        moveCount++;
        if (moveCount / 60 == 0) {
            return direct;
        } else {
            isEast = !isEast;
            if (isEast) {
                direct = Direction.EAST;
            } else {
                direct = Direction.WEST;
            }
            moveCount = -1;
            return Direction.SOUTH;
        }
            
    }
    
    // Predicts eating behavior of the husky critters.
    // Always returns eat for husky.
    public boolean eat() {
        return true;
    }
    
    // Fights with opponent critters.
    // Parameter:
    //      String opponent - the String representation of the opponent Critter.
    // A husky ROAR if the opponent is an Ant or hungry Hippo, SCRATCH otherwise
    public Attack fight(String opponent) {
        char a = opponent.charAt(0);
        if (opponent.equals("%") || a == '1' || a == '2' || a == '3' || a == '4' || a == '5'
                || a == '6' || a == '7'|| a == '8' || a == 9) {
            return Attack.ROAR;
        } else {
            return Attack.SCRATCH;
        }
    }
    
    // Defines the color of the husky critters.
    // Returns green color if husky moves to the east or orange otherwise.
    public Color getColor() {
        if (isEast) {
            return Color.GREEN;
        } else {
            return Color.ORANGE;
        }
    }
    
    // Defines the string representation of the husky critter.
    // Returns 00 - symbol for the husky.
    public String toString() {
        return "00";
    }
}