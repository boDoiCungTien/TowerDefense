package code;


import javax.swing.*;
import java.awt.*;

import static code.Config.*;

public class MainScreen extends JPanel implements Runnable{
    public MainScreen() {
        init();

        sound = new Sound();

        status_clicks[BUTTON_SOUND] = true;

        thread_main = new Thread(this);
        thread_main.start();
    }

    public static void main(String[] args) {
        mainScreen = new MainScreen();
    }

    public void init() {
        frame = new JFrame("Tower Defense");
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

        button_clicks[BUTTON_NEW] = new Rectangle(420,300,120,80);
        button_clicks[BUTTON_CONTINUE] = new Rectangle(550, 380, 150, 80);

        img_clicks_Off[BUTTON_NEW] = new ImageIcon("Image/New_black.png").getImage();
        img_clicks_Off[BUTTON_CONTINUE] = new ImageIcon("Image/Continue_black.png").getImage();

        img_clicks_On[BUTTON_NEW] = new ImageIcon("Image/New_red.png").getImage();
        img_clicks_On[BUTTON_CONTINUE] = new ImageIcon("Image/Continue_red.png").getImage();

        frame.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image i = new ImageIcon("Image/mainscreen.png").getImage();
        g.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);

        g.drawImage(img_clicks_Off[BUTTON_NEW], button_clicks[BUTTON_NEW].x, button_clicks[BUTTON_NEW].y, button_clicks[BUTTON_NEW].width, button_clicks[BUTTON_NEW].height, null);
        if (button_clicks[BUTTON_NEW].contains(p_mouse)) {
            g.drawImage(img_clicks_On[BUTTON_NEW], button_clicks[BUTTON_NEW].x, button_clicks[BUTTON_NEW].y, button_clicks[BUTTON_NEW].width, button_clicks[BUTTON_NEW].height, null);
        }

        g.drawImage(img_clicks_Off[BUTTON_CONTINUE], button_clicks[BUTTON_CONTINUE].x, button_clicks[BUTTON_CONTINUE].y, button_clicks[BUTTON_CONTINUE].width, button_clicks[BUTTON_CONTINUE].height, null);
        if (button_clicks[BUTTON_CONTINUE].contains(p_mouse)) {
            g.drawImage(img_clicks_On[BUTTON_CONTINUE], button_clicks[BUTTON_CONTINUE].x, button_clicks[BUTTON_CONTINUE].y, button_clicks[BUTTON_CONTINUE].width, button_clicks[BUTTON_CONTINUE].height, null);
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

    public void eventMouseClick() {
        if (button_clicks[BUTTON_NEW].contains(p_mouse)) {
            status_sound_effects[CLICK] = true;
            if (thread_stage != null) thread_stage.stop();
            this.setVisible(false);
            thread_main.suspend();
            frame.add(new GameStage());
        }
        if (button_clicks[BUTTON_CONTINUE].contains(p_mouse)) {
            status_sound_effects[CLICK] = true;
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
