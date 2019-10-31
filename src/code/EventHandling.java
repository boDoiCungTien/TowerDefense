package code;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import static code.Config.*;

public class EventHandling implements MouseListener, MouseMotionListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (mainScreen.isVisible())
            mainScreen.eventMouseClick();
        if (gameStage != null && gameStage.isVisible())
            gameStage.eventMouseClick();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventMousePressed();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventMouseReleased();
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
            gameStage.eventMouseDragged();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p_mouse.x = e.getX();
        p_mouse.y = e.getY();

    }
}
