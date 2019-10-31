package code;

import code.GameEnity.Bullet;
import code.GameEnity.Enemy.Enemy;
import code.GameEnity.Enemy.NormalEnemy;
import code.GameEnity.GameTile.Mountain;
import code.GameEnity.GameTile.road.Road;
import code.GameEnity.GameTile.Tower.Tower;
import code.GameEnity.GameTile.road.Spawner;
import code.GameEnity.GameTile.road.Target;

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
        gameStore = new GameStore();

    }

    public void draw(Graphics g) {
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

        gameStore.draw(g);
    }
}
