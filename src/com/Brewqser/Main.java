package com.Brewqser;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private final int NUMBER_OF_CIRCLES = 20;
    private final int win_width = 1000;
    private final int win_height = 800;

    public Main() {
        initUI();
    }

    private void initUI() {
        add(new MetaCircles(984, 761, NUMBER_OF_CIRCLES));

        setTitle("Meta Circles");
        setSize( 1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Main ma = new Main();
                ma.setVisible(true);
            }
        });
    }
}