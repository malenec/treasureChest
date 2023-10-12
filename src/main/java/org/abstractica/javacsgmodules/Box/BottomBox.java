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
        Geometry3D outerBottomBox = csg.box3D(105, 75, 65, false);

        //inner box size (cutout)
        Geometry3D innerBottomBox = csg.box3D(100, 70, 60, false);
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
        USBhole = csg.translate3D(0, 36.25, 5).transform(USBhole);
        return USBhole;
    }

    public Geometry3D getCylindersForGrips(JavaCSG csg)
    {
        //first cylinder for grip (the one on the plus side of the x-axis)
        Geometry3D cylinderForGrip = csg.cylinder3D(4, 15, 360, false);
        cylinderForGrip = csg.rotate3DX(csg.degrees(90)).transform(cylinderForGrip);
        cylinderForGrip = csg.rotate3DZ(csg.degrees(90)).transform(cylinderForGrip);
        cylinderForGrip = csg.translate3D(10, 36.25, 63.5).transform(cylinderForGrip);

        //second cylinder for grip (the one on the minus side of the x-axis)
        Geometry3D cylinderForGrip2 = csg.translate3D(-35, 0, 0).transform(cylinderForGrip);

        //the two cylinders for grips combined
        Geometry3D totalCylinders = csg.union3D(cylinderForGrip, cylinderForGrip2);
        return totalCylinders;
    }

    public Geometry3D getHolesForGrips(JavaCSG csg)
    {
        //the two holes on the plus side of the x-axis
        Geometry3D holeForGrip = csg.box3D(5, 2.5, 4, false);
        holeForGrip = csg.translate3D(12.5, 36.25, 58).transform(holeForGrip);
        Geometry3D holeForGrip2 = csg.translate3D(10, 0, 0).transform(holeForGrip);

        //the two holes on the minus side of the x-axis
        Geometry3D holeForGrip3 = csg.translate3D(-25, 0, 0).transform(holeForGrip);
        Geometry3D holeForGrip4 = csg.translate3D(-35, 0, 0).transform(holeForGrip);
        Geometry3D totalHolesForGrips = csg.union3D(holeForGrip, holeForGrip2, holeForGrip3, holeForGrip4);
        return totalHolesForGrips;
    }

    public Geometry3D getButtonHolder(JavaCSG csg)
    {
        //button holder
        Geometry3D outerButtonHolder = csg.box3D(15.45, 8.33, 8.7, false);

        //cutout for button
        Geometry3D cutoutForButton = csg.box3D(13.25, 6.13, 6.7, false);
        cutoutForButton = csg.translate3DZ(2).transform(cutoutForButton);

        //cutout for button legs
        Geometry3D cutoutForButtonLegs = csg.box3D(14.35, 2, 2, false);
        cutoutForButtonLegs = csg.translate3DX(0.55).transform(cutoutForButtonLegs);

        //cutout for side slide in
        Geometry3D sideCutout = csg.box3D(2, 2, 8.7, false);
        sideCutout = csg.translate3DX(7.6).transform(sideCutout);

        Geometry3D buttonHolder = csg.difference3D(outerButtonHolder, cutoutForButton, cutoutForButtonLegs, sideCutout);
        buttonHolder = csg.translate3D(-43.375, 31.935, 56.3).transform(buttonHolder);

        return buttonHolder;
    }

    public Geometry3D getEdgesForLithophane(JavaCSG csg)
    {
        //edges for lithophane - long sides
        Geometry3D edge1 = csg.box3D(100, 2, 1.5, false);
        edge1 = csg.translate3D(0, 34, 47.5).transform(edge1);
        Geometry3D edge2 = csg.translate3D(0, -68,0).transform(edge1);

        //edges for lithophane - short sides
        Geometry3D edge3 = csg.box3D(2, 70, 1.5, false);
        edge3 = csg.translate3D(-49, 0, 47.5).transform(edge3);
        Geometry3D edge4 = csg.translate3D(98, 0,0).transform(edge3);

        //cutout for cords from button to nodeMCU
        Geometry3D cutoutForCord1 = csg.box3D(2, 2, 1.5, false);
        cutoutForCord1 = csg.translate3D(-47, 34, 47.5).transform(cutoutForCord1);
        Geometry3D cutoutForCord2 = csg.translate3D(8.5, 0,0).transform(cutoutForCord1);
        edge1 = csg.difference3D(edge1, cutoutForCord1, cutoutForCord2);

        Geometry3D edgesCombined = csg.union3D(edge1, edge2, edge3, edge4);

        return edgesCombined;
    }

}
