package Objects;

import AdventureGame.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, GamePanel gp){
                    int screenX = worldX - gp.srijit.worldX + gp.srijit.screenX;
            int screenY = worldY - gp.srijit.worldY + gp.srijit.screenY;

            if(worldX + gp.tileSize> gp.srijit.worldX - gp.srijit.screenX && 
               worldX - gp.tileSize< gp.srijit.worldX + gp.srijit.screenX &&
               worldY + gp.tileSize> gp.srijit.worldY - gp.srijit.screenY &&
               worldY - gp.tileSize< gp.srijit.worldY + gp.srijit.screenY)

                    g2.drawImage(image,screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
