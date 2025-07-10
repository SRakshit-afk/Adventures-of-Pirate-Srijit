package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_BOOTS extends SuperObject{
    public OBJ_BOOTS() {
        name = "boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/speed.png"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
