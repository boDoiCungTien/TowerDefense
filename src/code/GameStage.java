package code;


import code.GameEnity.Enemy.BossEnemy;
import code.GameEnity.Enemy.NormalEnemy;
import code.GameEnity.Enemy.SmallerEnemy;
import code.GameEnity.Enemy.TankerEnemy;
import code.GameEnity.GameTile.Tower.MachineGunTower;
import code.GameEnity.GameTile.Tower.NormalTower;
import code.GameEnity.GameTile.Tower.SniperTower;
import code.GameEnity.GameTile.Tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static code.Config.*;

public class GameStage extends JPanel implements Runnable{

    public GameStage() {
        init();
        thread_stage = new Thread(this);
        thread_stage.start();
    }

    public void init() {
        this.setBounds(0, 0, frame.getSize().width, frame.getSize().height);
        this.setLayout(null);
        this.setVisible(true);
        stage_EH = new EventHandling();
        this.addMouseListener(stage_EH);
        this.addMouseMotionListener(stage_EH);
        gameStage = this;

        gameField = new GameField();
        rd = new Random();

        status_clicks[BUTTON_PAUSE] = false;
        status_clicks[BUTTON_AUTO] = false;

        button_clicks[BUTTON_AUTO] = new Rectangle(100, SPACE_ABOVE + FIELD_ROWS*TILE_SIZE + SPACE, 50, SPACE_ABOVE);
        button_clicks[BUTTON_PAUSE] = new Rectangle(0, 0, 50, SPACE_ABOVE);
        button_clicks[BUTTON_SOUND] = new Rectangle(50, 0, 50, SPACE_ABOVE);
        button_clicks[BUTTON_EXIT] = new Rectangle(SCREEN_WIDTH-56, 0, 50, SPACE_ABOVE);
        button_clicks[BUTTON_SELL] = new Rectangle(0, 0, 0, 0);

        img_clicks_Off[BUTTON_PAUSE] = new ImageIcon("Image/PauseOff.png").getImage();
        img_clicks_Off[BUTTON_AUTO] = new ImageIcon("Image/AutoOff.png").getImage();
        img_clicks_Off[BUTTON_SOUND] = new ImageIcon("Image/SoundOff.png").getImage();
        img_clicks_Off[BUTTON_EXIT] = new ImageIcon("Image/Exit.png").getImage();

        img_clicks_On[BUTTON_PAUSE] = new ImageIcon("Image/PauseOn.png").getImage();
        img_clicks_On[BUTTON_AUTO] = new ImageIcon("Image/AutoOn.png").getImage();
        img_clicks_On[BUTTON_SOUND] = new ImageIcon("Image/SoundOn.png").getImage();
        img_clicks_On[BUTTON_EXIT] = new ImageIcon("Image/Exit.png").getImage();


    }

    @Override
    protected void paintComponent(Graphics g) {
        if (lose) {
            g.drawImage(new ImageIcon("Image/End.png").getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
            g.setColor(Color.black);
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 100));
            String s1 = "" + kill;
            g.drawString(s1, (this.getWidth() - 100*s1.length())/2, 220);
            String s2 = "" + score;
            g.drawString(s2, (this.getWidth() - 100*s2.length())/2, 440);
            repaint();
            g.drawImage(img_clicks_Off[BUTTON_EXIT], button_clicks[BUTTON_EXIT].x, button_clicks[BUTTON_EXIT].y, button_clicks[BUTTON_EXIT].width, button_clicks[BUTTON_EXIT].height, null);
            thread_stage.interrupt();
            return;
        }

        g.setColor(Color.blue);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);

        for (int i = BUTTON_PAUSE; i < CLICK_TYPES; ++i) {
            if (button_clicks[i] == null) break;
            if (status_clicks[i]) {
                g.drawImage(img_clicks_On[i], button_clicks[i].x, button_clicks[i].y, button_clicks[i].width, button_clicks[i].height, null);
            } else {
                g.drawImage(img_clicks_Off[i], button_clicks[i].x, button_clicks[i].y, button_clicks[i].width, button_clicks[i].height, null);
            }
        }

        gameField.draw(g);

        if (status_clicks[BUTTON_PAUSE]) {
            return;
        }

        if (button_temp != null) {
            g.drawImage(img_Towers[temp], button_temp.x, button_temp.y, button_temp.width, button_temp.height, null);
            g.setColor(Color.DARK_GRAY);
            g.drawOval(button_temp.x + TILE_SIZE /2 - RANGE[temp], button_temp.y + TILE_SIZE /2 - RANGE[temp], 2* RANGE[temp], 2* RANGE[temp]);
        }

        if (can_put) g.setColor(Color.green);
        else g.setColor(Color.red);
        if (button_put != null) {
            g.drawRect(button_put.x-3, button_put.y-3, button_put.width+6, button_put.height+6);
        }

    }

    @Override
    public void run() {
        while(!thread_stage.isInterrupted()) {
            if (status_clicks[BUTTON_PAUSE]) {
                repaint();
                try {
                    thread_stage.sleep(1);
                } catch (Exception e) { }
                continue;
            }

            enemy_spawning();
            create_bullets();
            destroy_bullets();
            event_enemy_to_target();
            warning();

            if (status_clicks[BUTTON_AUTO]) {
                AutoPlaying.auto_play();
            }

            repaint();
            try {
                thread_stage.sleep(1);
            } catch (Exception e) { }
        }
        while (lose) {
            try {
                thread_stage.sleep(1);
            } catch (Exception e) { }
        }
    }

    public void warning() {
        for (int i = 0; i < enemies.size(); ++i) {
            for (int j = 0; j < 3; ++j) {
                if (road.get(j).contains(enemies.get(i).getCenterX(), enemies.get(i).getCenterY())) {
                    status_sound_effects[WARNING] = true;
                    return;
                }
            }
        }
    }

    public void create_bullets() {
        for (int i = 0;i < towers.size(); ++i) {
            for (int j = 0; j < enemies.size(); ++j) {
                if (towers.get(i).inRange(enemies.get(j))) {
                    towers.get(i).shoot(enemies.get(j));
                    break;
                }
            }
        }
    }

    public void destroy_bullets() {
        for (int i = 0; i < bullets.size(); ++i) {
            if (!bullets.get(i).exist()) {
                bullets.remove(i);
                --i;
            }
        }
        for (int i = 0; i < enemies.size(); ++i) {
            for (int j = 0; j < bullets.size(); ++j) {
                if (enemies.get(i).contains((int)bullets.get(j).getX(), (int)bullets.get(j).getY())) {
                    enemies.get(i).subtractBlood_(bullets.get(j).getDamage_());
                    bullets.remove(j);
                    --j;
                }
            }
            if (enemies.get(i).getBlood_() <= 0) {
                coin += enemies.get(i).getREWARD_();
                status_sound_effects[DIE] = true;
                enemies.remove(i);
                ++kill;
                --i;
            }
        }
    }

    private int count = 0;
    public void enemy_spawning() {
        if (count < 200) {
            ++count;
            return;
        }
        if (enemies.size() > 10) return;
        if (rd.nextBoolean() && rd.nextBoolean() && rd.nextBoolean() && rd.nextBoolean()) {
            if (rd.nextBoolean()) {
                enemies.add(new NormalEnemy());
            } else if (rd.nextBoolean()) {
                enemies.add(new TankerEnemy());
            } else if (rd.nextBoolean()) {
                enemies.add(new SmallerEnemy());
            } else if (rd.nextBoolean()) {
                enemies.add(new BossEnemy());
            }
        }
        count = 0;
    }

    private boolean lose = false;
    public void event_enemy_to_target() {
        for (int i = 0; i < targets.size(); ++i) {
            for (int j = 0; j < enemies.size(); ++j) {
                if (targets.get(i).contains((Rectangle) enemies.get(j))) {
                    --heart;
                    enemies.remove(j);
                    --j;
                }
                if (heart == 0) {
                    lose = true;
                }
            }
        }
    }

    public void eventMouseClick(){
        if (button_clicks[BUTTON_SELL].contains(p_mouse)) {
            status_sound_effects[CLICK] = true;
            coin += towers.get(id_tower_show).getPRICE_()/5;
            for (int i = 0; i < mountain.size(); ++i) {
                if (mountain.get(i).contains(towers.get(id_tower_show).getCenterX(), towers.get(id_tower_show).getCenterY())) {
                    mountain.get(i).setEmpty(true);
                }
            }
            status_sound_effects[DESTROY] = true;
            towers.remove(id_tower_show);
            id_tower_show = -1;
            button_clicks[BUTTON_SELL].setBounds(0, 0, 0, 0);
            repaint();
            return;
        } else if (button_clicks[BUTTON_EXIT].contains(p_mouse)) {
            status_sound_effects[CLICK] = true;
            this.setVisible(false);
            mainScreen.setVisible(true);
            thread_stage.suspend();
            thread_main.resume();
        } else if (button_clicks[BUTTON_AUTO].contains(p_mouse.x, p_mouse.y)) {
            status_sound_effects[CLICK] = true;
            status_clicks[BUTTON_AUTO] = !status_clicks[BUTTON_AUTO];
        } else if (button_clicks[BUTTON_PAUSE].contains(p_mouse.x, p_mouse.y)) {
            status_sound_effects[CLICK] = true;
            status_clicks[BUTTON_PAUSE] = !status_clicks[BUTTON_PAUSE];
        } else if (button_clicks[BUTTON_SOUND].contains(p_mouse.x, p_mouse.y)) {
            status_sound_effects[CLICK] = true;
            status_clicks[BUTTON_SOUND] = !status_clicks[BUTTON_SOUND];
        } else {
            id_tower_show = -1;
        }
        for (int i = 0; i < towers.size(); ++i) {
            if (towers.get(i).contains(p_mouse)) {
                status_sound_effects[CLICK] = true;
                id_tower_show = i;
                return;
            }
        }
        repaint();
    }

    public void eventMousePressed() {
        if (temp == -1 && !status_clicks[BUTTON_PAUSE]) {
            for (int i = 0; i < TOWER_TYPES; ++i) {
                if (coin < PRICE[i]) continue;
                if (button_towers[i].contains(p_mouse.x, p_mouse.y)) {
                    button_temp = new Rectangle(button_towers[i].getBounds());
                    temp = i;
                    break;
                }
            }
        }
        if (button_temp != null) {
            button_temp.setLocation(p_mouse.x - BUTTON_STORE_SIZE /2, p_mouse.y - BUTTON_STORE_SIZE /2);
        }
        repaint();
    }

    public void eventMouseDragged() {
        id_tower_show = -1;
        if (button_temp != null) {
            button_temp.setLocation(p_mouse.x - BUTTON_STORE_SIZE /2, p_mouse.y - BUTTON_STORE_SIZE /2);
            button_put = null;
            can_put = false;
            for (int i = 0; i < road.size(); ++i) {
                if (road.get(i).contains(p_mouse.x, p_mouse.y)) {
                    button_put = new Rectangle(road.get(i));
                }
            }
            for (int i = 0; i < mountain.size(); ++i) {
                if (mountain.get(i).contains(p_mouse.x, p_mouse.y)) {
                    button_put = new Rectangle(mountain.get(i));
                    if (mountain.get(i).getEmpty()) {
                        can_put = true;
                    }
                }
            }
        }
        repaint();
    }

    public void eventMouseReleased() {
        if (temp != -1) {
            for (int i = 0; i < mountain.size(); ++i) {
                if (mountain.get(i).contains(p_mouse.x, p_mouse.y) && can_put) {
                    if (temp == NORMAL_TOWER && coin >= PRICE[NORMAL_TOWER]) {
                        button_temp = new NormalTower();
                    } else if (temp == SNIPER_TOWER && coin >= PRICE[SNIPER_TOWER]) {
                        button_temp = new SniperTower();
                    } else if (coin >= PRICE[MACHINEGUN_TOWER]) {
                        button_temp = new MachineGunTower();
                    }
                    if (!(button_temp instanceof Tower)) break;
                    button_temp.setBounds(mountain.get(i).getBounds());
                    towers.add((Tower)button_temp);
                    mountain.get(i).setEmpty(false);
                    coin -= towers.get(towers.size()-1).getPRICE_();
                }
            }
            button_put = null;
            can_put = false;
            button_temp = null;
            temp = -1;
        }
        repaint();
    }
}
