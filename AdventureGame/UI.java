package AdventureGame;

import Objects.OBJ_KEY;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font broadway_40;
    Font arial_30;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(GamePanel gp){
        this.gp = gp;
        broadway_40 = new Font("Broadway", Font.PLAIN, 40);
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        OBJ_KEY key = new OBJ_KEY();
        keyImage = key.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        //do not instantiate any class inside draw method as this gets called 60times per second and instantiation takes time

        if(gameFinished == true){
            String text;
            int textLength;
            int x, y;

            g2.setFont(arial_30);
            g2.setColor(Color.white);
            text = "!!!You found the treasure!!!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            g2.setFont(broadway_40);
            g2.setColor(Color.white);
            text = "Congratulations";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;   

        }
        else {
            g2.setFont(broadway_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("X " + gp.srijit.hasKey, 74, 62);

            //Messages
            if(messageOn == true){
                g2.setFont(arial_30);
                g2.setColor(Color.white);
                g2.drawString(message, 13*gp.tileSize/2, 11*gp.tileSize);
                messageCounter++;

                if(messageCounter > 120){
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }

    }
    
}
