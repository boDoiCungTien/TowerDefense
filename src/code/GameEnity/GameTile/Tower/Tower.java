package code.GameEnity.GameTile.Tower;

import code.GameEnity.Enemy.Enemy;
import code.GameEnity.GameTile.GameTile;

import java.awt.*;

public interface Tower extends GameTile {
    public void setBounds(Rectangle rectangle);
    public boolean inRange(Enemy enemy);
    public void shoot(Enemy other);
    public int getRange_();
    public double getSPEED_BULLET_();
    public int getDAMAGE_();
    public boolean contains(int x, int y);
    public boolean contains(Point p);
    public int getPRICE_();
}
