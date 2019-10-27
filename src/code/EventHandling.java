package code;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import static code.Config.*;

public class EventHandling implements MouseListener, MouseMotionListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (mainScreen.isVisible())
            mainScreen.eventClick();
        if (gameStage != null && gameStage.isVisible())
            gameStage.eventClick();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        p_mouse.x = e.getX();
        p_mouse.y = e.getY();
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventPressed();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        p_mouse.x = e.getX();
        p_mouse.y = e.getY();
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventReleased();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        p_mouse.x = e.getX();
        p_mouse.y = e.getY();
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventDragged();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p_mouse.x = e.getX();
        p_mouse.y = e.getY();

    }
}
