package com.Brewqser;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import static com.Brewqser.MetaCircles.*;

public class Circle {
    private double xVel = 0;
    private double yVel = 0;
    private boolean fill = false;

    public Ellipse2D.Double cir;

    public Circle(int w, int h, int sizeMin, int sizeMax, boolean fill){
        this.fill = fill;

        Random generator = new Random();
        double size = generator.nextDouble() * (sizeMax - sizeMin) + sizeMin;

        double cirX = generator.nextDouble() * (w - (size));
        double cirY = generator.nextDouble() * (h - (size));

        cir = new Ellipse2D.Double(cirX, cirY, size, size);

        xVel = generator.nextDouble() * (maxCircleVel - minCircleVel) + minCircleVel;
        yVel = generator.nextDouble() * (maxCircleVel - minCircleVel) + minCircleVel;
    }

    public void draw(Graphics2D g2d){
        if (fill) g2d.fill(cir);
        else g2d.draw(cir);
    }

    public void update(int w, int h) {
        cir.x += xVel;
        cir.y += yVel;

        if (cir.x <= 0 || cir.x + cir.width>= w) xVel *= -1;
        if (cir.y <= 0 || cir.y + cir.height >= h) yVel *= -1;
    }
}
