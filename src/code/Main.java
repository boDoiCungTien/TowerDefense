package code;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static code.Config.*;

public class Main extends JPanel implements Runnable{
    public Main() {
        init();
        thread_main = new Thread(this);
        thread_main.start();
    }

    public static void main(String[] args) {
        mainScreen = new Main();
    }

    public void init() {
        frame = new JFrame("Tower Defence");
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocation(100, 100);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        this.setBounds(0, 0, frame.getSize().width, frame.getSize().height);
        this.setLayout(null);
        this.setVisible(true);
        main_EH = new EventHandling();
        this.addMouseListener(main_EH);
        this.addMouseMotionListener(main_EH);

        buttonStart = new Rectangle(225,350,120,50);
        buttonContinue = new Rectangle(420, 350, 120, 50);


        img_start = new ImageIcon("Image/buttonstart.png").getImage();
        img_start0 = new ImageIcon("Image/buttonstart0.png").getImage();
        img_continue = new ImageIcon("Image/buttoncontinue.png").getImage();
        img_continue0 = new ImageIcon("Image/buttoncontinue0.png").getImage();


        frame.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image i = new ImageIcon("Image/mainscreen.png").getImage();
        g.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);
        g.drawImage(img_start, buttonStart.x, buttonStart.y, buttonStart.width, buttonStart.height, null);
        g.drawImage(img_continue, buttonContinue.x, buttonContinue.y, buttonContinue.width, buttonContinue.height, null);
        if (!buttonStart.contains(p)) {
            g.drawImage(img_start0, buttonStart.x, buttonStart.y, buttonStart.width, buttonStart.height, null);
        }
        if (!buttonContinue.contains(p)) {
            g.drawImage(img_continue0, buttonContinue.x, buttonContinue.y, buttonContinue.width, buttonContinue.height, null);
        }
    }

    @Override
    public void run() {
        while(true) {
            repaint();
            try {
                thread_main.sleep(1);
            } catch (Exception e) {

            }
        }
    }

    public void eventClick(int flag) {
        if (flag == 1) {
            if (buttonStart.contains(p)) {
                if (thread_stage != null) thread_stage.stop();
                this.setVisible(false);
                thread_main.suspend();
                frame.add(new GameStage());
            }
            if (buttonContinue.contains(p)) {
                this.setVisible(false);
                thread_main.suspend();
                if (gameStage == null) {
                    frame.add(new GameStage());
                } else {
                    gameStage.setVisible(true);
                    thread_stage.resume();
                }
            }

        }
    }

}
