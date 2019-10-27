package code.GameEnity.GameTile.Tower;

import java.awt.*;

import static code.Config.*;

public class MachineGunTower extends Rectangle implements Tower{
    private Rectangle range;


    public  MachineGunTower(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        range = new Rectangle(x-2*block_size, y-2*block_size, 5*block_size, 5*block_size);
    }


    public void draw (Graphics g) {
        g.drawImage(img_Tower[2], x, y, width, height, null);
    }
}
