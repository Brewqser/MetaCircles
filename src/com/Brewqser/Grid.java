package com.Brewqser;

import java.awt.*;
import static com.Brewqser.MetaCircles.*;

public class Grid {

    private double grid[][];
    private int xsize = 0;
    private int ysize = 0;
    private boolean fill = false;

    public Grid(int w, int h ,boolean fill){
        xsize = (int)(Math.ceil((double)w/(double)resolution)) + 1;
        ysize = (int)(Math.ceil((double)h/(double)resolution)) + 1;
        grid = new double[ysize][xsize];
        this.fill = fill;

        for (int i=0;i<ysize;i++){
            for (int j=0;j<xsize;j++){
                grid[i][j] = 0;
            }
        }
    }

    public void draw(Graphics2D g2d){
        for (int i=0;i<ysize;i++){
            for (int j=0;j<xsize;j++){
                if (grid[i][j] > 1.0) {
                    if (this.fill) g2d.fillRect(j*resolution - resolution/2, i*resolution - resolution/2, resolution, resolution);
                    else g2d.draw(new Rectangle(j*resolution - resolution/2, i*resolution - resolution/2, resolution, resolution));
                }
            }
        }

    }

    public void update(Circle circles[]) {
        for (int i=0;i<ysize;i++){
            for (int j=0;j<xsize;j++){
                grid[i][j]=0;
                for (int c=0; c < circles.length; c++){
                    double licznik = (circles[c].cir.height/2) * (circles[c].cir.height/2);
                    double mianownik = (j*resolution - circles[c].cir.x - circles[c].cir.height/2) * (j*resolution - circles[c].cir.x - circles[c].cir.height/2)
                                     + (i*resolution - circles[c].cir.y - circles[c].cir.height/2) * (i*resolution - circles[c].cir.y - circles[c].cir.height/2);
                    grid[i][j] += licznik / mianownik;
                }
            }
        }
    }
}
