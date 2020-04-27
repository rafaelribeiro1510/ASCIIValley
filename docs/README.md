# LPOO_T6G? - ASCII Valley

ASCII Valley is a simplified text-based adaptation of the indie simulation role-playing video game Stardew Valley in which the player takes on the role of a character who takes charge of his deceased grandfather abandoned farm located in a site named Stardew Valley.
Planting and harvesting crops and fighting off insects are some of the things that will make you play ASCII Valley for hours on end!
This project was developed by João Sousa (up201806613@fe.up.pt) and Rafael Ribeiro (up201806330@fe.up.pt) for LPOO 2019⁄20.

## Implemented Features

- Storing of map state in a save file. The map is divided in chunks and each chunk's data is divided in 4 parts: chunk ID, neighbour chunks (IDs), 
- Displaying of the map and entities (currently only the player).
- Entities' Movement. For now the only entity is the player which can be moved using the Arrow Keys. 
[This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.]

## Planned Features

- Movement between chunks. When the player goes beyond an "edge" of a chunk it should move to the respective neighbour chunk (drawing the new chunk in the place of the previous one).
- Other Entities (Insects, for example).
- Combat (melee based on the hero project of the practical classes).
- Farming: "creating" farmland, planting, plant "development", harvesting.
[This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.]

## Design

This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:
- **Problem in Context**. The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to link to the relevant lines of code in the appropriate version.
- **The Pattern**. Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation**. Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be relative links. When doing this, always point to the latest version of the code.
- **Consequences**. Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

## Known Code Smells And Refactoring Suggestions

[This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.]


## SELF-EVALUATION

50% Rafael
50% João

[In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.]