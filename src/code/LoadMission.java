package code;

import code.GameEnity.GameTile.Mountain;
import code.GameEnity.GameTile.road.Road;
import code.GameEnity.GameTile.road.Spawner;
import code.GameEnity.GameTile.road.Target;

import java.io.File;
import java.util.Scanner;

import static code.Config.*;

public class LoadMission {
    public LoadMission(String file_map) {
        load(file_map);
    }

    public void load(String file_map) {
        try {

            File f = new File(file_map);
            Scanner scanner = new Scanner(f);
            for (int i = 0; i< 10; ++i) {
                for (int j = 0; j < 20; ++j) {
                    map[i][j] = scanner.nextInt();
                }
            }
            scanner.close();
        } catch (Exception e) { }


        for (int i = 0; i < FIELD_ROWS; ++i) {
            for (int j = 0; j < FIELD_COLUMNS; ++j) {
                if (map[i][j] == -1) {
                    mountain.add(new Mountain(j* TILE_SIZE, i* TILE_SIZE + SPACE_ABOVE, TILE_SIZE, TILE_SIZE));
                    continue;
                } else {
                    road.add(new Road(j* TILE_SIZE, i* TILE_SIZE + SPACE_ABOVE, TILE_SIZE, TILE_SIZE, map[i][j]));
                    if (map[i][j] == 999) {
                        spawners.add(new Spawner(j* TILE_SIZE, i* TILE_SIZE + SPACE_ABOVE, TILE_SIZE, TILE_SIZE));
                    } else if (map[i][j] == 0) {
                        targets.add(new Target(j* TILE_SIZE, i* TILE_SIZE + SPACE_ABOVE, TILE_SIZE, TILE_SIZE));
                    }
                }
            }
        }
    }
}
