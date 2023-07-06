# FACADE DESIGN PATTERN

// Client can easily use the service , 
// Easy to use Interfaces
// Easy imolementation of a facet
reducing the number of functionalities accessed by the clients
FACET --> FRONT-END EXECUTIVE --> masking something and hiding the working and functionalities fro the end user


## Introduction

Facade is a part of the Gang of Four design patterns and it is categorized under Structural design patterns. Before we dig into the details of it, let us discuss some examples which will be solved by this particular Pattern. So, As the name suggests, it means the face of the building. The people walking past the road can only see the glass face of the building. They do not know anything about it, the wiring, the pipes, and other complexities. It hides all the complexities of the building and displays a friendly face.


## When Should this pattern be used?

The facade pattern is appropriate when you have a complex system that you want to expose to clients in a simplified way, or you want to make an external communication layer over an existing system that is incompatible with the system. Facade deals with interfaces, not implementation. Its purpose is to hide internal complexity behind a single interface that appears simple on the outside.   