# Creatures represents a graphical simulation of a 2D world of animals, known as critters. 
While it
is running, the simulation will look like the image to the right.
The client will only display the graphical output shown here and
described below; it will not produce any console output. You will
write classes that define the behavior of several types of critters,
each of which moves and behaves in different ways.

The critter world is divided into cells with integer coordinates. The world is 60 cells wide and 50 cells
tall. The upper-left cell has coordinates (0, 0); x increases to the right and y increases downward. The
world has a finite size, but it wraps around in all four directions (e.g., moving east from the right edge
brings you back to the left edge).
Critters can only make one move at
a time, and only when the simulator asks. 
# Critter Movement
The simulation takes place in a series of rounds, with each critter making a single move in each round.
Critters specify the direction they wish to move by returning one of the following values from the getMove
method (see below):
Direction Constant Description
Direction.NORTH move one cell up
Direction.SOUTH move one cell down
Direction.EAST move one cell right
Direction.WEST move one cell left
Direction.CENTER do not move; stay in the same location
# Fighting/Mating
As the simulation runs, critters may collide by moving onto the same location. When two critters collide,
if they are from different species, they fight. Each critter chooses one of Attack.ROAR, Attack.POUNCE,
or Attack.SCRATCH. Each attack is strong against one other attack (e.g. roar beats scratch) and weak
against one (e.g. roar loses to pounce) according to the following rules:
Attack.ROAR beats Attack.SCRATCH and loses to Attack.POUNCE
Attack.POUNCE beats Attack.ROAR and loses to Attack.SCRATCH
Attack.SCRATCH beats Attack.POUNCE and loses to Attack.ROAR
(To help you remember which attack beats which, notice that the starting letters of "Roar, Pounce, and
Scratch" match those of "Rock, Paper, and Scissors.") The winning critter survives and the losing critter
is killed and removed from the game. If the critters make the same choice, the winner is chosen randomly.
If two critters of the same species collide, they mate. A critter can mate only once during its lifetime.
Mating critters will not move for several rounds, after which a new "baby" critter of the same type will
be produced and begin moving around the world. Critters are vulnerable to attack while mating: they
will always lose a fight if a critter of a different type collides with them.
# Eating/Sleeping
The simulation world also contains food (represented by the period character, ".") for the critters to eat.
Food is initially placed in the world randomly, and new food is gradually added over time. As a critter
moves, it may encounter food, in which case the simulator will ask the critter whether it wants to eat.
Different kinds of critters will have different eating behavior.
Every time a critter eats a few pieces of food, that critter will be put to sleep by the simulator for a small
amount of time. While asleep, critters cannot move and will always lose fights, though they can mate if
another critter of the same type moves into their location.
# Scoring
The simulator keeps a score for each type of critter. This score is the sum of how many critters of that
type are alive, how much total food they have eaten, and how many other critters they have killed