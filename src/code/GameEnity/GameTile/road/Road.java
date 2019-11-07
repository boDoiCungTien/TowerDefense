package code.GameEnity.GameTile.road;

import code.GameEnity.GameTile.GameTile;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class Road extends Rectangle implements GameTile, Comparable<Road> {
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

    @Override
    public int compareTo(Road other) {
        if (this.id == other.id) return 0;
        else if (this.id > other.id) return 1;
        else return -1;
    }

    public int getId() {
        return id;
    }
}
