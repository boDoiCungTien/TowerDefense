package code;

import code.GameEnity.Bullet;
import code.GameEnity.Enemy.Enemy;
import code.GameEnity.GameTile.Mountain;
import code.GameEnity.GameTile.road.Road;
import code.GameEnity.GameTile.Tower.Tower;
import code.GameEnity.GameTile.road.Spawner;
import code.GameEnity.GameTile.road.Target;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static code.Config.*;

public class GameField {
    public GameField() {
        init();
    }

    public void init() {
        road = new ArrayList<Road>();
        spawners = new ArrayList<Spawner>();
        targets = new ArrayList<Target>();
        mountain = new ArrayList<Mountain>();
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        bullets = new ArrayList<Bullet>();
        loadMission = new LoadMission("Map/mission1.txt");

        img_tower_building = new ImageIcon("Image/Building.png").getImage();

        img_Towers[NORMAL_TOWER] = new ImageIcon("Image/NormalTower.png").getImage();
        img_Towers[SNIPER_TOWER] = new ImageIcon("Image/SniperTower.png").getImage();
        img_Towers[MACHINEGUN_TOWER] = new ImageIcon("Image/MachineGunTower.png").getImage();

        img_Enemies[NORMAL_ENEMY] = new ImageIcon("Image/NormalEnemy.png").getImage();
        img_Enemies[TANKER_ENEMY] = new ImageIcon("Image/TankerEnemy.png").getImage();
        img_Enemies[SMALLER_ENEMY] = new ImageIcon("Image/SmallerEnemy.png").getImage();
        img_Enemies[BOSS_ENEMY] = new ImageIcon("Image/BossEnemy.png").getImage();

        gameStore = new GameStore();
    }

    public void draw(Graphics g) {
        gameStore.draw(g);

        for (int i = 0; i < mountain.size(); ++i) {
            mountain.get(i).draw(g);
        }
        for (int i = 0; i < road.size(); ++i) {
            road.get(i).draw(g);
        }
        for (int i = 0; i < targets.size(); ++i) {
            targets.get(i).draw(g);
        }
        for (int i = 0; i < spawners.size(); ++i) {
            spawners.get(i).draw(g);
        }
        for (int i = 0; i < towers.size(); ++i) {
            towers.get(i).draw(g);
        }
        for (int i = 0; i < enemies.size(); ++i) {
            enemies.get(i).draw(g);
        }
        for (int i = 0; i < bullets.size(); ++i) {
            bullets.get(i).draw(g);
        }

        if (id_tower_show != -1) {
            g.setColor(Color.BLACK);
            g.drawOval((int)towers.get(id_tower_show).getCenterX()-towers.get(id_tower_show).getRange_(), (int)towers.get(id_tower_show).getCenterY()-towers.get(id_tower_show).getRange_(), 2*towers.get(id_tower_show).getRange_(), 2*towers.get(id_tower_show).getRange_());
            button_clicks[BUTTON_SELL].setBounds((int)towers.get(id_tower_show).getX() + TILE_SIZE/4, (int)towers.get(id_tower_show).getY() + 3*TILE_SIZE/4, TILE_SIZE/2, TILE_SIZE/4);
            g.setColor(Color.GRAY);
            g.fillRect(button_clicks[BUTTON_SELL].x, button_clicks[BUTTON_SELL].y, button_clicks[BUTTON_SELL].width, button_clicks[BUTTON_SELL].height);
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
            g.drawString("sell", button_clicks[BUTTON_SELL].x, button_clicks[BUTTON_SELL].y + button_clicks[BUTTON_SELL].height);
        }
    }
}
