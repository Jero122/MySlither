package de.mat2095.my_slither;


import java.awt.*;
class Food {

    final int x, y;
    private final double size;
    private final double rsp;
    private final long spawnTime;
    private Color colour;

    Food(int x, int y, double size, boolean fastSpawn, Color colour) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        this.colour = colour;
        spawnTime = System.currentTimeMillis();
    }

    double getSize() {
        return size;
    }
    public Color getColour(){return colour;}

    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }
}
