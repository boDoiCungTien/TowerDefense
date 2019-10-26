package code.GameEnity.GameTile;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class Road extends Rectangle implements GameTile{
    private Image i;

    public Road(int x, int y, int width, int height) {
        i = new ImageIcon("Image/road.png").getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
            g.drawImage(i, x, y, width, height, null);
    }
}
