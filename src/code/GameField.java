package code;

import code.GameEnity.GameTile.Mountain;
import code.GameEnity.GameTile.Road;

import java.awt.*;
import java.util.ArrayList;

import static code.Config.*;

public class GameField {
    public GameField() {
        init();
    }

    public void init() {
        road = new ArrayList<Road>();
        mountain = new ArrayList<Mountain>();
        new LoadMission("Map/mission1.txt");

        for (int i = 0; i < field_height; ++i) {
            for (int j = 0; j < field_width; ++j) {
                if (map[i][j] == 0) {
                    mountain.add(new Mountain(j*block_size, i*block_size + menu_size, block_size, block_size));
                } else if (map[i][j] == 1) {
                    road.add(new Road(j*block_size, i*block_size + menu_size, block_size, block_size));
                }
            }
        }

    }

    public void draw(Graphics g) {
        for (int i = 0; i < road.size(); ++i) {
            road.get(i).draw(g);
        }
        for (int j = 0; j < mountain.size(); ++j) {
            mountain.get(j).draw(g);
        }
    }
}
