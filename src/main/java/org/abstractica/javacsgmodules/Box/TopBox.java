package org.abstractica.javacsgmodules.Box;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class TopBox {

    private double topChestXLength;
    private double topChestYWidth;
    private double topChestZHeight;
    private double isRounded;
    private Geometry3D completeTopBox;

    public TopBox(JavaCSG csg, double topChestXLength, double topChestYWidth, double topChestZHeight, boolean isRounded)
    {
        this.topChestXLength = topChestXLength; //must not be less than 65 mm
        this.topChestYWidth = topChestYWidth;
        this.topChestZHeight = topChestZHeight;

        Geometry3D grips = this.getGrips(csg);
        Geometry3D buttonClicker = this.getButtonClicker(csg);

        if(isRounded)
        {
            Geometry3D roundedTopBox = this.getRoundedTopBox(csg, topChestXLength, topChestYWidth, topChestZHeight);
            this.completeTopBox = csg.union3D(roundedTopBox, grips, buttonClicker);
        }
        else
        {
            Geometry3D squaredTopBox = this.getSquaredTopBox(csg, topChestXLength, topChestYWidth, topChestZHeight);
            this.completeTopBox = csg.union3D(squaredTopBox, grips, buttonClicker);
        }
    }

    public Geometry3D getCompleteTopBox()
    {
        return completeTopBox;
    }


    public Geometry3D getSquaredTopBox(JavaCSG csg, double topChestXLength, double topChestYWidth, double topChestZHeight)
    {
        //outer box size
        Geometry3D outerTopBox = csg.box3D(topChestXLength, topChestYWidth, topChestZHeight, false);

        //inner box size (cutout)
        Geometry3D innerTopBox = csg.box3D(topChestXLength-5, topChestYWidth-5, topChestZHeight-2.5, false);
        innerTopBox = csg.translate3D(0, 0, 2.5).transform(innerTopBox);
        Geometry3D totalSquaredTopBox = csg.difference3D(outerTopBox, innerTopBox);

        return totalSquaredTopBox;
    }

    public Geometry3D getRoundedTopBox(JavaCSG csg, double topChestXLength, double topChestYWidth, double topChestZHeight)
    {
        //outer cylinder size
        Geometry3D outerTopCylinder = csg.cylinder3D(topChestYWidth, topChestXLength, 360, false);
        outerTopCylinder = csg.rotate3DY(csg.degrees(90)).transform(outerTopCylinder);
        outerTopCylinder = csg.translate3D(-topChestXLength/2, 0, topChestZHeight).transform(outerTopCylinder);
        Geometry3D cutoutBox = csg.box3D(topChestXLength, topChestYWidth, topChestYWidth/2, false);
        cutoutBox = csg.translate3D(0, 0, topChestZHeight).transform(cutoutBox);
        outerTopCylinder = csg.difference3D(outerTopCylinder, cutoutBox);

        //inner cylinder size (cutout)
        Geometry3D innerTopCylinder = csg.cylinder3D(topChestYWidth-5, topChestXLength-5, 360, false);
        innerTopCylinder = csg.rotate3DY(csg.degrees(90)).transform(innerTopCylinder);
        innerTopCylinder = csg.translate3D(-(topChestXLength-5)/2, 0, topChestZHeight+2.5).transform(innerTopCylinder);
        Geometry3D totalRoundedTopBox = csg.difference3D(outerTopCylinder, innerTopCylinder);

        return totalRoundedTopBox;
    }

    public Geometry3D getGrips(JavaCSG csg)
    {
        //outer circle
        Geometry2D outerCircle = csg.circle2D(8.5, 360);
        Geometry3D extrudedOuterCircle = csg.linearExtrude( 4, false, outerCircle);

        //inner circle (cutout)
        Geometry2D innerCircle = csg.circle2D(4.5, 64);
        Geometry3D extrudedInnerCircle = csg.linearExtrude( 4, false, innerCircle);

        //pie (cutout)
        Geometry2D pie = csg.cutoutPie2D(11, csg.degrees(0), csg.degrees(60));
        pie = csg.rotate2D(csg.degrees(-180)).transform(pie);
        Geometry3D extrudedPie = csg.linearExtrude( 4, false, pie);

        //first grip
        Geometry3D grip = csg.difference3D(extrudedOuterCircle, extrudedInnerCircle);
        grip = csg.difference3D(grip, extrudedPie);
        grip = csg.rotate3DZ(csg.degrees(180)).transform(grip);

        //second grip
        Geometry3D grip2 = csg.translate3DZ(10).transform(grip);

        //the set of grips combined
        Geometry3D gripsCombined = csg.union3D(grip, grip2);
        gripsCombined = csg.rotate3DX(csg.degrees(90)).transform(gripsCombined);
        gripsCombined = csg.rotate3DZ(csg.degrees(90)).transform(gripsCombined);
        gripsCombined = csg.translate3D(topChestXLength/10,  (topChestYWidth/2)-1.25, topChestZHeight+2.25).transform(gripsCombined);

        //the second set of grips
        Geometry3D gripsCombined2 = csg.translate3D(-(topChestXLength/10*2+14), 0, 0).transform(gripsCombined);

        //the two sets of grips combined
        Geometry3D totalGrips = csg.union3D(gripsCombined, gripsCombined2);

        return totalGrips;
    }

    public Geometry3D getButtonClicker(JavaCSG csg)
    {
        double buttonClickerXLength = 7.175;
        double buttonClickerYWidth = 7.23;
        double buttonClickerZHeight = 5;
        //button clicker
        Geometry3D buttonClicker = csg.box3D(buttonClickerXLength, buttonClickerYWidth, buttonClickerZHeight, false);
        buttonClicker = csg.translate3D(((topChestXLength-5)/2)-(buttonClickerXLength/2), ((topChestYWidth-5)/2)-(buttonClickerYWidth/2), topChestZHeight-buttonClickerZHeight).transform(buttonClicker);

        return buttonClicker;
    }
}
