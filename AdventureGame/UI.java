package AdventureGame;

import Objects.OBJ_KEY;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font broadway_40;
    BufferedImage keyImage;

    public UI(GamePanel gp){
        this.gp = gp;
        broadway_40 = new Font("Broadway", Font.PLAIN, 40);
        OBJ_KEY key = new OBJ_KEY();
        keyImage = key.image;
    }

    public void draw(Graphics2D g2){
        //do not instantiate any class inside draw method as this gets called 60times per second and instantiation takes time
        g2.setFont(broadway_40);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("X " + gp.srijit.hasKey, 74, 62);
    }
    
}
