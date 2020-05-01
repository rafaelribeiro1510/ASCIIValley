# LPOO_T6G4 - ASCII Valley

ASCII Valley is a simplified text-based adaptation of the indie simulation role-playing video game Stardew Valley with some influences of
 Dwarf Fortress when it comes to the visual details;
the player takes on the role of a character who takes charge of his deceased grandfather abandoned farm located in a site named Stardew Valley.
Planting and harvesting crops and fighting off mummies are some of the things that will make you play ASCII Valley for hours on end!
This project was developed by Joao Sousa (up201806613@fe.up.pt) and Rafael Ribeiro (up201806330@fe.up.pt) for LPOO 2019⁄20.

## Implemented Features

###Map Saving
Storing of map state in a save file. The map is divided in chunks and each chunk's data is divided in 4 parts: an ID, the IDs of it's neighbor 
chunks, a matrix that references the ground "type" and another that references the entity on said tile, if it exists. 
The interpretation of these values is intentionally hardcoded, since these save files are only edited and accessed by the game.
###Map visualization
Displaying of the chunk where the player is located, terrain and map entities included - [Basic Map and Player Drawing - figure 1](./screenshots/basicMapAndPlayerDrawing.png)
###Movement
As of now, the player can move around the current map chunk, colliding with the map entities that are supposed to be solid.


[This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three
 screenshots that illustrate the most important features.]

## Planned Features

- Movement between chunks. When the player goes beyond an "edge" of a chunk it should move to the respective neighbour chunk.
- Other Entities (Mummies, for example) and their "behaviour".
- Combat (melee based on the hero project of the practical classes).
- Save game, Load Game.
- Player interaction with other entities, namely breaking blocks, toiling soil and planting seeds.
- GUI with player toolbar that holds the players' tools and collected items.

[This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should
 include GUI mock-ups for the planned features.]

## Desired Features

- Day-night Cycle, that visually alters the map.

[This section, unlike the last one, lists functionalities that were thought up in the start of the project but realistically will not be achieved in the time frame we have.]

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

#### **Consequences**

Benefits:
- ease of working simultaneously in the same project without interfering with each other's work.
- allows for a higher degree of cohesion. Methods that perform actions of the same "domain" are grouped together. For example, the
 files [ChunkView.java](../src/main/java/view/ChunkView.java), [MapView.java](../src/main/java/view/MapView.java) and [EntityView.java
 ](../src/main/java/view/EntityView.java) that deal which tasks are related to data displaying all belong to the package view.
- possibly faster development speed in the long run due to the consistent organization.


Liabilities:
- requires a higher number of files that can build up over time with the increase of the project's complexity.

 

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


## Known Code Smells And Refactoring Suggestions

### Long Method

#### **Problem in Context**
Evidently, the function that sticks out the most as being too long is the readMap method,
in charge of porting the map information from the .csv file to the Map object.

#### **Solution**
Even after multiple uses of the **Extract Method**, it can still be considered too long,
mostly because of the mess of code in charge of opening and reading the file itself.

### OOP Abuser - Switch statements

#### **Problem in Context**
On various parts of the map interpretation process are present switch cases, in charge
of appropriately assigning the terrain and entities' attributes.

#### **Solution**
Since these are present on very simple classes, they can be removed by using the **Replace Conditional with Polymorphism** method, by creating different subclasses
of these attribute classes that can later be improved upon. This applies namely to the MapEntityModel and CSVColors classes.



[This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in
 which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.]


## SELF-EVALUATION

50% Rafael Ribeiro
50% Joao Sousa

[In this section describe how the work regarding the project was divided between the students. In the event that members of the group do
 not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.]
