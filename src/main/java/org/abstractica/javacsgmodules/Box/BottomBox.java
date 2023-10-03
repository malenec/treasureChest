package org.abstractica.javacsgmodules.Box;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class BottomBox {

    private double zSize = 12.5;
    private double cylinderSize = 2.6;
    private double cylinderXDist = 21.0;
    private double cylinderYDist = 43.4;

    public BottomBox(JavaCSG csg)
    {
    }


    public Geometry3D getBottomBox (JavaCSG csg)
    {
        //outer box size
        Geometry3D outerBottomBox = csg.box3D(95, 65, 55, false);

        //inner box size (cutout)
        Geometry3D innerBottomBox = csg.box3D(90, 60, 50, false);
        innerBottomBox = csg.translate3D(0, 0, 5).transform(innerBottomBox);
        Geometry3D totalBottomBox = csg.difference3D(outerBottomBox, innerBottomBox);

        return totalBottomBox;
    }


    public Geometry3D getCylindersForNodeMCU(JavaCSG csg)
    {
        Geometry3D cylinders = csg.cylinder3D(cylinderSize, zSize, 360, false);
        cylinders = csg.translate3DZ(4.5).transform(cylinders);
        Geometry3D cylinder1 = csg.translate3D(0.5*cylinderXDist, 0.5*cylinderYDist, 0).transform(cylinders);
        Geometry3D cylinder2 = csg.translate3D(-0.5*cylinderXDist, 0.5*cylinderYDist, 0).transform(cylinders);
        Geometry3D cylinder3 = csg.translate3D(0.5*cylinderXDist, -0.5*cylinderYDist, 0).transform(cylinders);
        Geometry3D cylinder4 = csg.translate3D(-0.5*cylinderXDist, -0.5*cylinderYDist, 0).transform(cylinders);
        cylinders = csg.union3D(cylinder1, cylinder2, cylinder3, cylinder4);
        return cylinders;
    }

    public Geometry3D getMicroUSBHole(JavaCSG csg)
    {
        Geometry3D USBhole = csg.box3D(11.5, 2.5, 8.5, false);
        USBhole = csg.translate3D(0, 31.25, 5).transform(USBhole);
        return USBhole;
    }

    public Geometry3D getCylindersForGribs(JavaCSG csg)
    {
        //first cylinder for grip (the one on the plus side of the x-axis)
        Geometry3D cylinderForGrip = csg.cylinder3D(4, 15, 360, false);
        cylinderForGrip = csg.rotate3DX(csg.degrees(90)).transform(cylinderForGrip);
        cylinderForGrip = csg.rotate3DZ(csg.degrees(90)).transform(cylinderForGrip);
        cylinderForGrip = csg.translate3D(10, 31.25, 53.5).transform(cylinderForGrip);

        //second cylinder for grip (the one on the minus side of the x-axis)
        Geometry3D cylinderForGrip2 = csg.translate3D(-35, 0, 0).transform(cylinderForGrip);

        //the two cylinders for grips combined
        Geometry3D totalCylinders = csg.union3D(cylinderForGrip, cylinderForGrip2);
        return totalCylinders;
    }

    public Geometry3D getHolesForGrips(JavaCSG csg)
    {
        //the two holes on the plus side of the x-axis
        Geometry3D holeForGrib = csg.box3D(5, 2.5, 4, false);
        holeForGrib = csg.translate3D(12.5, 31.25, 48).transform(holeForGrib);
        Geometry3D holeForGrib2 = csg.translate3D(10, 0, 0).transform(holeForGrib);

        //the two holes on the minus side of the x-axis
        Geometry3D holeForGrib3 = csg.translate3D(-25, 0, 0).transform(holeForGrib);
        Geometry3D holeForGrib4 = csg.translate3D(-35, 0, 0).transform(holeForGrib);
        Geometry3D totalHolesForGribs = csg.union3D(holeForGrib, holeForGrib2, holeForGrib3, holeForGrib4);
        return totalHolesForGribs;
    }
}
