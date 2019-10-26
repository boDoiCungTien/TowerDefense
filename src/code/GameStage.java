package code;


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
        this.addMouseListener(new EventHandling());
        this.addMouseMotionListener(new EventHandling());
        gameStage = this;
        thread_stage = new Thread(this);
        thread_stage.start();

    }

    public void define() {
        gameField = new GameField();
        gameStore = new GameStore();
        button_menu = new Rectangle(0, 0, 2*menu_size, menu_size);
        img_menu = new ImageIcon("Image/buttonmenu.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isFirst) {
            define();
            isFirst = false;
        }

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        g.drawImage(img_menu, button_menu.x, button_menu.y, button_menu.width, button_menu.height, null);
        gameField.draw(g);
        gameStore.draw(g);
    }

    @Override
    public void run() {
        while(!thread_stage.isInterrupted()) {
            coins++;

            repaint();
            try {
                thread_stage.sleep(1);
            } catch (Exception e) {

            }
        }
    }

    public void eventClick(int flag){
        if (flag == 1) {
            if (button_menu.contains(p)) {
                thread_stage.suspend();
                this.setVisible(false);
                mainScreen.setVisible(true);
            }
        }
    }

}
