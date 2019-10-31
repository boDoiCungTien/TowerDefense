package code.GameEnity.GameTile.road;

import code.GameEnity.GameTile.GameTile;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class Road extends Rectangle implements GameTile{
    private int id;
    public Road() {};
    public Road(int x, int y, int width, int height, int id) {
        img_road = new ImageIcon("Image/road.png").getImage();
        this.setBounds(x, y, width, height);
        this.id = id;
    }

    public void draw(Graphics g) {
            g.drawImage(img_road, x, y, width, height, null);
    }

    public int getId() {
        return id;
    }
}
