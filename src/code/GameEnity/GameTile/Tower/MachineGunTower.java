package code.GameEnity.GameTile.Tower;

import code.GameEnity.Bullet;
import code.GameEnity.Enemy.Enemy;

import java.awt.*;

import static code.Config.*;
import static code.Config.RANGE;

public class MachineGunTower extends Rectangle implements Tower{
    private final int SPEED_SHOOTING_ = SPEED_SHOOTING[2];
    private int count_time_ = SPEED_SHOOTING_;
    private final double SPEED_BULLET_ = SPEED_BULLETS[2];
    private final int range_ = RANGE[2];
    private final int DAMAGE_ = DAMAGE[2];

    public MachineGunTower() { };


    public void draw(Graphics g) {
        g.drawImage(img_Tower[2], x, y, width, height, null);
        if (count_time_ < SPEED_SHOOTING_) count_time_++;
    }

    public boolean inRange(Enemy enemy) {
        return ((int)Math.sqrt((this.x - enemy.getX())*(this.x - enemy.getX()) + (this.y - enemy.getY())*(this.y - enemy.getY())) <= range_);
    }



    public void shoot(Enemy enemy) {
        if (count_time_ >= SPEED_SHOOTING_) {
            Bullet bullet = new Bullet(this, enemy);
            bullets.add(bullet);
            count_time_ = 0;
        }
    }

    public int getRange_() {
        return range_;
    }

    public double getSPEED_BULLET_() {
        return SPEED_BULLET_;
    }

    public int getDAMAGE_() {
        return DAMAGE_;
    }
}
