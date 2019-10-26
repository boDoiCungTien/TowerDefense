package code;

import code.GameEnity.GameTile.Mountain;
import code.GameEnity.GameTile.Road;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Config {
    public static JFrame frame;
    public static final int SCREEN_WIDTH = 805;
    public static final int SCREEN_HEIGHT = 505;

    public static Main mainScreen;

    public static GameStage gameStage;

    public static Rectangle buttonStart;
    public static Rectangle buttonContinue;

    public static GameField gameField;
    public static GameStore gameStore;

    public static Thread thread_main;
    public static Thread thread_stage;

    public final static int block_size = 40;
    public final static int field_width = 20;
    public final static int field_height = 10;

    public final static int menu_size = 30;

    public static List<Road> road;
    public static List<Mountain> mountain;

    public static int[][] map = new int[field_height][field_width];

    public static int coins;
    public static int heart;

    public static Rectangle[] button_store;
    public static Rectangle button_heart;
    public static Rectangle button_coins;
    public static Rectangle button_menu;

    public final static int numbers_of_tower = 3;
    public final static int space_of_buttons = 5;
    public final static int size_of_button_store = 40;

    public static Point p = new Point(0, 0);

    public static Image img_khung;
    public static Image img_start;
    public static Image img_continue;
    public static Image img_menu;
}
