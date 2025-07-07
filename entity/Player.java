package entity;

import AdventureGame.GamePanel;
import AdventureGame.KeyInput;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class Player extends Entity {
    GamePanel gp;
    KeyInput keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyInput keyH){
        this.gp = gp;
        this.keyH = keyH;
        worldX = 100;
        worldY = 100;
        speed = 4;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        direction = "down"; 
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/srijit/boy_right_2.png"));

        } catch(IOException e){
            System.out.println("Error");
        } 
    }

    public void update(){
        if(keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rightPress == true){

            if(keyH.upPress){
                direction = "up";
                worldY -= speed;
            }
            else if(keyH.downPress){
                direction = "down";
                worldY += speed;
            }
            else if(keyH.leftPress){
                direction = "left";
                worldX -= speed;
            }
            else if(keyH.rightPress){
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2) {
                    spriteNum= 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction){
            case "up" -> {
                if(spriteNum == 1){
                    image = up1;
                }
                else if(spriteNum == 2){
                    image = up2;
                }
            }

            case "down" -> {
                if(spriteNum == 1){
                    image = down1;
                }
                else if(spriteNum == 2){
                    image = down2;
                }
            }

            case "left" -> {
                if(spriteNum == 1){
                    image = left1;
                }
                else if(spriteNum == 2){
                    image = left2;
                }
            }

            case "right" -> {
                if(spriteNum == 1){
                    image = right1;
                }
                else if(spriteNum == 2){
                    image = right2;
                }
            }
        }

    if (image != null) {
        g2.drawImage(image,screenX, screenY, gp.tileSize, gp.tileSize, null);
    } 
    else{
        System.out.println("Image is null for direction: " + direction);
    }

    }
}
