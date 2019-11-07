package code;

import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class GameStore {
    public GameStore() {
        init();
    }

    public void init() {
        coin = 250;
        heart = 10;
        kill = 0;
        score = 0;

        button_info[BUTTON_HEART] = new Rectangle(200, (SPACE_ABOVE - BUTTON_STORE_SIZE /2)/2, BUTTON_STORE_SIZE /2, BUTTON_STORE_SIZE /2);
        button_info[BUTTON_COIN] = new Rectangle(300, (SPACE_ABOVE - BUTTON_STORE_SIZE /2)/2, BUTTON_STORE_SIZE /2, BUTTON_STORE_SIZE /2);
        button_info[BUTTON_KILL] =  new Rectangle(400, (SPACE_ABOVE - BUTTON_STORE_SIZE /2)/2, BUTTON_STORE_SIZE /2, BUTTON_STORE_SIZE /2);

        img_info[BUTTON_HEART] = new ImageIcon("Image/Heart.png").getImage();
        img_info[BUTTON_COIN] = new ImageIcon("Image/Coin.png").getImage();
        img_info[BUTTON_KILL] = new ImageIcon("Image/kill.png").getImage();

        for (int i = 0; i < TOWER_TYPES; ++i) {
            button_towers[i] = new Rectangle((SCREEN_WIDTH - TOWER_TYPES *(BUTTON_STORE_SIZE + SPACE))/2 + i*(BUTTON_STORE_SIZE + SPACE), SPACE_ABOVE + FIELD_ROWS * TILE_SIZE + SPACE, BUTTON_STORE_SIZE, BUTTON_STORE_SIZE);
        }

    }

    public void draw(Graphics g) {
        for (int i = 0; i < TOWER_TYPES; ++i) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(button_towers[i].x, button_towers[i].y, button_towers[i].width, button_towers[i].height);
            g.setColor(Color.yellow);
            g.drawString("$" + PRICE[i], button_towers[i].x, button_towers[i].y + TILE_SIZE + g.getFont().getSize());
            if (coin >= PRICE[i]) {
                g.setColor(Color.gray);
                g.fillRect(button_towers[i].x, button_towers[i].y, button_towers[i].width, button_towers[i].height);
                g.drawImage(img_Towers[i], button_towers[i].x, button_towers[i].y, button_towers[i].width, button_towers[i].height, null);
            }
        }

        g.drawImage(img_info[BUTTON_HEART], button_info[BUTTON_HEART].x, button_info[BUTTON_HEART].y, button_info[BUTTON_HEART].width, button_info[BUTTON_HEART].height, null);
        g.drawImage(img_info[BUTTON_COIN], button_info[BUTTON_COIN].x, button_info[BUTTON_COIN].y, button_info[BUTTON_COIN].width, button_info[BUTTON_COIN].height, null);
        g.drawImage(img_info[BUTTON_KILL], button_info[BUTTON_KILL].x, button_info[BUTTON_KILL].y, button_info[BUTTON_KILL].width, button_info[BUTTON_KILL].height, null);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        g.setColor(Color.white);
        g.drawString("" + heart, button_info[BUTTON_HEART].x + BUTTON_STORE_SIZE /2 + SPACE, button_info[BUTTON_HEART].y + 3*SPACE);
        g.drawString("" + coin, button_info[BUTTON_COIN].x + BUTTON_STORE_SIZE /2 + SPACE, button_info[BUTTON_COIN].y + 3*SPACE);
        g.drawString("" + kill, button_info[BUTTON_KILL].x + BUTTON_STORE_SIZE /2 + SPACE, button_info[BUTTON_KILL].y + 3*SPACE);
        g.drawString("score: " + score, 500, (SPACE_ABOVE - BUTTON_STORE_SIZE /2)/2 + 3*SPACE);
    }

}
