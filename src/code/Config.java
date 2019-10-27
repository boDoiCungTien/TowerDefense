package code;

import code.GameEnity.GameTile.Mountain;
import code.GameEnity.GameTile.Road;
import code.GameEnity.GameTile.Tower.MachineGunTower;
import code.GameEnity.GameTile.Tower.NormalTower;
import code.GameEnity.GameTile.Tower.SniperTower;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Config {
    public static JFrame frame;
    public static final int SCREEN_WIDTH = 805;
    public static final int SCREEN_HEIGHT = 505;

    public static Main mainScreen;

    public static GameStage gameStage;

    public static GameField gameField;
    public static GameStore gameStore;

    public static Thread thread_main;
    public static Thread thread_stage;

    public final static int block_size = 40;
    public final static int field_width = 20;
    public final static int field_height = 10;
    public final static int menu_size = 30;
    public final static int numbers_of_tower = 3;
    public final static int space_of_buttons = 5;
    public final static int size_of_button_store = 40;
    public static int coins;
    public static int heart;
    public static int temp = -1;

    public final static int[] price = {500, 3000, 10000};

    public static int[][] map = new int[field_height][field_width];



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


    public static Image image;
    public static Image img_start0;
    public static Image img_start;
    public static Image img_continue0;
    public static Image img_continue;
    public static Image img_menu0;
    public static Image img_menu;
    public static Image img_road;
    public static Image img_mountain;
    public static Image[] img_Tower = new Image[numbers_of_tower];

    public static List<Road> road;
    public static List<Mountain> mountain;
    public static List<NormalTower> normalTowers = new ArrayList<NormalTower>();
    public static List<SniperTower> sniperTowers = new ArrayList<SniperTower>();
    public static List<MachineGunTower> machineGunTowers = new ArrayList<MachineGunTower>();

    public static EventHandling main_EH;
    public static EventHandling stage_EH;

}
