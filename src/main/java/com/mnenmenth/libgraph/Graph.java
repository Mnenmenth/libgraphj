package com.mnenmenth.libgraph;

import java.awt.*;

/**
 * Converts unit coordinates to pixel points and vice versa
 *
 * @author Earl Kennedy
 * @author https://github.com/Mnenmenth
 * @author https://mnenmenth.com
 */


public class Graph {

    private Dimension parentDim;
    private int xmax;
    private int xmin;
    private int ymax;
    private int ymin;

    /**
     * Returns a graph object that can be used to convert Coordinates into
     * points and vice-versa
     * @param parentDim Parent screen bounds
     * @param xmax x maximum on graph
     * @param xmin x minimum on graph (can be positive #)
     * @param ymax y maximum on graph
     * @param ymin y minimum on graph (can be positive #)
     */

    public Graph(Dimension parentDim, int xmax, int xmin, int ymax, int ymin) {
        this.parentDim = parentDim;
        this.xmax = xmax;
        this.xmin = xmin;
        this.ymax = ymax;
        this.ymin = ymin;
    }

    /**
     * Returns parent dimension
     * @return parentDimension
     * @see Dimension
     */
    public Dimension getParentDim() {
        return parentDim;
    }

    /**
     * Sets parent dimension
     * @param parentDim New parent dimension
     * @see Dimension
     */
    public void setParentDim(Dimension parentDim) {
        this.parentDim = parentDim;
    }

    /**
     * Returns x maximum for graph
     * @return xmax
     */
    public int getXmax() {
        return xmax;
    }

    /**
     * Sets x maximum for graph
     * @param xmax x maximum
     */
    public void setXmax(int xmax) {
        this.xmax = xmax;
    }

    /**
     * Returns x minimum for graph
     * @return xmin
     */
    public int getXmin() {
        return xmin;
    }

    /**
     * Sets x minimum for graph
     * @param xmin x minimum
     */
    public void setXmin(int xmin) {
        this.xmin = xmin;
    }

    /**
     * Returns y maximum for graph
     * @return ymax
     */
    public int getYmax() {
        return ymax;
    }

    /**
     * Sets y maximum for graph
     * @param ymax y maximum
     */
    public void setYmax(int ymax) {
        this.ymax = ymax;
    }

    /**
     * Returns y minimum for graph
     * @return ymin
     */
    public int getYmin() {
        return ymin;
    }

    /**
     * Sets y minimum for graph
     * @param ymin y minimum
     */
    public void setYmin(int ymin) {
        this.ymin = ymin;
    }

    /**
     * Number of integer units the graph contains on x axis
     * @return integers on x axis
     */
    public double xunits() {
        return (xmax < 0 ? -xmax : xmax) + (xmin < 0 ? -xmin : xmin);
    }

    /**
     * Pixel size of one unit on x axis
     * @return size of one unit on x in pixels
     */
    public double xtick() {
        return parentDim.width/xunits();
    }

    /**
     * Number of integer units the graph contains on y axis
     * @return integers on y axis
     */
    public double yunits() {
        return (ymax < 0 ? -ymax : ymax) + (ymin < 0 ? -ymin : ymin);
    }

    /**
     * Pixel size of one unit on y axis
     * @return of one unit on y axis in pixels
     */
    public double ytick() {
        return parentDim.height/yunits();
    }

    /**
     * Converts a {@link Coordinate} to a {@link Point}
     * @param c Unit coordinate
     * @return Pixel point
     * @see Coordinate
     * @see Point
     */
    public Point coordinateToPixelPoint(Coordinate c) {
        return new Point(
                (int) Math.round((c.getX() + (xmin < 0 ? -xmin : xmin)) * xtick()),
                (int) Math.round((-c.getY() + (ymin < 0 ? -ymin : ymin)) * ytick())
        );
    }

    /**
     * Shorter name for coordinateToPixelPoint
     * @see #coordinateToPixelPoint(Coordinate)
     */
    public Point c2p(Coordinate c) { return coordinateToPixelPoint(c); }

    /**
     * Converts a {@link Point} to a {@link Coordinate}
     * @param p Pixel point
     * @return Unit coordinate
     * @see Point
     * @see Coordinate
     */
    public Coordinate pixelPointToCoordinate(Point p) {
        return new Coordinate(
                (p.getX() / (double) xtick()) - (xmin < 0 ? -xmin : xmin),
                (p.getY() / (double) ytick()) - (ymin < 0 ? -ymin : ymin)
        );
    }

    /**
     * Shorter name for pixelPointToCoordinate
     * @see #pixelPointToCoordinate(Point)
     */
    public Coordinate p2c(Point p) { return pixelPointToCoordinate(p); }

}
