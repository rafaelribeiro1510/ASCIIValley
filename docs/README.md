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

![Basic Map and Player Drawing - figure 1](./screenshots/basicMapAndPlayerDrawing.png)

### Movement
As of now, the player can move around the current map chunk, colliding with the map entities that are supposed to be solid.
### Movement between chunks. 
When the player goes beyond an "edge" of a chunk it moves to the respective neighbour chunk.

![Chunk Transition Previous - figure 2](./screenshots/movement.gif)

### Enemies and their "behaviour".
The enemy entities (Mummies) have different behaviour depending on how close they are to the player,
determining their next movement based on it.

### Combat 
Melee combat based on the hero project of the practical classes will be the way for the player to combat the enemies.

### Main menu
The starting point of the game is a menu that presents the player with options to load the game, see the game controls and quit - ![Main menu Mock-up - figure 3](./screenshots/mainMenuMockup.png)

### GUI 
In the form of a player toolbar that holds the players' tools, that allow the player to interact with specific parts of the game,
and also the items collected through said interactions. ![GUI Mock-up - figure 4](./screenshots/guiMockup.png)

## Planned Features

All Planned Features have been implemented.

## Desired Features
This section, unlike the last one, lists functionalities that were thought up in the start of the project but realistically will 
not be achieved in the time frame we have.

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

![mvc](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/FEUP-LPOO/lpoo-2020-g64/master/docs/umls/mvc.iuml?token=AK5LFP5ZIWNVWUXW5O6BNEK6XAWHI)

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


### 2. Actions
#### **Problem in Context**
After initially writing in the reading of keyboard inputs, it was clear the "switch" approach was messy and 
did not scale properly.

#### **The Pattern**
Thus, the **Command** pattern was implemented, since it parametrizes clients with different requests, in our case, the player actions.  

#### **Implementation**
This was done in the form of an **Action** interface and several commands that are executed when appropriate. 

![action](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/FEUP-LPOO/lpoo-2020-g64/master/docs/umls/action.iuml?token=AK5LFP4RSKI6DRLWYPNPMES6XAWG6)

#### **Consequences**
The code in the com.g64.controller is much easier to read and it is also now easy to scale the input interface with new key inputs and subsequent actions.


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
- Metodos na position que recebem width e height
(- Pair Enemy.java / SeedEntity.java / UpdatableEntity.java / MapModel.java not defined)
- Mummy.java State for Mummmy humor
(- Switch in MapEntityFactory/MapTerrainFactory due to the factory design pattern)
- Target.java - metodos muito parecidos repetidos?
- Position.java 

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

