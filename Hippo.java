// Defines behavior of hippo critters.
// Constuctor - defines an Hippo with a given random number of hunger.
// Behavior:
//      Movement - A hippo moves 5 steps in a randomly chosen direction, then 5 steps in another
//          randomly chosen direction, then repeat.
//      Eating - A hippo eats if still hungry, aka hunger > 0.
//      Fighting - A hippo scratch if still hungry; otherwise, pounce in a fight.
//      Color - A hippo is grey if still hungry; otherwise, white..
//      String - A hippo is displayed by the symbol number corresponded
//          to the amount of remaining hunger.
import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
    private Random rand;      // Represents the random number.
    private Direction direct; // Represents the number of directions.
    private int moveCount;    // Represents the number of moves the hippo takes.
    private int hunger;       // Represents the amount of the hunger level.
    
    // Constructs a new Hippo.
    // Parameter:
    //      int hunger - is the amount of food the hippo will eat in its lifetime.
    public Hippo(int hunger) {
        rand = new Random();
        this.moveCount = -1;
        this.hunger = hunger;
    }
    
    // Moves 5 steps in a randomly chosen direction, then five (5) steps in another
    // randomly chosen direction, then repeat.
    // Returns randomly choosen direction north, south, west or east every 5 steps.
    public Direction getMove() {
        moveCount++;
        if (moveCount % 5 == 0) {
            int direction = rand.nextInt(4);
            if (direction == 0) {
                direct = Direction.NORTH;
            } else if (direction == 1) {
                direct = Direction.SOUTH;
            } else if (direction == 2) {
                direct = Direction.EAST;
            } else {
                direct = Direction.WEST;
            }
        }
        return direct;
    }
    
    // Predicts eating behavior of the hippo critters.
    // Returns eat for hippo if it's still hungry, hunger > 0, otherwise returns don't eat.
    public boolean eat() {
        if (hunger > 0) {
            hunger--;
            return true;
        }
        return false;
    }
    
    // Fights with opponent critters.
    // Parameter:
    //      String opponent - the String representation of the opponent Critter.
    // Returns the scratch or pounce based on the hunger level:
    // will Scratch if still hungry; otherwise, pounce.
    public Attack fight(String opponent) {
        if (hunger > 0) {
            return Attack.SCRATCH;
        }
        return Attack.POUNCE;
    }
    
    // Defines the color of the hippo critters.
    // Returns grey color for the hippo if it still hungry, otherwise, white.
    public Color getColor() {
        if (hunger > 0) {
            return Color.GRAY;
        }
        return Color.WHITE;
    }
    
    // Defines the string representation of the hippo critter.
    // Returns number corresponded to the amount of remaining hunger of the hippos.
    public String toString() {
        return "" + hunger;
    }
}