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
import java.util.Random;

public class Config {
    public static JFrame frame;
    public static MainScreen mainScreen;
    public static GameStage gameStage;
    public static GameField gameField;
    public static LoadMission loadMission;
    public static GameStore gameStore;
    public static Thread thread_main;
    public static Thread thread_stage;
    public static Random rd;

    public final static int SCREEN_WIDTH = 806;
    public final static int SCREEN_HEIGHT = 525;
    public final static int TILE_SIZE = 40;
    public final static int FIELD_COLUMNS = 20;
    public final static int FIELD_ROWS = 10;
    public final static int SPACE_ABOVE = 35;
    public final static int SPACE = 5;
    public final static int BUTTON_STORE_SIZE = 40;

    //MAP:
    public final static int MOUNTAIN = -1;
    public final static int TARGET = 0;
    public final static int SPAWNER = 999;
    // ROAD = {0, 1, 2, ..., 999}

    //ENEMYS:
    public final static int NORMAL_ENEMY = 0;
    public final static int TANKER_ENEMY = 1;
    public final static int SMALLER_ENEMY = 2;
    public final static int BOSS_ENEMY = 3;
    public final static int ENEMY_TYPES = 4;
    public final static int[] BLOOD = {120, 300, 100, 750};
    public final static int[] ARMOR = {5, 8, 3, 12};
    public final static int[] REWARD = {50, 150, 100, 400};
    public final static double[] SPEED_ENEMIES = {0.05, 0.035, 0.1, 0.025};
    public final static int[] ENEMIES_SIZE = {20, 30, 30, 40};    //chia het cho 2

    //TOWERS:
    public final static int NORMAL_TOWER = 0;
    public final static int SNIPER_TOWER = 1;
    public final static int MACHINEGUN_TOWER = 2;
    public final static int TOWER_TYPES = 3;
    public final static int[] PRICE = {50, 300, 500};
    public final static int[] RANGE = {120, 180, 100};
    public final static int[] SPEED_SHOOTING = {1000, 1500, 500};
    public final static int[] DAMAGE = {25, 35, 30};
    public final static double[] SPEED_BULLETS = {0.6, 0.6, 0.6};

    public static int coin;
    public static int heart;
    public static int kill;
    public static int score;

    public static int[][] map = new int[FIELD_ROWS][FIELD_COLUMNS];

    public final static int CLICK_TYPES = 10;
    public final static int DATA_TYPES = 5;

    public static boolean[] status_clicks = new boolean[CLICK_TYPES];
    public static boolean can_put = false;
    public static int temp = -1;
    public static int id_tower_show = -1;

    public final static int BUTTON_NEW = 0;
    public final static int BUTTON_CONTINUE = 1;
    public final static int BUTTON_PAUSE = 2;
    public final static int BUTTON_AUTO = 3;
    public final static int BUTTON_SOUND = 4;
    public final static int BUTTON_EXIT = 5;
    public final static int BUTTON_SELL = 6;

    public final static int BUTTON_HEART = 0;
    public final static int BUTTON_COIN = 1;
    public final static int BUTTON_KILL = 2;

    public static Rectangle[] button_clicks = new Rectangle[CLICK_TYPES];
    public static Rectangle[] button_towers = new Rectangle[TOWER_TYPES];
    public static Rectangle[] button_info = new Rectangle[DATA_TYPES];
    public static Rectangle button_temp;
    public static Rectangle button_put;

    public static Point p_mouse = new Point(0, 0);

    public static Image[] img_clicks_On = new Image[CLICK_TYPES];
    public static Image[] img_clicks_Off= new Image[CLICK_TYPES];
    public static Image[] img_info = new Image[DATA_TYPES];
    public static Image img_road;
    public static Image img_spawner;
    public static Image img_target;
    public static Image img_mountain;
    public static Image img_tower_building;
    public static Image[] img_Towers = new Image[TOWER_TYPES];
    public static Image[] img_Enemies = new Image[ENEMY_TYPES];

    public static List<Road> road;
    public static List<Spawner> spawners;
    public static List<Target> targets;
    public static List<Mountain> mountain;
    public static List<Tower> towers;
    public static List<Enemy> enemies;
    public static List<Bullet> bullets;

    public static EventHandling main_EH;
    public static EventHandling stage_EH;

    public static Sound sound;

    public static boolean[] status_sound_effects = new boolean[10];
    public static int CLICK = 0;
    public static int SHOOT = 1;
    public static int BUILD = 2;
    public static int DESTROY = 3;
    public static int DIE = 4;
    public static int WARNING = 5;

}
