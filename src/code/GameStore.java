package code;

import code.GameEnity.GameTile.Tower.MachineGunTower;
import code.GameEnity.GameTile.Tower.NormalTower;
import code.GameEnity.GameTile.Tower.SniperTower;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static code.Config.*;

public class GameStore {
    public Image image, img;
    public GameStore() {
        init();
    }

    public void init() {
        image = new ImageIcon("Image/a.png").getImage();
        coins = 100;
        heart = 10;
        button_heart = new Rectangle(100, (menu_size-size_of_button_store/2)/2, size_of_button_store/2, size_of_button_store/2);
        button_coins = new Rectangle(200, (menu_size-size_of_button_store/2)/2, size_of_button_store/2, size_of_button_store/2);

        button_store = new Rectangle[numbers_of_tower];
        for (int i = 0; i < numbers_of_tower; ++i) {
            button_store[i] = new Rectangle((SCREEN_WIDTH - numbers_of_tower*(size_of_button_store+space_of_buttons))/2 + i*(size_of_button_store+space_of_buttons), menu_size + field_height*block_size + space_of_buttons, size_of_button_store, size_of_button_store);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < numbers_of_tower; ++i) {
            g.fillRect(button_store[i].x, button_store[i].y, button_store[i].width, button_store[i].height);
            if (coins >= price[i]) {
                g.drawImage(img_Tower[i], button_store[i].x, button_store[i].y, button_store[i].width, button_store[i].height, null);
            }
        }

        g.setColor(Color.red);
        g.drawRect(button_heart.x, button_heart.y, button_heart.width, button_heart.height);
        g.drawRect(button_coins.x, button_coins.y, button_coins.width, button_coins.height);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        g.setColor(Color.white);
        g.drawString("" + heart, button_heart.x + size_of_button_store/2 + 5, button_heart.y + 15);
        g.drawString("" + coins, button_coins.x + size_of_button_store/2 + 5, button_coins.y + 15);
    }
}
