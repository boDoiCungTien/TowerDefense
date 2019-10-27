package code;


import code.GameEnity.GameTile.Tower.MachineGunTower;
import code.GameEnity.GameTile.Tower.NormalTower;
import code.GameEnity.GameTile.Tower.SniperTower;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class GameStage extends JPanel implements Runnable{
    private boolean isFirst = true;
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
        thread_stage = new Thread(this);
        thread_stage.start();

    }

    public void define() {
        gameField = new GameField();
        gameStore = new GameStore();

        button_menu = new Rectangle(0, 0, 2*menu_size, menu_size);

        img_menu0 = new ImageIcon("Image/buttonmenu0.png").getImage();
        img_menu = new ImageIcon("Image/buttonmenu.png").getImage();
        img_Tower[0] = new ImageIcon("Image/NomarTower.png").getImage();
        img_Tower[1] = new ImageIcon("Image/SniperTower.png").getImage();
        img_Tower[2] = new ImageIcon("Image/MachineGunTower.png").getImage();

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isFirst) {
            define();
            isFirst = false;
        }

        g.setColor(Color.gray);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        g.drawImage(img_menu0, button_menu.x, button_menu.y, button_menu.width, button_menu.height, null);
        if (button_menu.contains(p_mouse)) g.drawImage(img_menu, button_menu.x, button_menu.y, button_menu.width, button_menu.height, null);
        gameField.draw(g);
        gameStore.draw(g);

        for (int i = 0; i < normalTowers.size(); ++i) {
            normalTowers.get(i).draw(g);
        }
        for (int i = 0; i < sniperTowers.size(); ++i) {
            sniperTowers.get(i).draw(g);
        }
        for (int i = 0; i < machineGunTowers.size(); ++i) {
            machineGunTowers.get(i).draw(g);
        }

        if (button_temp != null) {
            g.drawImage(img_Tower[temp], button_temp.x, button_temp.y, button_temp.width, button_temp.height, null);
        }

        if (can_put) g.setColor(Color.green);
        else g.setColor(Color.red);
        if (button_put != null) {
            g.drawRect(button_put.x-5, button_put.y-5, button_put.width+10, button_put.height+10);
        }
    }

    @Override
    public void run() {
        while(!thread_stage.isInterrupted()) {
            coins++;

            repaint();
            try {
                thread_stage.sleep(1);
            } catch (Exception e) { }
        }
    }

    public void eventClick(){
        if (button_menu.contains(p_mouse.x, p_mouse.y)) {
            this.setVisible(false);
            mainScreen.setVisible(true);
            thread_stage.suspend();
            thread_main.resume();
        }
    }

    public void eventPressed() {
        if (temp == -1) {
            for (int i = 0; i < numbers_of_tower; ++i) {
                if (coins<price[i]) continue;
                if (button_store[i].contains(p_mouse.x, p_mouse.y)) {
                    button_temp = new Rectangle(button_store[i].getBounds());
                    temp = i;
                    break;
                }
            }
        }
        if (button_temp != null) {
            button_temp.setLocation(p_mouse.x - size_of_button_store/2, p_mouse.y - size_of_button_store/2);
            repaint();
        }
    }

    public void eventDragged() {
        if (button_temp != null) {
            button_temp.setLocation(p_mouse.x - size_of_button_store/2, p_mouse.y - size_of_button_store/2);
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

    public void eventReleased() {
        if (temp != -1) {
            for (int i = 0; i < mountain.size(); ++i) {
                if (mountain.get(i).contains(p_mouse.x, p_mouse.y) && can_put) {
                    if (temp == 0) {
                        normalTowers.add(new NormalTower(mountain.get(i).x, mountain.get(i).y, mountain.get(i).width, mountain.get(i).height));
                    } else if (temp == 1) {
                        sniperTowers.add(new SniperTower(mountain.get(i).x, mountain.get(i).y, mountain.get(i).width, mountain.get(i).height));
                    } else if (temp == 2) {
                        machineGunTowers.add(new MachineGunTower(mountain.get(i).x, mountain.get(i).y, mountain.get(i).width, mountain.get(i).height));
                    }
                    mountain.get(i).setEmpty(false);
                    coins -= price[temp];
                }
            }
            button_put = null;
            can_put = false;
            button_temp = null;
            temp = -1;
        }
    }


}
