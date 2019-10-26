package code;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import static code.Config.*;

public class EventHandling implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (thread_main.isAlive()) {
            mainScreen.eventClick(e.getClickCount());
        }
        if (thread_stage.isAlive()) {
            gameStage.eventClick(e.getClickCount());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        p = new Point(e.getX(), e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p = new Point(e.getX(), e.getY());

    }
}
