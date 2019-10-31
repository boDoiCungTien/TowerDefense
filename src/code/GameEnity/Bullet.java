package code.GameEnity;

import code.GameEnity.Enemy.Enemy;
import code.GameEnity.GameTile.Tower.Tower;

import java.awt.*;

import static code.Config.TILE_SIZE;

public class Bullet extends Rectangle implements GameEnity {
    private int damage_;
    private double speed_;
    private int range_;
    private double x_;
    private double y_;
    private double dx;
    private double dy;
    private Point p_start;

    public Bullet(Tower tower, Enemy enemy) {
        setBounds((int) tower.getX() + TILE_SIZE / 2, (int) tower.getY() + TILE_SIZE / 2, 7, 7);
        p_start = new Point((int) tower.getX(), (int) tower.getY());
        range_ = tower.getRange_();
        speed_ = tower.getSPEED_BULLET_();
        damage_ = tower.getDAMAGE_();
        x_ = x;
        y_ = y;
        double d = Math.sqrt((enemy.getX() - tower.getX()) * (enemy.getX() - tower.getX()) + (enemy.getY() - tower.getY()) * (enemy.getY() - tower.getY()));
        if (d == 0) {
            dx = 0;
            dy = speed_;
        } else {
            dx = speed_*(enemy.getX() - p_start.x)/d;
            dy = speed_*(enemy.getY() - p_start.y)/d;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.gray);
        g.fillOval(x, y, width, height);
        move();
    }

    public void move() {
        x_ += dx;
        y_ += dy;
        x = (int)x_;
        y = (int)y_;
    }

    public boolean exist() {
        return ((int)Math.sqrt((this.x - p_start.x)*(this.x - p_start.x) + (this.y - p_start.y)*(this.y - p_start.y)) <= range_);

    }

    public int getDamage_() {
        return damage_;
    }
}
