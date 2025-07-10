package Objects;

import AdventureGame.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

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
