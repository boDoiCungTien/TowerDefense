package code;

import code.GameEnity.GameTile.Tower.NormalTower;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import static code.Config.*;

public class EventHandling implements MouseListener, MouseMotionListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (mainScreen.isVisible())
            mainScreen.eventClick(e.getButton());
        if (gameStage != null && gameStage.isVisible())
            gameStage.eventClick(e.getButton());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        p.x = e.getX();
        p.y = e.getY();
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventPressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventReleased(e);
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
        p.x = e.getX();
        p.y = e.getY();
        if (gameStage != null && gameStage.isVisible()) {
            gameStage.eventDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p.x = e.getX();
        p.y = e.getY();

    }
}
