package code;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class GameStore {
    public GameStore() {
        init();
    }

    public void init() {
        coins = 100;
        heart = 10;
        button_heart = new Rectangle(100, (SPACE_ABOVE - BUTTON_STORE_SIZE /2)/2, BUTTON_STORE_SIZE /2, BUTTON_STORE_SIZE /2);
        button_coins = new Rectangle(200, (SPACE_ABOVE - BUTTON_STORE_SIZE /2)/2, BUTTON_STORE_SIZE /2, BUTTON_STORE_SIZE /2);

        img_Tower[0] = new ImageIcon("Image/NormalTower.png").getImage();
        img_Tower[1] = new ImageIcon("Image/SniperTower.png").getImage();
        img_Tower[2] = new ImageIcon("Image/MachineGunTower.png").getImage();

        button_store = new Rectangle[TOWER_TYPES];
        for (int i = 0; i < TOWER_TYPES; ++i) {
            button_store[i] = new Rectangle((SCREEN_WIDTH - TOWER_TYPES *(BUTTON_STORE_SIZE + SPACE))/2 + i*(BUTTON_STORE_SIZE + SPACE), SPACE_ABOVE + FIELD_ROWS * TILE_SIZE + SPACE, BUTTON_STORE_SIZE, BUTTON_STORE_SIZE);
        }


    }

    public void draw(Graphics g) {
        for (int i = 0; i < TOWER_TYPES; ++i) {
            g.setColor(Color.black);
            g.fillRect(button_store[i].x, button_store[i].y, button_store[i].width, button_store[i].height);
            g.setColor(Color.yellow);
            g.drawString("$" + PRICE[i], button_store[i].x, button_store[i].y + TILE_SIZE + g.getFont().getSize());
            if (coins >= PRICE[i]) {
                g.setColor(Color.white);
                g.fillRect(button_store[i].x, button_store[i].y, button_store[i].width, button_store[i].height);
                g.drawImage(img_Tower[i], button_store[i].x, button_store[i].y, button_store[i].width, button_store[i].height, null);
            }
        }

        g.setColor(Color.red);
        g.drawRect(button_heart.x, button_heart.y, button_heart.width, button_heart.height);
        g.drawRect(button_coins.x, button_coins.y, button_coins.width, button_coins.height);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        g.setColor(Color.white);
        g.drawString("" + heart, button_heart.x + BUTTON_STORE_SIZE /2 + 5, button_heart.y + 15);
        g.drawString("" + coins, button_coins.x + BUTTON_STORE_SIZE /2 + 5, button_coins.y + 15);
    }

}
