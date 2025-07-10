package AdventureGame;

import Objects.SuperObject;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTi1eSize = 16; // Tile size
    final int scale = 3;
    
    public final int tileSize = originalTi1eSize * scale; // 48x48

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;

    //World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;


    //Instances
    TileManager tileM = new TileManager(this);
    KeyInput keyH = new KeyInput();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player srijit = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];


    // Set FPS
    int fps = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupObjectGame(){
        aSetter.setObject();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta --;
            }
        }
    }

    public void update(){
        srijit.update();
    }

    @Override
    public void paintComponent(Graphics g){ 
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //Tile
        tileM.draw(g2);

        //Object
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        srijit.draw(g2);

        g2.dispose();

    }

}