package com.mnenmenth.libgraph.test;

import com.mnenmenth.libgraph.Coordinate;
import com.mnenmenth.libgraph.Graph;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(new Dimension(1920, 1080), 100, -100, 100, -100);
        System.out.println(g.c2p(new Coordinate(100,0)));
        System.out.println(g.p2c(new Point(960, 540)));
    }
}
