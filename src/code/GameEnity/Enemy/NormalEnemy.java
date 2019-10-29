package code.GameEnity.Enemy;

import javax.swing.*;
import java.awt.*;
import static code.Config.*;
public class NormalEnemy extends Rectangle implements Enemy {
    private int armor = 50;
    private int speedRunning = 50;
    private int blood = 50;
    public NormalEnemy(int x , int y, int width, int height, int armor, int speedRunning, int blood){
        this.armor = armor;
        this.blood = blood;
        this.speedRunning = speedRunning;
        for(int i=0; i<field_height; i++){
            for(int j=0; j<field_width; j++){
                if(map[i][j]==1){
                    setBounds(x, y, width, height);
                }
            }
        }
    }
    public void draw (Graphics g){g.drawImage(img_Enemy[0],x,y,width,height,null);}
}
