package com.ytx.example.performance.optionmization.buffer;


import javax.annotation.Nullable;
import java.awt.*;

/**
 * @author Rosan
 * @version 1.0
 * @date 2018/11/7
 */
public class BufferMovingCircle extends NoBufferMovingCircle {
    Graphics bufferedPaints;

    @Override
    public void init() {
        super.init();
        bufferedPaints = screenImage.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        bufferedPaints.setColor(Color.WHITE);
        bufferedPaints.fillRect(0, 0, 200, 100);
        drawCircle(g);
        g.drawImage(screenImage, 0, 0, this);
    }
}
