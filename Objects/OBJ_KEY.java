package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_KEY extends SuperObject {
    public OBJ_KEY() {
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
