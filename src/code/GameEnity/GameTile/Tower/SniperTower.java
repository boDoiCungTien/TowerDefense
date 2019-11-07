package code.GameEnity.GameTile.Tower;

import code.GameEnity.Bullet;
import code.GameEnity.Enemy.Enemy;

import java.awt.*;

import static code.Config.*;
import static code.Config.RANGE;

public class SniperTower extends Rectangle implements Tower{
    private final int DELAY_ = 300;
    private int Counting_time_delay_ = 0;
    private final int SPEED_SHOOTING_ = SPEED_SHOOTING[SNIPER_TOWER];
    private int counting_time_shoot_ = SPEED_SHOOTING_ - DELAY_;
    private final double SPEED_BULLET_ = SPEED_BULLETS[SNIPER_TOWER];
    private final int range_ = RANGE[SNIPER_TOWER];
    private final int DAMAGE_ = DAMAGE[SNIPER_TOWER];
    private final int PRICE_ = PRICE[SNIPER_TOWER];

    public SniperTower() {
        status_sound_effects[BUILD] = true;
    };

    public void draw(Graphics g) {
        if (Counting_time_delay_ < DELAY_) {
            g.drawImage(img_tower_building, x, y, width, height, null);
            ++Counting_time_delay_;
            return;
        }
        g.drawImage(img_Towers[SNIPER_TOWER], x, y, width, height, null);
        if (counting_time_shoot_ < SPEED_SHOOTING_) counting_time_shoot_++;
    }

    public boolean inRange(Enemy enemy) {
        return ((int)Math.sqrt((this.x - enemy.getX())*(this.x - enemy.getX()) + (this.y - enemy.getY())*(this.y - enemy.getY())) <= range_);
    }

    public void shoot(Enemy enemy) {
        if (counting_time_shoot_ >= SPEED_SHOOTING_) {
            Bullet bullet = new Bullet(this, enemy);
            bullets.add(bullet);
            counting_time_shoot_ = 0;
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

    @Override
    public int getPRICE_() {
        return PRICE_;
    }
}
