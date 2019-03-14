package com.ytx.example.performance.optionmization.buffer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class NoBufferMovingCircle extends JApplet implements Runnable {
    Image screenImage = null;
    Thread thread;
    int x1 = 5;
    int move = 1;

    @Override
    public void init() {
        screenImage = createImage(230, 160);
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                x1 += move;
                if (x1 > 105 || x1 < 5) {
                    move *= -1;
                }
                repaint();
                Thread.sleep(10);
            }
        } catch (Exception e) {

        }
    }
    public void drawCircle(Graphics gc){
        Graphics2D g = (Graphics2D)gc;
        g.setColor(Color.GREEN);
        g.fillRect(0,0,200,100);
        g.setColor(Color.RED);
        g.fillOval(x1,5,90,90);
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,200,100);
        drawCircle(g);
    }
}
