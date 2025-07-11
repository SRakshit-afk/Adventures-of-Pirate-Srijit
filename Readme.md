#  Adventures of Pirate Srijit

**Adventures of Pirate Srijit** is a classic top-down 2D tile-based adventure game built from scratch in Java using Swing and AWT. You play as Pirate Srijit exploring islands, collecting keys, unlocking doors, and navigating the terrain — all while avoiding natural and tile-based obstacles.

> 🎮 Made entirely with core Java, no external game engines!

---

## Table of Contents

- [Features](#features)
- [Game](#game)
- [Screenshots](#screenshots)
- [Game Structure](#game-structure)
- [Installation](#installation)
- [Controls](#controls)
- [Map Format & Python Tool](#map-format--python-tool)
- [Future Plans](#Future-Plans)

---

## Features

- ✅ Smooth character movement with animated sprites
- ✅ Tile-based world rendering with camera follow
- ✅ Real-time collision detection with walls, water, and trees
- ✅ Key-door system with chest collection
- ✅ External map support (`map01.txt`)
- ✅ Python-based map auto-generator (to generate new maps but code change required)
- ✅ Modular structure for future expansions

---

## Game
- Find the treasure hidden in the vast lands
- Remember you need keys to open doors to the trasure chest
- If you are lucky, you may find a special ability to your aid

---

## Screenshots

> This is how the Game v2.3 (In development version) looks [v2.3 = Release version 1.0.0]

![Gameplay Screenshots](/res/screenshots/ssInitial.png)
![Gameplay Screenshots](/res/screenshots/ssFinal.png)
---

## Game Structure

### Project Layout

```
Adventures-of-Pirate-Srijit/
│
├── Run/                   # Contains the .exe and JRE folder
├── AdventureGame/         # Core game loop, main frame, input handling
├── build/                 # Contains just the class files
├── entity/                # Player and entity management
├── tile/                  # Tile rendering and map loading
├── Objects/               # Object classes: keys, chests, doors
├── res/                   # Sprites, tile images, and map text file
│   ├── maps/
│   ├── tiles/
│   ├── objects/
│   ├── screenshots/
│   └── srijit/
├── map_generator.py       # Python tool to auto-generate map files
├── README.md
├── Manifest.txt
├── MyGame.jar
└── Adventures Of Pirate Srijit.zip 
```

---

## Installation

### Requirements

- Java JDK 17+
- A Java-compatible IDE (IntelliJ, VS Code, Eclipse) or command line
- **Note**: As the code was developed in VS Code Editor .class files are also upload to git. Please use the .java files before recompiling

### Running the Game

#### Method 1: From Releases .zip

1. Download the .zip from Releases
2. Extract the zip files
3. Run the .exe file

#### Method 2: From Terminal

```bash
# Clone the repo
git clone https://github.com/SRakshit-afk/Adventures-of-Pirate-Srijit.git

cd Adventures-of-Pirate-Srijit

# Compile
javac AdventureGame/*.java

# Run
java AdventureGame.Main
```
#### Method 3: From IDE

1. Open project in IntelliJ or VS Code.
2. Ensure `res/` is in classpath (as a resource folder).
3. Run `Main.java`.

---

## Controls

| Key | Action       |
|-----|--------------|
| W   | Move Up      |
| A   | Move Left    |
| S   | Move Down    |
| D   | Move Right   |

---

## Map Format & Python Tool

### Map Format 

- Text-based (`map01.txt`) under `/res/maps/`
- Each number represents a tile type:

```
0 0 0 1 1 1 0 0
0 2 2 1 3 3 0 0
```

### Tile Legend

| Tile ID | Type   | Collision |
|---------|--------|-----------|
| 0       | Grass  | ❌        |
| 1       | Wall   | ✅        |
| 2       | Water  | ✅        |
| 3       | Dirt   | ❌        |
| 4       | Sand   | ❌        |
| 5       | Tree   | ✅        |

### Python Map Generator (Optional)

A custom Python tool (`map_generator.py`) is provided to auto-generate random or Perlin-style maps to speed up world creation.

---

## Packaging Plans

The game is a personal project for skill Development. It is released as an .exe file inside a .zip folder which contains /JRE (Official jdk files for java (Please use Java from Oracle Corporation for use), config.xml (From Launch4j), AdventuresOfPirateSrijit.exe

---

## 🧑‍💻 Author

**Srijit Rakshit**: 
> Gamer, coder, game dev enthusiast(and a hobby Photographer) 
- GitHub: [@SRakshit-afk](https://github.com/SRakshit-afk)

---
