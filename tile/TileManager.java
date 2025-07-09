package tile;

import AdventureGame.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TileManager (GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();

    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/dirt.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
            tile[5].collision = true;
        } catch (IOException e) {
            }
    }

    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/res/maps/map01.txt"); 
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            int col = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } 
        catch (IOException | NumberFormatException e) {
        }
    }

    public void draw(Graphics2D g2){
         int worldCol = 0;
         int worldRow = 0; 
         while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.srijit.worldX + gp.srijit.screenX;
            int screenY = worldY - gp.srijit.worldY + gp.srijit.screenY;

            if(worldX + gp.tileSize> gp.srijit.worldX - gp.srijit.screenX && 
               worldX - gp.tileSize< gp.srijit.worldX + gp.srijit.screenX &&
               worldY + gp.tileSize> gp.srijit.worldY - gp.srijit.screenY &&
               worldY - gp.tileSize< gp.srijit.worldY + gp.srijit.screenY){

                    g2.drawImage(tile[tileNum].image,screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            
            worldCol++;
            
            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
         }

    }


    
}
