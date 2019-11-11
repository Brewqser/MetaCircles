package com.Brewqser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MetaCircles extends JPanel
        implements ActionListener {

    private Circle[] circles;
    private Grid grid;
    private int number_of_circles = 0;
    final public static double maxCircleVel = 2;
    final public static double minCircleVel = -2;
    final public static int resolution = 2;

    private final int DELAY = 15;

    private Timer timer;

    public MetaCircles(int w, int h, int noc) {
        number_of_circles = noc;

        initSurface();
        initCircles(w, h);
        initGrid(w, h);
    }

    private void initSurface() {
        setBackground(Color.black);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initCircles(int w, int h){
        circles = new Circle[number_of_circles];

        createCircles(w, h);
    }

    private void initGrid(int w, int h){
        grid = new Grid(w, h,true);
    }

    private void createCircles(int w, int h){
        int radiusMax = 150;
        int radiusMin = 70;

        for(int i = 0; i < number_of_circles ; i++){
                circles[i] = new Circle(w, h , radiusMax, radiusMin, false);
        }
    }

    private void drawCircles(Graphics2D g2d){
        g2d.setColor(Color.red);
        for (int i = 0; i < number_of_circles; i++) { circles[i].draw(g2d); }
    }

    private void drawGrid(Graphics2D g2d){
        g2d.setColor(Color.green);
        grid.draw(g2d);
    }

    private void updateCircles(Graphics2D g2d){
        Dimension size = getSize();
        for (int i = 0; i < number_of_circles; i++) { circles[i].update(size.width,size.height); }
    }

    private void updateGrid(){
        grid.update(circles);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Serif", Font.PLAIN, 40);
        g2d.setFont(font);

        updateCircles(g2d);
        updateGrid();

        drawGrid(g2d);
//        drawCircles(g2d);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}