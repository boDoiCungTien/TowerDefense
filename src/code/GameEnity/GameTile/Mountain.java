package code.GameEnity.GameTile;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class Mountain extends Rectangle implements GameTile {
    private boolean empty;

    public Mountain(int x, int y, int width, int height) {
        empty = true;
        img_mountain = new ImageIcon("Image/mountain.png").getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void draw(Graphics g) {
        g.drawImage(img_mountain, x, y, width, height, null);
    }
}
