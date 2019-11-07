package code.GameEnity;

import code.GameEnity.Enemy.Enemy;
import code.GameEnity.GameTile.Tower.Tower;

import java.awt.*;

import static code.Config.*;

public class Bullet extends Rectangle implements GameEnity {
    private int damage_;
    private double speed_;
    private int range_;
    private double x_;
    private double y_;
    private double dx;
    private double dy;
    private Point p_start;
    private final int DELAY = 100;
    private int Counting_time_delay = 0;

    public Bullet(Tower tower, Enemy enemy) {
        status_sound_effects[SHOOT] = true;
        setBounds((int) tower.getX() + TILE_SIZE / 2, (int) tower.getY() + TILE_SIZE / 2, 7, 7);
        p_start = new Point((int) tower.getCenterX(), (int) tower.getCenterY());
        range_ = tower.getRange_();
        speed_ = tower.getSPEED_BULLET_();
        damage_ = tower.getDAMAGE_();
        x_ = x;
        y_ = y;
        double d = Math.sqrt((enemy.getCenterX() - tower.getCenterX()) * (enemy.getCenterX() - tower.getCenterX()) + (enemy.getCenterY() - tower.getCenterY()) * (enemy.getCenterY() - tower.getCenterY()));
        if (d == 0) {
            dx = 0;
            dy = speed_;
        } else {
            dx = speed_*(enemy.getCenterX() - p_start.x)/d;
            dy = speed_*(enemy.getCenterY() - p_start.y)/d;
        }
    }

    public void draw(Graphics g) {
        if (Counting_time_delay < DELAY) {
            ++Counting_time_delay;
            return;
        }
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x, y, width, height);
        if (!status_clicks[BUTTON_PAUSE]) {
            move();
        }
    }

    public void move() {
        x_ += dx;
        y_ += dy;
        x = (int)x_;
        y = (int)y_;
    }

    public boolean exist() {
        boolean flag;
        flag = ((int)Math.sqrt((this.x - p_start.x)*(this.x - p_start.x) + (this.y - p_start.y)*(this.y - p_start.y)) <= range_);
        if (flag) {
            if(y < SPACE_ABOVE || y > SPACE_ABOVE+FIELD_ROWS*TILE_SIZE || x < 0 || x > FIELD_COLUMNS*TILE_SIZE) {
                flag = false;
            }
        }
        return flag;

    }

    public int getDamage_() {
        return damage_;
    }
}
