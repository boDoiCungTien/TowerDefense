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
import java.util.List;

public class Config {
    public static JFrame frame;

    public static Main mainScreen;

    public static GameStage gameStage;

    public static GameField gameField;
    public static LoadMission loadMission;
    public static GameStore gameStore;

    public static Thread thread_main;
    public static Thread thread_stage;

    public final static int SCREEN_WIDTH = 805;
    public final static int SCREEN_HEIGHT = 525;
    public final static int TILE_SIZE = 40;
    public final static int FIELD_COLUMNS = 20;
    public final static int FIELD_ROWS = 10;
    public final static int SPACE_ABOVE = 30;
    public final static int SPACE = 5;
    public final static int BUTTON_STORE_SIZE = 40;
    public final static int TOWER_TYPES = 3;
    public final static int ENEMY_TYPES = 4;
    public final static int[] PRICE = {500, 3000, 10000};
    public final static int[] RANGE = {100, 150, 120};
    public final static int[] SPEED_SHOOTING = {1000, 1500, 1200};
    public final static int[] DAMAGE = {10, 20, 50};
    public final static double[] SPEED_BULLETS = {0.5, 0.6, 0.7};
    public final static int[] BLOOD = {50, 200, 500, 1000};
    public final static int[] ARMOR = {5, 10, 20, 100};
    public final static int[] REWARD = {2000, 3000, 5000};
    public final static double[] SPEED_ENEMIES = {0.05, 0.02, 0.15, 0.015};
    public final static int[] ENEMIES_SIZE = {30, 30, 30, 30};

    public static int coins;
    public static int heart;
    public static int temp = -1;

    public static int[][] map = new int[FIELD_ROWS][FIELD_COLUMNS];

    public static boolean can_put = false;

    public static Rectangle buttonStart;
    public static Rectangle buttonContinue;
    public static Rectangle[] button_store;
    public static Rectangle button_heart;
    public static Rectangle button_coins;
    public static Rectangle button_menu;
    public static Rectangle button_temp;
    public static Rectangle button_put;

    public static Point p_mouse = new Point(0, 0);

    public static Image img_start0;
    public static Image img_start;
    public static Image img_continue0;
    public static Image img_continue;
    public static Image img_menu0;
    public static Image img_menu;
    public static Image img_road;
    public static Image img_spawner;
    public static Image img_target;
    public static Image img_mountain;
    public static Image[] img_Tower = new Image[TOWER_TYPES];

    public static List<Road> road;
    public static List<Spawner> spawners;
    public static List<Target> targets;
    public static List<Mountain> mountain;
    public static List<Tower> towers;
    public static List<Enemy> enemies;
    public static List<Bullet> bullets;

    public static EventHandling main_EH;
    public static EventHandling stage_EH;
}
