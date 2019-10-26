package code;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static code.Config.*;

public class GameStage extends JPanel implements Runnable{
    private boolean isFirst = true;
    public GameStage() {
        init();
        myShow(true);
    }

    public void init() {
        this.setBounds(0, 0, frame.getSize().width, frame.getSize().height);
        this.setLayout(null);
        this.setVisible(true);
        this.addMouseListener(new EventHandling());
        this.addMouseMotionListener(new EventHandling());
        gameStage = this;
        thread = new Thread(this);
        thread.start();
    }

    public void define() {
        gameField = new GameField();
        gameStore = new GameStore();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isFirst) {
            define();
            isFirst = false;
        }

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        gameField.draw(g);
        gameStore.draw(g);
    }

    @Override
    public void run() {
        while(true) {

            repaint();
            try {
                thread.sleep(1);
            } catch (Exception e) {

            }
        }
    }

    public void myShow(boolean flag) {
        if (flag == true) {
            frame.add(this);
        } else {
            frame.remove(this);
        }
    }

}
