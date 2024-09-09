// Defines behavior of vulture critters.
// Constuctor - defines a Vulture.
// Behavior:
//      Movement - A vulture moves three times north, then  three times east, then three times
//          south, then three times west, then repeat(default behavior).
//      Eating - A vulture eats the first food encountered after being created or after each fight.
//      Fighting - A vulture ROAR if the opponent is an Ant, and POUNCE
//          otherwise in a fight (default behavior).
//      Color - A vulture is colored black.
//      String - A vulture is displayed by the symbol ^ - symbol if last move of vulture was north,
//          or never has never moved, > - symbol if last move of vulture was east,
//          V - letter if last move of vulture was south,
//          < - symbol if last move of vulture was west (default behavior).
import java.awt.*;

public class Vulture extends Bird {
    private boolean isHungry;       // Represents if vulture is hungry or not.
    
    // Constructs a new Vulture.
    public Vulture() {
        isHungry = true;
    }
    
    // Predicts eating behavior of the vulture critters.
    // A vulture eats the first food encountered after being created or after each fight.
    // Returns false if vulture is not hungry, and returns true if vulture is hungry.
    public boolean eat() {
        if (isHungry) {
            isHungry = false;
            return true;
        }
        return false;
    }
    
    // Fights with opponent critters.
    // Parameter:
    //      String opponent - the String representation of the opponent Critter.
    // Returns the default behavior of super class Bird, aka
    // Returns as the Attack ROAR or POUNCE based on the opponent:
    // will ROAR if the opponent is an Ant, and POUNCE otherwise.
    public Attack fight(String opponent) {
        isHungry = true;
        return super.fight(opponent);
    }
    
    // Defines the color of the vulture critters.
    // Returns black color for the vulture.
    public Color getColor() {
        return Color.BLACK;
    }
}