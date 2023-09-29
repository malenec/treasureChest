package org.abstractica.javacsgmodules.Box;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class BottomBox {

    private double zSize = 7.0;
    private double holeSize = 2.6;
    private double holeXDist = 21.0;
    private double holeYDist = 43.4;

    public BottomBox(JavaCSG csg) {
    }


    public Geometry3D bottomBox (JavaCSG csg){
        Geometry3D outerBottomBox = csg.box3D(90, 60, 50, false);
        Geometry3D innerBottomBox = csg.box3D(88, 58, 48, false);
        Geometry3D bottomBox = csg.difference3D(outerBottomBox, innerBottomBox);
        return bottomBox;
    }


    public Geometry3D getHoles(JavaCSG csg)
    {
        Geometry3D hole = csg.cylinder3D(holeSize, zSize+2, 32, false);
        hole = csg.translate3DZ(-1).transform(hole);
        Geometry3D hole1 = csg.translate3D(0.5*holeXDist, 0.5*holeYDist, 40).transform(hole);
        Geometry3D hole2 = csg.translate3D(-0.5*holeXDist, 0.5*holeYDist, 40).transform(hole);
        Geometry3D hole3 = csg.translate3D(0.5*holeXDist, -0.5*holeYDist, 40).transform(hole);
        Geometry3D hole4 = csg.translate3D(-0.5*holeXDist, -0.5*holeYDist, 40).transform(hole);
        hole = csg.union3D(hole1, hole2, hole3, hole4);
        return hole;
    }

    public static Geometry3D getMicroUSBHole(JavaCSG csg)
    {
        Geometry3D hole = csg.box3D(11.5, 2, 7.5, false);
        hole = csg.translate3DZ(-1).transform(hole);
        hole = csg.translate3D(0, 0, 40.5).transform(hole);
        hole = csg.translate3D(0, -29.5, 0).transform(hole);
        return hole;
    }


}
