package org.abstractica.javacsgmodules.Box;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class TopBox {


    public TopBox()
    {
    }

    public Geometry3D getTopBox(JavaCSG csg)
    {
        //outer box size
        Geometry3D outerTopBox = csg.box3D(95, 65, 20, false);

        //inner box size (cutout)
        Geometry3D innerTopBox = csg.box3D(90, 60, 15, false);
        innerTopBox = csg.translate3D(0, 0, 5).transform(innerTopBox);
        Geometry3D totalTopBox = csg.difference3D(outerTopBox, innerTopBox);

        return totalTopBox;
    }

    public Geometry3D getGribs(JavaCSG csg)
    {
        //outer circle
        Geometry2D circle2 = csg.circle2D(8.5, 360);
        Geometry3D ext2 = csg.linearExtrude( 4, false, circle2);

        //inner circle (cutout)
        Geometry2D circle = csg.circle2D(4.5, 64);
        Geometry3D ext = csg.linearExtrude( 4, false, circle);

        //pie (cutout)
        Geometry2D pie = csg.cutoutPie2D(11, csg.degrees(0), csg.degrees(60));
        pie = csg.rotate2D(csg.degrees(-180)).transform(pie);
        Geometry3D ext3 = csg.linearExtrude( 4, false, pie);

        //first grip
        Geometry3D grip = csg.difference3D(ext2, ext);
        grip = csg.difference3D(grip, ext3);
        grip = csg.rotate3DZ(csg.degrees(180)).transform(grip);

        //second grip
        Geometry3D grip2 = csg.translate3DZ(10).transform(grip);

        //the set of grips combined
        Geometry3D gribsCombined = csg.union3D(grip, grip2);
        gribsCombined = csg.rotate3DX(csg.degrees(90)).transform(gribsCombined);
        gribsCombined = csg.rotate3DZ(csg.degrees(90)).transform(gribsCombined);
        gribsCombined = csg.translate3D(10.5, 31.25, 22.25).transform(gribsCombined);

        //the second set of grips
        Geometry3D gribsCombined2 = csg.translate3D(-35, 0, 0).transform(gribsCombined);

        //the two sets of grips combined
        Geometry3D totalGribs = csg.union3D(gribsCombined, gribsCombined2);

        return totalGribs;
    }
}
