package code.GameEnity.Enemy;

import java.awt.*;

import static code.Config.*;

public class TankerEnemy extends Rectangle implements Enemy {
    private int blood_ = BLOOD[TANKER_ENEMY];
    private final int MAX_BLOOD_ = BLOOD[TANKER_ENEMY];
    private final int ARMOR_ = ARMOR[TANKER_ENEMY];
    private final double SPEED_ = SPEED_ENEMIES[TANKER_ENEMY];
    private final int REWARD_ = REWARD[TANKER_ENEMY];
    private double x_;
    private double y_;
    private double dx_;
    private double dy_;
    private Point p_next;
    private int points_appear = rd.nextInt(spawners.size());

    public TankerEnemy() {
        setBounds( spawners.get(points_appear).x + (TILE_SIZE- ENEMIES_SIZE[TANKER_ENEMY])/2, spawners.get(points_appear).y + (TILE_SIZE- ENEMIES_SIZE[TANKER_ENEMY])/2, ENEMIES_SIZE[TANKER_ENEMY], ENEMIES_SIZE[TANKER_ENEMY]);
        x_ = x;
        y_ = y;
        p_next = new Point(spawners.get(points_appear).x + TILE_SIZE/2, spawners.get(points_appear).y + TILE_SIZE/2);
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x, y - 6, width, 3);
        g.fillRect(x, y - 6, width*blood_/MAX_BLOOD_, 3);
        g.drawImage(img_Enemies[TANKER_ENEMY], x, y, width, height, null);
        if (!status_clicks[BUTTON_PAUSE]) {
            move();
        }
    }

    public void move(){
        if (p_next.x == x + width/2 && p_next.y == y + height/2) {
            determine_p_next();
        }
        x_ += dx_;
        y_ += dy_;
        x = (int)x_;
        y = (int)y_;
    }

    public void determine_p_next() {
        dx_ = 0;
        dy_ = 0;
        int i = (p_next.y - SPACE_ABOVE - TILE_SIZE/2)/TILE_SIZE;
        int j = (p_next.x - TILE_SIZE/2)/TILE_SIZE;
        if (i > 0 && map[i][j] > map[i-1][j] && map[i-1][j] != MOUNTAIN) {
            --i;
            dy_ = -SPEED_;
        } else if (i < FIELD_ROWS-1 &&map[i][j] > map[i+1][j] && map[i+1][j] != MOUNTAIN) {
            ++i;
            dy_ = SPEED_;
        } else if (j > 0 && map[i][j] > map[i][j-1] && map[i][j-1] != MOUNTAIN) {
            --j;
            dx_ = -SPEED_;
        } else if (j < FIELD_COLUMNS-1 && map[i][j] > map[i][j+1] && map[i][j+1] != MOUNTAIN) {
            ++j;
            dx_ = SPEED_;
        }
        p_next.x = j*TILE_SIZE + TILE_SIZE/2;
        p_next.y = i*TILE_SIZE + TILE_SIZE/2 + SPACE_ABOVE;
    }

    public void subtractBlood_(int damage) {
        if (damage > ARMOR_) {
            this.blood_ -= (damage-ARMOR_);
        }
    }

    public int getBlood_() {
        return blood_;
    }

    public int getREWARD_() {
        return REWARD_;
    }
}
