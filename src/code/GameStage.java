package code;


import code.GameEnity.GameTile.Tower.MachineGunTower;
import code.GameEnity.GameTile.Tower.NormalTower;
import code.GameEnity.GameTile.Tower.SniperTower;
import code.GameEnity.GameTile.Tower.Tower;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class GameStage extends JPanel implements Runnable{
    public GameStage() {
        init();
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

        button_menu = new Rectangle(0, 0, 2* SPACE_ABOVE, SPACE_ABOVE);
        img_menu0 = new ImageIcon("Image/buttonmenu0.png").getImage();
        img_menu = new ImageIcon("Image/buttonmenu.png").getImage();

        thread_stage = new Thread(this);
        thread_stage.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        g.drawImage(img_menu0, button_menu.x, button_menu.y, button_menu.width, button_menu.height, null);
        if (button_menu.contains(p_mouse))
            g.drawImage(img_menu, button_menu.x, button_menu.y, button_menu.width, button_menu.height, null);

        gameField.draw(g);

        if (button_temp != null) {
            g.drawImage(img_Tower[temp], button_temp.x, button_temp.y, button_temp.width, button_temp.height, null);
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
        while(true) {
            coins++;

            event_enemy_spawning();
            event_create_bullets();
            event_destroy_bullets();
            event_enemy_to_target();

            repaint();
            try {
                thread_stage.sleep(1);
            } catch (Exception e) { }
        }
    }

    public void event_create_bullets() {
        for (int i = 0;i < towers.size(); ++i) {
            for (int j = 0; j < enemies.size(); ++j) {
                if (towers.get(i).inRange(enemies.get(j))) {
                    towers.get(i).shoot(enemies.get(j));
                    break;
                }
            }
        }
    }

    public void event_destroy_bullets() {
        for (int i = 0; i < bullets.size(); ++i) {
            if (!bullets.get(i).exist()) {
                bullets.remove(i);
                --i;
            }
        }
        for (int i = 0; i < enemies.size(); ++i) {
            for (int j = 0; j < bullets.size(); ++j) {
                if (enemies.get(i).contains((int)bullets.get(j).getX(), (int)bullets.get(j).getY())) {
                    enemies.get(i).subtractBlood_(bullets.get(i).getDamage_());
                    bullets.remove(j);
                    --j;
                }
            }
            if (enemies.get(i).getBlood_() <= 0) {
                coins += enemies.get(i).getREWARD_();
                enemies.remove(i);
                --i;
            }
        }
    }

    public void event_enemy_spawning() {

    }

    public void event_enemy_to_target() {
        for (int i = 0; i < targets.size(); ++i) {
            for (int j = 0; j < enemies.size(); ++j) {
                if (targets.get(i).contains((Rectangle) enemies.get(j))) {
                    --heart;
                    enemies.remove(j);
                    --j;
                }
            }
        }
    }

    public void eventMouseClick(){
        if (button_menu.contains(p_mouse.x, p_mouse.y)) {
            this.setVisible(false);
            mainScreen.setVisible(true);
            thread_stage.suspend();
            thread_main.resume();
        }
    }

    public void eventMousePressed() {
        if (temp == -1) {
            for (int i = 0; i < TOWER_TYPES; ++i) {
                if (coins< PRICE[i]) continue;
                if (button_store[i].contains(p_mouse.x, p_mouse.y)) {
                    if (i == 0) {
                        button_temp = new NormalTower();
                    } else if (i == 1) {
                        button_temp = new SniperTower();
                    } else if (i == 2) {
                        button_temp = new MachineGunTower();
                    }
                    button_temp.setBounds(button_store[i].getBounds());
                    temp = i;
                    break;
                }
            }
        }
        if (button_temp != null) {
            button_temp.setLocation(p_mouse.x - BUTTON_STORE_SIZE /2, p_mouse.y - BUTTON_STORE_SIZE /2);
            repaint();
        }
    }

    public void eventMouseDragged() {
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

            repaint();
        }
    }

    public void eventMouseReleased() {
        if (temp != -1) {
            for (int i = 0; i < mountain.size(); ++i) {
                if (mountain.get(i).contains(p_mouse.x, p_mouse.y) && can_put) {
                    button_temp.setLocation(mountain.get(i).x, mountain.get(i).y);
                    towers.add((Tower) button_temp);
                    mountain.get(i).setEmpty(false);
                    coins -= PRICE[temp];
                }
            }
            button_put = null;
            can_put = false;
            button_temp = null;
            temp = -1;
        }
    }
}
