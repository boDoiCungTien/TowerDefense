package code;

import javazoom.jl.player.Player;

import java.awt.*;
import java.io.FileInputStream;

import static code.Config.*;
import static java.lang.Thread.sleep;

public class Sound implements Runnable{
    private Thread thread;
    public static Thread thread1;

    public Sound(){
        play_effects_warning();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            if (status_sound_effects[CLICK] && status_clicks[BUTTON_SOUND]) {
                play_effects_click();
            }
            if (status_sound_effects[SHOOT] && status_clicks[BUTTON_SOUND]) {
                play_effects_shoot();
            }
            if (status_sound_effects[DIE] && status_clicks[BUTTON_SOUND]) {
                play_effects_die();
            }
            if (status_sound_effects[BUILD] && status_clicks[BUTTON_SOUND]) {
                play_effects_build();
            }
            if (status_sound_effects[DESTROY] && status_clicks[BUTTON_SOUND]) {
                play_effects_destroy();
            }

            for (int i = 0; i < status_sound_effects.length; ++i) {
                status_sound_effects[i] = false;
            }

            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void play_effects_warning() {
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (status_clicks[BUTTON_SOUND] && status_sound_effects[WARNING]) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream("Sound/warning.mp3");
                            Player player = new Player(fileInputStream);
                            player.play();
                        } catch (Exception e) { }
                        status_sound_effects[WARNING] = false;
                    }
                    try {
                        thread1.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }

    public void play_effects_click() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream("Sound/click.mp3");
                    Player player = new Player(fileInputStream);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void play_effects_shoot() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream("Sound/shoot.mp3");
                    Player player = new Player(fileInputStream);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void play_effects_die() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream("Sound/die.mp3");
                    Player player = new Player(fileInputStream);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void play_effects_build() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream("Sound/construct.mp3");
                    Player player = new Player(fileInputStream);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void play_effects_destroy() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileInputStream fileInputStream = new FileInputStream("Sound/destroy.mp3");
                    Player player = new Player(fileInputStream);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}


