package code.GameEnity.GameTile.Tower;

import code.GameEnity.Enemy.Enemy;
import code.GameEnity.GameTile.GameTile;

import java.awt.*;

public interface Tower extends GameTile {
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    public void draw(Graphics g);
    public boolean inRange(Enemy enemy);
    public void shoot(Enemy other);
    public int getRange_();
    public double getSPEED_BULLET_();
    public int getDAMAGE_();
}
