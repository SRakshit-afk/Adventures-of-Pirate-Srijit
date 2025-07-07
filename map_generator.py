# Use perlin-like Noise simulation for generating maps and cluster similar tiles together for natural look
#Remember: After generating the text file please choose the location of final chest and create a room with walls (Tile 1)
# Tile Legend
# 0 - Grass, 1 - Wall, 2 - Water, 3 - Dirt, 4 - Sand, 5 - Tree

from perlin_noise import PerlinNoise
import numpy as np
import random

# Settings
width = 50
height = 50
scale = 20.0        # Controls terrain feature size
octaves = 4         # Number of layers of noise
seed = random.randint(0, 99999)
output_file = "map.txt"

# Perlin Noise for terrain and path generation
terrain_noise = PerlinNoise(octaves=octaves, seed=seed)
path_noise = PerlinNoise(octaves=2, seed=seed + 999)

# Generate 2D map
def generate_map():
    map_array = np.zeros((height, width), dtype=int)
    for y in range(height):
        for x in range(width):
            # Border walls
            if x == 0 or x == width - 1 or y == 0 or y == height - 1:
                tile = 1  # Wall
            else:
                # Terrain base
                t_val = (terrain_noise([x / scale, y / scale]) + 1) / 2
                p_val = (path_noise([x / (scale/2), y / (scale/2)]) + 1) / 2

                # Terrain generation with increased forest frequency
                if t_val < 0.25:
                    tile = 2  # Water
                elif t_val < 0.35:
                    tile = 4  # Sand
                elif t_val < 0.55:
                    tile = 0  # Grass
                elif t_val < 0.80:
                    tile = 5  # Tree
                elif t_val < 0.9:
                    tile = 0  # Grass patch
                else:
                    tile = 1  # Wall / Mountain

                # Add dirt paths inside forests or grasslands
                if tile in [0, 5] and 0.45 < p_val < 0.52:
                    tile = 3  # Dirt path

            map_array[y][x] = tile
    return map_array

# Save map to text file
def save_map_to_file(map_array, filename):
    with open(filename, 'w') as f:
        for row in map_array:
            line = ' '.join(str(cell) for cell in row)
            f.write(line + '\n')
    print(f"Map saved to '{filename}'")

# Main
if __name__ == "__main__":
    print(f"Using seed: {seed}")
    map_array = generate_map()
    save_map_to_file(map_array, output_file)
