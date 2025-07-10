#  Adventures of Pirate Srijit

**Adventures of Pirate Srijit** is a classic top-down 2D tile-based adventure game built from scratch in Java using Swing and AWT. You play as Pirate Srijit exploring islands, collecting keys, unlocking doors, and navigating the terrain — all while avoiding natural and tile-based obstacles.

> 🎮 Made entirely with core Java, no external game engines!

---

## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Game Structure](#game-structure)
- [Installation](#installation)
- [Controls](#controls)
- [Map Format & Python Tool](#map-format--python-tool)
- [Planned Features](#planned-features)

---

## Features

- ✅ Smooth character movement with animated sprites
- ✅ Tile-based world rendering with camera follow
- ✅ Real-time collision detection with walls, water, and trees
- ✅ Key-door system with chest collection
- ✅ External map support (`map01.txt`)
- ✅ Python-based map auto-generator
- ✅ Modular structure for future expansions

---

## Screenshots

> Add gameplay GIF or screenshot here

![Gameplay Screenshot](res/screenshots/sample.png)

---

## Game Structure

### Project Layout

```
Adventures-of-Pirate-Srijit/
│
├── AdventureGame/         # Core game loop, main frame, input handling
├── entity/                # Player and entity management
├── tile/                  # Tile rendering and map loading
├── Objects/               # Object classes: keys, chests, doors
├── res/                   # Sprites, tile images, and map text file
│   ├── maps/
│   ├── tiles/
│   ├── objects/
│   └── srijit/
├── map_generator.py       # Python tool to auto-generate map files
├── README.md
└── Main.java
```

---

## Installation

### Requirements

- Java JDK 17+
- A Java-compatible IDE (IntelliJ, VS Code, Eclipse) or command line

### Running the Game

#### Method 1: From IDE

1. Open project in IntelliJ or VS Code.
2. Ensure `res/` is in classpath (as a resource folder).
3. Run `Main.java`.

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

### Python Map Generator

A custom Python tool (`map_generator.py`) is provided to auto-generate random or Perlin-style maps to speed up world creation.

---

## Packaging Plans

Currently, the game is distributed as a perosnal project as `.java` source code.

✅ In future releases:
- A `.jar` build will be included
- A `.exe` file (using Launch4j or jpackage) will be provided for Windows users

---

## 🧑‍💻 Author

**Srijit Rakshit**: Gamer, coder, and game dev enthusiast, Photographer
- GitHub: [@SRakshit-afk](https://github.com/SRakshit-afk)

---
