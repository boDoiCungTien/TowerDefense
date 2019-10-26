package code;

import java.io.File;
import java.io.FileNotFoundException;
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

    }
}
