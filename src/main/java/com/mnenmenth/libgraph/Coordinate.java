package com.mnenmenth.libgraph;

/**
 * Converts unit coordinates to pixel points and vice versa
 *
 * @author Earl Kennedy
 * @author https://github.com/Mnenmenth
 */


public class Coordinate {

    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("libgraph.Coordinate[%s,%s]", getX(), getY());
    }

    public Coordinate add(Coordinate c) {
        return new Coordinate(
                x + c.getX(),
                y + c.getY()
        );
    }

    public Coordinate sub(Coordinate c) {
        return new Coordinate(
                x - c.getX(),
                y - c.getY()
        );
    }

    public Coordinate mult(Coordinate c) {
        return new Coordinate(
                x * c.getX(),
                y * c.getY()
        );
    }

    public Coordinate div(Coordinate c) {
        return new Coordinate(
                x / c.getX(),
                y / c.getY()
        );
    }
}
