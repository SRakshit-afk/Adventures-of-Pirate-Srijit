
# 🏴‍☠️ Adventures of Pirate Srijit

Java
Game Type: Top-Down RPG
Platform: Desktop

A classic top-down tile-based 2D adventure game built using **Java Swing**. Navigate through a procedurally generated world, explore diverse terrain, and avoid obstacles using real-time collision detection.

---

## 🌍 Features

- 🎮 Keyboard-controlled player movement (WASD)
- 🧱 Tile-based terrain and collision system
- 🎞️ Directional player sprite animations
- 🗺️ Map rendering based on camera/player position
- 🧠 Procedural terrain generation using Perlin noise (Python)
- 🧱 Walls automatically placed on borders for structure
<!-- - 📦 Ready for packaging as an executable `.jar` -->

---

## 📸 Preview

> *(Replace this with a real screenshot once you run the game)*

![Preview](assets/screenshot.png)

---

## 🧩 Controls

| Key | Action    |
|-----|-----------|
| W   | Move Up   |
| A   | Move Left |
| S   | Move Down |
| D   | Move Right |

---

## 🗺 Tile Legend

| Tile | Type      | Collision |
|------|-----------|-----------|
| 0    | Grass     | ❌        |
| 1    | Wall      | ✅        |
| 2    | Water     | ✅        |
| 3    | Dirt Path | ❌        |
| 4    | Sand      | ❌        |
| 5    | Tree      | ✅        |

---

## 📁 Project Structure

```
AdventureGame/
├── AdventureGame/             # Core game logic
├── entity/                    # Player + entity classes
├── tile/                      # Tile & map manager                
├── maps/                      # All images and maps
├── tiles/
└── srijit/            
├── generate_map.py            # Python script for generating map
├── assets/                    # Screenshots or extra visuals
│   └── screenshot.png
└── README.md
```

---

## 🚀 Getting Started

### Requirements

- Java 8 or higher
- Python 3.8+ (for map generator)
- IDE (IntelliJ / VS Code) or terminal

---

### 🎮 Run the Game (Java)

#### Option 1: Compile and Run from Terminal
```bash
javac AdventureGame/*.java
java AdventureGame.Main
```

#### Option 2: Run from IDE
- Open project folder in IntelliJ/VS Code
- Run `AdventureGame.Main`

---

### 🌍 Generate a Map (Python)

1. Install dependencies:
```bash
pip install perlin-noise numpy
```

2. Run the script:
```bash
cd map_generator/
python generate_map.py
```

3. Move the output `map.txt` to:
```
resources/maps/map01.txt
```

---

## 🧱 Collision System

- Uses a rectangular `solidArea` on the player
- `CollisionChecker` detects tile-based collisions
- Any tile with `collision = true` is treated as an obstacle

---


## ✅ TODO / Ideas

- [ ] Treasure chests and quest system
- [ ] Menu, pause, and HUD
- [ ] Save/load system
- [ ] Audio support (BGM + SFX)

---


## 👨‍💻 Author

Developed by **Srijit**  
Pirate, coder, and game dev enthusiast 🏴‍☠️
