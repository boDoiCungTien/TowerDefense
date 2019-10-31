package code.GameEnity.GameTile.road;

import javax.swing.*;
import java.awt.*;

import static code.Config.img_target;

public class Target extends Road {
    public Target(int x, int y, int width, int height) {
        super();
        img_target = new ImageIcon("Image/Target.png").getImage();
        this.setBounds(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(img_target, x, y, width, height, null);
    }

}
