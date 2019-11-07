package code;

import code.GameEnity.GameTile.Tower.MachineGunTower;
import code.GameEnity.GameTile.Tower.NormalTower;
import code.GameEnity.GameTile.Tower.SniperTower;
import code.GameEnity.GameTile.Tower.Tower;

import java.awt.*;

import static code.Config.*;

public class AutoPlaying {
    public static void auto_play() {
        int count;
        for (int i = 0; i < road.size(); ++i) {
            for (int j = 0; j < enemies.size(); ++j) {
                if (road.get(i).contains((Rectangle) enemies.get(j))) {
                    count = 0;
                    for (int k = 0; k < towers.size(); ++k) {
                        if (towers.get(k).inRange(enemies.get(j))) {
                            ++count;
                        }
                    }
                    if (coin >= 1500 || (coin >= 1000 && count < 3) || (coin >= 500 && count < 2) || count == 0) {
                        for (int k = 0; k < mountain.size(); ++k) {
                            if (!mountain.get(k).getEmpty()) {
                                continue;
                            }
                            int dx = Math.abs(mountain.get(k).x - road.get(i).x);
                            int dy = Math.abs(mountain.get(k).y - road.get(i).y);
                            if ((dx == 40 && dy == 0) || (dx == 40 && dy == 40) || (dx == 0 && dy ==40)) {
                                Rectangle tower;
                                if (coin > PRICE[MACHINEGUN_TOWER]) {
                                    tower = new MachineGunTower();
                                } else if (coin > PRICE[SNIPER_TOWER]) {
                                    tower = new SniperTower();
                                } else if (coin >= PRICE[NORMAL_TOWER]) {
                                    tower = new NormalTower();
                                } else {
                                    return;
                                }
                                tower.setBounds(mountain.get(k).getBounds());
                                towers.add((Tower) tower);
                                mountain.get(k).setEmpty(false);
                                coin -= ((Tower) tower).getPRICE_();
                                return;
                            }
                        }

                    }
                }
            }
        }
    }
}
