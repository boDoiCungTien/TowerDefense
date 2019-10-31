package code.GameEnity.GameTile;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class Mountain extends Rectangle implements GameTile {
    private boolean empty;

    public Mountain(int x, int y, int width, int height) {
        empty = true;
        img_mountain = new ImageIcon("Image/Game Stage.png").getImage();
        this.setBounds(x, y, width, height);
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
