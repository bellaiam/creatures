// Defines behavior of bird critters.
// Constuctor - defines a Bird.
// Behavior:
//      Movement - A bird moves three times north, then  three times east, then three times south,
//          then three times west, then repeat.
//      Eating - A bird never eats (default behavior).
//      Fighting - A bird ROAR if the opponent is an Ant, and POUNCE otherwise in a fight.
//      Color - A bird is colored blue.
//      String - A bird is displayed by the symbol ^ - symbol if last move of bird was north,
//          or never has never moved, > - symbol if last move of bird was east,
//          V - letter if last move of bird was south, < - symbol if last move of bird was west.
import java.awt.*;

public class Bird extends Critter {
    private int moveCount;      // Represents the number of moves that the bird takes.
    
    // Constructs a new Bird.
    public Bird() {
        this.moveCount = -1;
    }
    
    // Moves three times north, then  three times east, then three times south,
    // then three times west, then repeat.
    // Returns direction north 3 times,
    // then east 3 times, then south 3 times, then west 3 times, then repeats.
    public Direction getMove() {
        moveCount++;
        if (moveCount % 12 < 3) {
            return Direction.NORTH;
        } else if (moveCount % 12 < 6) {
            return Direction.EAST;
        } else if (moveCount % 12 < 9) {
            return Direction.SOUTH;
        } else {
            return Direction.WEST;
        }
    }
    
    // Fights with opponent critters.
    // Parameter:
    //      String opponent - the String representation of the opponent Critter.
    // Returns the Attack ROAR or POUNCE based on the opponent:
    // will ROAR if the opponent is an Ant, and POUNCE otherwise.
    public Attack fight(String opponent) {
        if (opponent.equals("%")) {
            return Attack.ROAR;
        }
        return Attack.POUNCE;
    }
    
    // Defines the color of the bird critters.
    // Returns blue color for the birds.
    public Color getColor() {
        return Color.BLUE;
    }
    
    // Defines the string representation of the bird critter.
    // Returns ^ - symbol if last move of bird was north, or never has never moved.
    // Returns > - symbol if last move of bird was east.
    // Returns capital V - letter if last move of bird was south.
    // Returns < - symbol if last move of bird was west.
    public String toString() {
        if (moveCount % 12 < 3) {
            return "^";
        } else if (moveCount % 12 < 6) {
            return ">";
        } else if (moveCount % 12 < 9) {
            return "V";
        } else {
            return "<";
        }
    }
}