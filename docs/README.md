# LPOO_T6G4 - ASCII Valley

**ASCII Valley** is a simplified text-based adaptation of the indie simulation role-playing video game Stardew Valley with some influences of
 Dwarf Fortress when it comes to the visual details;
the player takes on the role of a character who takes charge of his deceased grandfather's abandoned farm located in a site named Stardew Valley.
Planting and harvesting crops and fighting off mummies are some of the things that will make you play ASCII Valley for hours on end!

This project was developed by Joao Sousa (up201806613@fe.up.pt) 

and Rafael Ribeiro (up201806330@fe.up.pt)
 
for LPOO 2019⁄20
 
 
## Implemented Features

### Map Saving
Storing of map state in a save file. The map is divided in chunks and each chunk's data is divided in 4 parts: an ID, the IDs of it's neighbor 
chunks, a matrix that references the ground "type" and another that references the entity on said tile, if it exists. 
The interpretation of these values is intentionally hardcoded, since these save files are only edited and accessed by the game.
### Map visualization
Displaying of the chunk where the player is located, terrain and map entities included.

![Basic Map and Player Drawing - figure 1](./screenshots/mapVisualization.png)

### Movement
As of now, the player can move around the current map chunk, colliding with the map entities that are supposed to be solid.
### Movement between chunks. 
When the player goes beyond an "edge" of a chunk it moves to the respective neighbour chunk.

![Chunk Transition Previous - figure 2](./screenshots/movement.gif)

### Enemies and their "behaviour".
The enemy entities (Mummies) have different behaviour depending on how close they are to the player,
determining their next movement based on it.

![Mummy Behaviour Passive - figure 3](./screenshots/mummyBehaviour1.png)

![Mummy Behaviour Passive - figure 4](./screenshots/mummyBehaviour2.png)

### Combat 
Melee combat based on the hero project of the practical classes will be the way for the player to combat the enemies.

### Main menu
The starting point of the game is a menu that presents the player with options to load the game, see the game controls and quit.

![Main menu Mock-up - figure 5](./screenshots/mainMenuMockup.png)

### GUI 
In the form of a player toolbar that holds the players' tools, that allow the player to interact with specific parts of the game,
and also the items collected through said interactions.

![GUI Mock-up - figure 6](./screenshots/guiMockup.png)


## Desired Features
This section lists functionalities that were thought up in the start of the project and were
not be achieved in the time frame we had.

### Day-night Cycle, that visually alters the map.

### Simple NPC system with item delivery missions.


## Design

### 1. MVC

#### **Problem in Context**
At the start of the project, even before writing any lines of code, while drafting a general idea of the project it became clear that
file organization would have to be one of the foundations in order to find quickly what we are looking for and, in general, to have a good
development process.

#### **The Pattern**

Therefore we chose to use the architectural pattern known as **MVC**: Model-View-Controller. It divides the application in three parts, 
allowing for separation in groups of functions according to their role and by extension allowing also better function separation/organization.


#### **Implementation**
We started off by creating a GameController class in charge of holding a MapView and EntityView classes. 
From here it will be easy to implement new features on the Player and Entity end, but also to easily grow the input actions.   

![mvc](umls/mvc.png)

[//]: # (This uml represents the current primitve setup, it will be altered along the line, especially on the subject of
entities besides the player.)

#### **Consequences**

**Benefits:**
- ease of working simultaneously in the same project without interfering with each other's work.
- allows for a higher degree of cohesion. Methods that perform actions of the same "domain" are grouped together. For example, the
 files [ChunkView.java](../src/main/java/com.g64.view/ChunkView.java), [MapView.java](../src/main/java/com.g64.view/MapView.java) and [EntityView.java
 ](../src/main/java/com.g64.view/EntityView.java) that deal which tasks are related to data displaying all belong to the package `com.g64.view`.
- possibly faster development speed in the long run due to the consistent organization.

**Liabilities:**
- requires a higher number of files that can build up over time with the increase of the project's complexity.


### 2. Command
#### **Problem in Context**
After initially writing in the reading of keyboard inputs, it was clear the "switch" approach was messy and 
did not scale properly. Also the need for enemies with behaviour similar to the players' made this pattern fit very well.
Later on, a game state related situation came up, more precisely related with the ``menuGameState``.
The menu had three possible options: "Play", "Controls" and "Quit" and by selecting a certain option the player would get different outcomes and 
implementing every outcome within the ``menuGameState`` didn't look like the best option.

#### **The Pattern**
The **Command** pattern consists of parameterizing clients with different requests, in our case, the player, enemy and menu actions.  

#### **Implementation**
This was done in the form of an **Action** interface and several commands that are executed when appropriate. 
Namely, the [Move](../src/main/java/com/g64/controller/action/MoveDown.java) family of actions, responsible for movement and collision checking of the "invoker" entity.

![action](umls/action.png)

In the [MenuGameState](../src/main/java/com/g64/model/gameState/MenuGameState.java) class, this pattern is present within the list of ``menuOptions``.
Each ``menuOption`` has a String associated with it as well as a ``MenuCommand`` implementation, which is the element that effectively knows how to execute the ``menuOption``'s action.

#### **Consequences**
The code in the com.g64.controller is much easier to read and also proved to make the scaling of the inputs easier, 
especially alongside the pattern next described.


### 3. State
#### **Problem in Context**
Having started by implementing the game itself, we came across difficulties when trying to incorporate other parts of the game, highlighting the menu that appears at the start.
The different game "states" and the transitions (finite-state machine) between them were mostly dealt with by using a switch statement in the start function of the game controller.

```java
enum gameStates {
    MAIN_MENU, CONTROLS, IN_GAME;
}

public void start() {
    while (running){
        switch (gameState) {
            case MAIN_MENU:
                // (...)
                break;

            case CONTROLS:
                // (...)
                break;

            case IN_GAME:
                // (...)    
                break;
        }
    }
}
```

This first solution was obviously not optimal: the function was becoming unnecessarily long and in case of a new possible game state the enum gameStates and the function start would need to be changed (adding another case to the switch statement), for example.

#### **The Pattern**
The pattern **State** was the chosen one. It lets an object change its behavior depending on its internal state and is a way of implementing a finite-state machine making it highly appropriate for the situation.

#### **Implementation**
The game controller keeps track of the current state of the game which can be changed according to the player input.
Each possible ``GameState`` implements an ``execute`` (which calls the necessary draw functions) and ``processKey`` functions (which processes the player's key presses), allowing different funcionalities for a same key press depending on the context
and transitions between states.

![action](umls/stateGame.png)

#### **Consequences**
This pattern helped reducing the clutter and size of ``start`` function of [GameController](../src/main/java/com/g64/controller/GameController.java) (it is now about 5 times smaller than previously) 
and made it possible to easily add afterwards a [DeadPlayerState](../src/main/java/com/g64/model/gameState/DeadPlayerState.java) 
(for when the player dies), improving consequentially the maintainability and readability of the code.

### 4. Factory
#### **Problem in Context**
Near the start of the project, while implementing the way the game translated the save file into the corresponding objects, it became clear that the lazy approach
of just a switch was messy. Later, with the addition of enemies and the need for these to be created on demand by the specifi chunks,
this method also fit well.

#### **The Pattern**
The **Factory** pattern, capable of creating objects of unspecified classes, saved us the use of messy constructors and unmaintainable switch cases.

#### **Implementation**
On the case of the [MapTerrain](../src/main/java/com/g64/model/terrain/MapTerrain.java) objects, that hold the information of each ground type, the implementation of the [MapTerrainFactory](../src/main/java/com/g64/model/terrain/MapTerrainFactory.java) was straightforward,
since the translation of save file to object is hard coded.

![factoryTerrain](umls/factoryTerrain.png)

Similarly, the [EnemyFactory](../src/main/java/com/g64/model/entities/enemy/EnemyFactory.java) simply constructs an enemy at a random position of the map, being called 
by the ChunkModel whenever there is a need to add an enemy to a chunk. 

![factoryEnemy](umls/factoryEnemy.png)

#### **Consequences**
This pattern helped by decoupling the creation of these entities from the classes that hold them, improving readability as well. 
We didn't implement other types of enemies besides [Mummies](../src/main/java/com/g64/model/entities/enemy/Mummy.java)
but this could easily be expanded on with this pattern.

### 5. Visitor
#### **Problem in Context**
When implementing the usage of different tools and items by the player, we soon realized that these
varied a lot depending on the parts of the map they interacted with ([Axe](../src/main/java/com/g64/model/items/tools/Axe.java) 
interacts with both [Enemies](../src/main/java/com/g64/model/entities/enemy/Enemy.java) and [MapEntities](../src/main/java/com/g64/model/entities/map/MapEntity.java) ; 
[Hoe](../src/main/java/com/g64/model/items/tools/Hoe.java) interacts with [MapTerrain](../src/main/java/com/g64/model/terrain/MapTerrain.java)).
In an initial phase, this led to the use of **instanceof** operations to quickly determine if the action would be accepted on said "Target", something that clearly goes against polymorphism. 

#### **The Pattern**
Thus the use of the visitor pattern was a solution we found, since it consists of separating the actions done by the items from their classes, following the open/closed principle.

#### **Implementation**
By creating a class [TargetVisitor](../src/main/java/com/g64/model/entities/visitors/TargetVisitor.java) with functions 
[allowUsage(Item item)](../src/main/java/com/g64/model/entities/visitors/TargetVisitor.java) accepting all possible "interactable" items.
Alongside these, all items also implement an [accept(TargetVisitor targetVisitor)](../src/main/java/com/g64/model/items/tools/Hoe.java) method, which consists of calling the visitor's method corresponding to itself.
The process of getting the map objects from the position that was interacted with, deciding which objects to evaluate and effectively cause changes to these are all handled by the visitor. 

![visitor](umls/visitor.png)

#### **Consequences**
This makes the code on the the [Interact](../src/main/java/com/g64/controller/action/InteractDown.java) actions more readable, since the handling of the item is done entirely by this new class.
However, this also has its' downsides: the creation of new items is less intuitive, and in a game like ours would, in the long run, be hindering.
Despite helping us remove a lot of the smelly **instanceof** calls, we were not able to completely rid this part of our code from them.  


[//]: # (This section should be organized in different subsections, each describing a different design problem that you had to solve during the
project. Each subsection should be organized in four different parts:
Problem in Context: The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When
refering to the implementation before the pattern was applied, don’t forget to link to the relevant lines of code in the appropriate version.
The Pattern: Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing
design context and the problem at hand.
Implementation: Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it
with a UML class diagram, and refer to the corresponding source code with links to the relevant lines, these should be relative links. When doing this, always point to the latest version of the code.
Consequences: Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with
 those of alternative solutions.)


## Known Code Smells And Refactoring Suggestions

SMELLS
(- Pair Enemy.java / SeedEntity.java / UpdatableEntity.java / MapModel.java not defined)
- Mummy.java State for Mummy humor
(- Switch in MapEntityFactory/MapTerrainFactory due to the factory design pattern)

### 1. Bloater - Long Method

#### **Problem in Context**
Evidently, the function that sticks out the most as being too long is the readMap method,
in charge of porting the map information from the .csv file to the Map object.

#### **Solution**
Even after multiple uses of the **Extract Method**, it can still be considered too long,
mostly because of the mess of code in charge of opening and reading the file itself.

### 2. Object-Orientation Abuser - Switch Statement

#### **Problem in Context**
In the [GameController](../src/main/java/com.g64.controller/GameController.java) file, in function ``start``,
there is a Switch statement for the variable ```gameState``` that differentiates what to display on the screen,
implementing a basic State Machine.

#### **Solution**
Using the **State Design Pattern**, each different game state could be a class that implements the ``GameState`` interface,
simplifying the code of the ``start`` function and improving readability.

### 3. Dispensable - Duplicate Code

#### **Problem in Context**
In the same file and function, there is a Switch statement for the variable GameState that differentiates what to display on the screen.
On each case, there are calls for the functions `processPlayerAction()` (and `getActionEventFromKeyboard())`),
``mapView.getScreen().refresh()`` and `Thread.sleep()`.

#### **Solution**
Creating a method that calls that set of functions or just moving those function calls to after the end of the Switch statement
should reduce considerably the size of the function without introducing any bugs.


## Testing
![Coverage1](screenshots/lpoo_code_coverage1.png)

![Coverage2](screenshots/lpoo_code_coverage2.png)

## SELF-EVALUATION

50% Rafael Ribeiro
50% Joao Sousa

