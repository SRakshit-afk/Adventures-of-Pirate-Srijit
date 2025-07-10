package entity;

import AdventureGame.GamePanel;
import AdventureGame.KeyInput;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class Player extends Entity {
    GamePanel gp;
    KeyInput keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyInput keyH){
        this.gp = gp;
        this.keyH = keyH;
        worldX = 100;
        worldY = 100;
        speed = 5;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        direction = "down"; 
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/srijit/boy_right_2.png"));

        } catch(IOException e){
            System.out.println("Error");
        } 
    }

    public void update(){
        if(keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rightPress == true){

            if(keyH.upPress){
                direction = "up";
            }
            else if(keyH.downPress){
                direction = "down";
            }
            else if(keyH.leftPress){
                direction = "left";
            }
            else if(keyH.rightPress){
                direction = "right";
            }

            //Check Tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check Object Collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickObject(objIndex);

            //Player can move only if CollisionOn = false
            if(collisionOn == false){
                switch(direction){
                    case "up" : worldY -= speed; break;
                    case "down" : worldY += speed; break;
                    case "left" : worldX -= speed; break;
                    case "right" : worldX += speed; break;
                }
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

    public void pickObject(int i){
        if(i != 999){
            String objName = gp.obj[i].name;

            switch (objName) {
                case "key":
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Key obtained!");
                    break;

                case "door":
                    if(hasKey > 0 ){
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("Door opened!");
                    }
                    else{
                        gp.ui.showMessage("Key Required!");
                    }
                    break;

                case "boots":
                    speed += 2;
                    gp.obj[i]= null;
                    gp.ui.showMessage("Speed increased!");
                    break;      
                    
                case "chest":
                    gp.ui.gameFinished = true;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        //Show player effective solid Area as a red box

        // g2.setColor(Color.RED);
        // g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);


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
