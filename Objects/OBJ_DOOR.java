package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_DOOR extends SuperObject{
     public OBJ_DOOR() {
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
