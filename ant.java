// Defines behavior of ant critters.
// Constuctor - defines an Ant with a given boolean walkSouth.
// Behavior:
//      Movement - An ant moves south east or north east.
//      Eating - An ant always eats.
//      Fighting - An ant always SCRATCH in a fight.
//      Color - An ant is colored red.
//      String - An ant is displayed by the symbol %.
import java.awt.*;

public class Ant extends Critter {
    private int moveCount;          // Represents the number of moves the ant takes.
    private Direction direction;    // Represents the direction of the moves the ant takes.
    
    // Constructs a new Ant.
    // Parameter:
    // boolean walkSouth - if true ant moves to the south,  if false - to the north.
    public Ant(boolean walkSouth) {
        this.moveCount = -1;
        if (walkSouth) {
            direction = Direction.SOUTH;
        } else {
            direction = Direction.NORTH;
        }
    }
    
    // Moves switches between south east or north east.
    // Returns direction south or north when moveCounts are odd,
    // and returns east if moveCounts are even.
    public Direction getMove() {
        moveCount++;
        if (moveCount % 2 == 0) {
            return direction;
        } else {
            return Direction.EAST;
        }
    }
    
    // Predicts eating behavior of the ant critters.
    // Always returns eat for ants.
    public boolean eat() {
        return true;
    }
    
    // Figths with opponent critters.
    // Parameter:
    //      String opponent - the String representation of the opponent Critter.
    // Always returns the Attack SCRATCH to all types of opponents.
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }
    
    // Defines the color of the ant critters.
    // Returns red color for the ants.
    public Color getColor() {
        return Color.RED;
    }
    
    // Defines the string representation of the ant critter.
    // Returns % - symbol for the ants.
    public String toString() {
        return "%";
    }
}