package code.GameEnity.GameTile.road;

import javax.swing.*;
import java.awt.*;

import static code.Config.img_spawner;

public class Spawner extends Road {
    public Spawner(int x, int y, int width, int height) {
        super();
        img_spawner = new ImageIcon("Image/Spawner.png").getImage();
        this.setBounds(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(img_spawner, x, y, width, height, null);
    }

}
