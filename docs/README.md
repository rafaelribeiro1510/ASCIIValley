# LPOO_T6G4 - ASCII Valley

ASCII Valley is a simplified text-based adaptation of the indie simulation role-playing video game Stardew Valley with some influences of
 Dwarf Fortress when it comes to the visual details;
the player takes on the role of a character who takes charge of his deceased grandfather abandoned farm located in a site named Stardew Valley.
Planting and harvesting crops and fighting off mummies are some of the things that will make you play ASCII Valley for hours on end!
This project was developed by Joao Sousa (up201806613@fe.up.pt) and Rafael Ribeiro (up201806330@fe.up.pt) for LPOO 2019⁄20.

## Implemented Features

### Map Saving
Storing of map state in a save file. The map is divided in chunks and each chunk's data is divided in 4 parts: an ID, the IDs of it's neighbor 
chunks, a matrix that references the ground "type" and another that references the entity on said tile, if it exists. 
The interpretation of these values is intentionally hardcoded, since these save files are only edited and accessed by the game.
### Map visualization
Displaying of the chunk where the player is located, terrain and map entities included - [Basic Map and Player Drawing - figure 1](./screenshots/basicMapAndPlayerDrawing.png)
### Movement
As of now, the player can move around the current map chunk, colliding with the map entities that are supposed to be solid.
###Movement between chunks. 
When the player goes beyond an "edge" of a chunk it moves to the respective neighbour chunk.

[This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three
 screenshots that illustrate the most important features.]

## Planned Features

###Other Entities and their "behaviour".
The game needs more ways of interacting with the player and this will be achieved with enemy entities (Mummies, for example)
that present simple aggressive behaviour.
###Combat 
Melee combat based on the hero project of the practical classes will be the way for the player to combat the enemies.
###Main menu
The starting point of the game will be a menu that presents the player with options to load the game and see game controls.
###GUI 
In the form of a player toolbar that holds the players' tools, that allow the player to interact with specific parts of the game,
and also the items collected through said interactions.

[This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should
 include GUI mock-ups for the planned features.]

## Desired Features

Day-night Cycle, that visually alters the map.

[This section, unlike the last one, lists functionalities that were thought up in the start of the project but realistically will 
not be achieved in the time frame we have.]

## Design

### 1. MVC

#### **Problem in Context**
At the start of the project, even before writing any lines of code, while drafting a general idea of the project it became clear that
file organization would have to be one of the foundations in order to find quickly what we are looking for and, in general, to have a good
development process.

#### **The Pattern**

Therefore we chose to use the architectural pattern known as MVC: Model-View-Controller. It divides the application in three parts
, allowing for separation in groups of functions according to their role and by extension allowing also better function separation
/organization.


#### **Implementation**
We started off by creating a GameController class in charge of holding a MapView and EntityView classes. 
From here it will be easy to implement new features on the Player and Entity end, but also to easily grow the input actions.   

```puml
@startuml Command
interface ActionEvent{
    execute()
}
class MoveDown{
    execute()
}
class MoveRight{
    execute()
}
class QuitGame{
    execute()
}

ActionEvent <|-- MoveDown
ActionEvent <|-- MoveRight
ActionEvent <|-- QuitGame
@enduml
```

#### **Consequences**

**Benefits:**
- ease of working simultaneously in the same project without interfering with each other's work.
- allows for a higher degree of cohesion. Methods that perform actions of the same "domain" are grouped together. For example, the
 files [ChunkView.java](../src/main/java/view/ChunkView.java), [MapView.java](../src/main/java/view/MapView.java) and [EntityView.java
 ](../src/main/java/view/EntityView.java) that deal which tasks are related to data displaying all belong to the package view.
- possibly faster development speed in the long run due to the consistent organization.

**Liabilities:**
- requires a higher number of files that can build up over time with the increase of the project's complexity.


###2. Actions
#### **Problem in Context**
After initially writing in the reading of keyboard inputs, it was clear the "switch" approach was messy and 
not scale properly.

#### **The Pattern**
Thus, the **Command** pattern was implemented, since it parametrizes clients with different requests, in our case, the player actions.  

#### **Implementation**
This was done in the form of an **Action** interface and several commands that are executed when appropriate. 

#### **Consequences**
The code in the controller is much easier to read and it is also now easy to scale the input interface with new key inputs and subsequent actions.


[comment]: <> (This section should be organized in different subsections, each describing a different design problem that you had to solve during the
 project. Each subsection should be organized in four different parts:
- **Problem in Context**. The description of the design context and the concrete problem that motivated the instantiation of the pattern
. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When
 refering to the implementation before the pattern was applied, don’t forget to link to the relevant lines of code in the appropriate
  version.
- **The Pattern**. Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing
 design context and the problem at hand.
- **Implementation**. Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it
 with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be relative links
 . When doing this, always point to the latest version of the code.
- **Consequences**. Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with
 those of alternative solutions.)


## Known Code Smells And Refactoring Suggestions - TODO: "homogeneizar" esta parte melhor

### 1. Long Method

#### **Problem in Context**
Evidently, the function that sticks out the most as being too long is the readMap method,
in charge of porting the map information from the .csv file to the Map object.

#### **Solution**
Even after multiple uses of the **Extract Method**, it can still be considered too long,
mostly because of the mess of code in charge of opening and reading the file itself.

### 2. OOP Abuser - Switch statements

#### **Problem in Context**
On various parts of the map interpretation process are present switch cases, in charge
of appropriately assigning the terrain and entities' attributes.

#### **Solution**
Since these are present on very simple classes, they can be removed by using the **Replace Conditional with Polymorphism** method, by creating different subclasses
of these attribute classes that can later be improved upon. This applies namely to the MapEntityModel and CSVColors classes.

### 3. OOP Abuser - If Statements

#### **Problem in Context**
The [PlayerModel](../src/main/java/model/PlayerModel.java) class has in its updatePosition function four long if statements that only differ a few words between them.
This results in code that is harder to read and debug and that can be a source of issues in the future if a single word in one of the if statements is misspelled.
For example: if one by mistake changes ``this.getPosition().down()`` (line 15) to ``this.getPosition().up()`` at first sight it may go unnoticed and afterwards cost an unnecessary waste of time when the bug is detected.

#### **Solution**
One way to improve this code would be to have a function with the name for example "move" associated with each of the elements of the ``enum COMMAND`` of the class [GameController](../src/main/java/controller/GameController.java) 
that would be called inside a single ```if (canMove(command, mapModel))``` condition in the function updatePosition, implementing in some way the idea of the Strategy Pattern.


### 4. Dispensable - Data Class

#### **Problem in Context**
In the [MapEntityModel](../src/main/java/model/MapEntityModel.java) file there is an auxiliary class ``myPair`` (lines 10-18) that is only used to "group" data (data class).
Even though its existence is, in our opinion, justified by its usage in the ``MapEntityModel`` class (groups a ``TextColor`` and a ``boolean``), its implementation can be improved.

#### **Solution**
In order to increase encapsulation, the auxiliary class could be declared as `final`, all its fields as `private final` and by adding getters, or even maybe by nesting the class inside ``MapEntityModel``.  


### 5. Object-Orientation Abuse - Switch

#### **Problem in Context**
The method `canMove` in class [MovableEntityModel](../src/main/java/model/MovableEntityModel.java) has a ``switch`` statement whose cases have high number of similarities between them, only changing one of the arguments in each one, making 
the code less readable and (even if only slightly) harder to maintain.

#### **Solution**
As the code is, a plausible solution could maybe be to replace the `enum COMMAND` of the class ``GameController`` with a "Factory" class who would have subclasses (directions of movement) which implemented a kind of "getEntity" method, making use of the Factory Method Pattern.
However, because this Code Smell is related with other code smells (such as the number 5 and somewhat also with number 1) and because the usage of the Factory Method Pattern in this situation may be considered forced, only when we start trying to correct this code smell can we infer if it is or not 
actually the solution that makes the most sense for this case.


### 6. Bloater - Data Clump (width and height variables exist both on ChunkModel and MapModel classes)

#### **Problem in Context**
Both [ChunkModel](../src/main/java/model/ChunkModel.java) and [MapModel](../src/main/java/model/MapModel.java) classes have two fields in common: ``private int width`` and ``private int height`` (lines 9-10 in ChunkModel and lines 21-22 in MapModel).
This situation is unnecessary due to the fact that both fields are only used outside of the class constructor in the class ChunkModel (getter of width and height - lines 33 and 37, respectively).

#### **Solution**
Therefore, they could be removed from [MapModel](../src/main/java/model/MapModel.java) which would reduce the number of parameters of this class's constructor.
Furthermore, because the ``width``and ``height`` fields have constant values (the only values that are passed to them are ``MAP_WIDTH``and `MAP_HEIGHT``present in lines 19 and 20 of [GameController](../src/main/java/controller/GameController.java))`
those "constants" could be moved to [ChunkModel](../src/main/java/model/ChunkModel.java) and passed directly to the private field, eliminating in the class as well the need to have them in the constructor.
Despite what has been said previously, the solution presented may be subject to change if the width and height become "non-constant", i.e. if the chunks get the "ability" of having variable dimensions. 

### 7. Dispensable - Duplicate Code

#### **Problem in Context**
In the [ChunkModel](../src/main/java/model/ChunkModel.java) class there are in two occasions of two functions which have different parameters and do the same task: ``getTerrainColorAt(int x, int y)`` (line 45) and ``getTerrainColorAt(Position position)`` (line 50)
are essentially the same with the difference that in the first one the ``x`` and the ``y`` are passed directly while in the second one they are passed to the function inside a ``Position``
object. The same applies to ``getEntityAt(int x, int y)`` (line 55) and ``getEntityAt(Position position)`` (line 61).
This duplication of code could lead to time-consuming debugging caused for example by a small change only in one of the functions let's say "A1" (leaving "A2" unchanged) that could result in different outputs in situations apparently identical.

#### **Solution**
To fix this repetition of code one could delete the version of each function that has 2 parameters and where those specific "2-parameter" functions were called, pass as the argument ``new Position(x,y)``.



## SELF-EVALUATION

50% Rafael Ribeiro
50% Joao Sousa

[In this section describe how the work regarding the project was divided between the students. In the event that members of the group do
 not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.]
