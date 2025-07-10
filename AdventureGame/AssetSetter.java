package AdventureGame;

import Objects.OBJ_BOOTS;
import Objects.OBJ_CHEST;
import Objects.OBJ_DOOR;
import Objects.OBJ_KEY;

public class AssetSetter {
    GamePanel gp;

    AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_KEY();
        gp.obj[0].worldX = 3 * gp.tileSize;
        gp.obj[0].worldY = 34 * gp.tileSize;

        gp.obj[1] = new OBJ_KEY();
        gp.obj[1].worldX = 32 * gp.tileSize;
        gp.obj[1].worldY = 48 * gp.tileSize;

        gp.obj[2] = new OBJ_KEY();
        gp.obj[2].worldX = 39 * gp.tileSize;
        gp.obj[2].worldY = 5 * gp.tileSize;

        gp.obj[3] = new OBJ_DOOR();
        gp.obj[3].worldX =  36 * gp.tileSize;
        gp.obj[3].worldY =  44 * gp.tileSize;

        gp.obj[4] = new OBJ_DOOR();
        gp.obj[4].worldX = 38 * gp.tileSize;
        gp.obj[4].worldY = 43* gp.tileSize;

        gp.obj[5] = new OBJ_DOOR();
        gp.obj[5].worldX = 33 * gp.tileSize;
        gp.obj[5].worldY = 43 * gp.tileSize;

        gp.obj[6] = new OBJ_CHEST();
        gp.obj[6].worldX = 38 * gp.tileSize;
        gp.obj[6].worldY = 39 * gp.tileSize;

        gp.obj[7] = new OBJ_BOOTS();
        gp.obj[7].worldX = 48 * gp.tileSize;
        gp.obj[7].worldY = 1 * gp.tileSize;

    }
}
