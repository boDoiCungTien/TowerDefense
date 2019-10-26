package code;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static code.Config.*;

public class Main extends JPanel{
    public Main() {
        init();
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

        buttonStart = new JButton("New Game");
        buttonStart.setBounds(rectButtonStart);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen.setVisible(false);
                frame.add(new GameStage());

            }
        });
        buttonContinue = new JButton("Continue");
        buttonContinue.setBounds(rectButtonContinue);
        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen.setVisible(false);
                gameStage.myShow(true);
            }
        });
        this.add(buttonStart);
        buttonStart.setBounds(rectButtonStart);
        this.add(buttonContinue);
        buttonContinue.setBounds(rectButtonContinue);
        frame.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image i = new ImageIcon("Image/mainscreen.png").getImage();
        g.drawImage(i, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
