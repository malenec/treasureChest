package org.abstractica.javacsgmodules.Chest;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class TopChest {

    private double topChestXLength;
    private double topChestYWidth;
    private double topChestZHeight;
    private boolean isTopRounded;
    private Geometry3D completeTopChest;
    private double topBoxThickness = 2.5;
    private double topChestInnerXLength;
    private double topChestInnerYWidth;
    private double topChestInnerZHeight;


    public TopChest(JavaCSG csg, double topChestXLength, double topChestYWidth, double topChestZHeight, boolean isTopRounded)
    {
        this.topChestXLength = topChestXLength;
        if(topChestXLength < 85)
        {
            throw new IllegalArgumentException("The top chest X length cannot be less than 85 mm with the current components");
        }
        this.topChestYWidth = topChestYWidth;
        if(topChestYWidth < 65)
        {
            throw new IllegalArgumentException("The top chest Y width cannot be less than 65 mm with the current components");
        }
        this.topChestZHeight = topChestZHeight;
        this.isTopRounded = isTopRounded;

        this.topChestInnerXLength = topChestXLength-(topBoxThickness*2);
        this.topChestInnerYWidth = topChestYWidth-(topBoxThickness*2);
        this.topChestInnerZHeight = topChestZHeight-topBoxThickness;

        Geometry3D grips = this.getGrips(csg);
        Geometry3D buttonClicker = this.getButtonClicker(csg);

        if(isTopRounded)
        {
            if(topChestZHeight != topChestYWidth/2)
            {
                throw new IllegalArgumentException("The top chest Z height must be half of the top chest Y width when the top is rounded");
            }
            Geometry3D roundedTopBox = this.getRoundedTopBox(csg, topChestXLength, topChestYWidth, topChestZHeight);
            this.completeTopChest = csg.union3D(roundedTopBox, grips, buttonClicker);
        }
        else
        {
            Geometry3D squaredTopBox = this.getSquaredTopBox(csg, topChestXLength, topChestYWidth, topChestZHeight);
            this.completeTopChest = csg.union3D(squaredTopBox, grips, buttonClicker);
        }
    }

    public Geometry3D getSquaredTopBox(JavaCSG csg, double topChestXLength, double topChestYWidth, double topChestZHeight)
    {
            //outer box size
        Geometry3D outerTopBox = csg.box3D(topChestXLength, topChestYWidth, topChestZHeight, false);

            //inner box size (cutout)
        Geometry3D innerTopBox = csg.box3D(topChestInnerXLength, topChestInnerYWidth, topChestInnerZHeight, false);
        innerTopBox = csg.translate3D(0, 0, topBoxThickness).transform(innerTopBox);
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
        Geometry3D innerTopCylinder = csg.cylinder3D(topChestInnerYWidth, topChestInnerXLength, 360, false);
        innerTopCylinder = csg.rotate3DY(csg.degrees(90)).transform(innerTopCylinder);
        innerTopCylinder = csg.translate3D(-(topChestInnerXLength/2), 0, topChestZHeight+topBoxThickness).transform(innerTopCylinder);
        Geometry3D totalRoundedTopBox = csg.difference3D(outerTopCylinder, innerTopCylinder);

        return totalRoundedTopBox;
    }

    public Geometry3D getGrips(JavaCSG csg)
    {
        double gripXLength = BottomChest.getGripXLength();
        double gapBetweenGripPair = BottomChest.getGapBetweenGripPair();

            //outer circle
        Geometry2D outerCircle = csg.circle2D(8.5, 360);
        Geometry3D extrudedOuterCircle = csg.linearExtrude(gripXLength, false, outerCircle);

            //inner circle (cutout)
        Geometry2D innerCircle = csg.circle2D(4.5, 360);
        Geometry3D extrudedInnerCircle = csg.linearExtrude(gripXLength, false, innerCircle);

            //pie (cutout)
        Geometry2D pie = csg.cutoutPie2D(11, csg.degrees(0), csg.degrees(60));
        pie = csg.rotate2D(csg.degrees(-180)).transform(pie);
        Geometry3D extrudedPie = csg.linearExtrude( gripXLength, false, pie);

            //first grip
        Geometry3D gripXpos1 = csg.difference3D(extrudedOuterCircle, extrudedInnerCircle);
        gripXpos1 = csg.difference3D(gripXpos1, extrudedPie);
        gripXpos1 = csg.rotate3DZ(csg.degrees(180)).transform(gripXpos1);

            //second grip
        Geometry3D gripXpos2 = csg.translate3DZ(gripXLength+gapBetweenGripPair).transform(gripXpos1);

            //the set of grips combined
        Geometry3D gripsXposCombined = csg.union3D(gripXpos1, gripXpos2);
        gripsXposCombined = csg.rotate3D(csg.degrees(90), csg.degrees(0), csg.degrees(90)).transform(gripsXposCombined);
        gripsXposCombined = csg.translate3D(topChestXLength/10,  topChestYWidth/2-topBoxThickness/2, topChestZHeight+topBoxThickness*0.9).transform(gripsXposCombined);

            //the second set of grips
        Geometry3D gripsXnegCombined = csg.translate3D(-(topChestXLength/10*2+gripXLength*2+gapBetweenGripPair), 0, 0).transform(gripsXposCombined);

            //the two sets of grips combined
        Geometry3D totalGrips = csg.union3D(gripsXposCombined, gripsXnegCombined);

        return totalGrips;
    }

    public Geometry3D getButtonClicker(JavaCSG csg)
    {
        double buttonClickerXLength = 7.175;
        double buttonClickerYWidth = 7.23;
        double buttonClickerZHeight = 5;

            //button clicker
        Geometry3D buttonClicker = csg.box3D(buttonClickerXLength, buttonClickerYWidth, buttonClickerZHeight, false);
        buttonClicker = csg.translate3D(topChestInnerXLength/2-buttonClickerXLength/2, topChestInnerYWidth/2-buttonClickerYWidth/2, topChestZHeight-buttonClickerZHeight).transform(buttonClicker);

        return buttonClicker;
    }

    public Geometry3D getCompleteTopChest()
    {
        return completeTopChest;
    }

    public double getTopChestXLength() {
        return topChestXLength;
    }

    public double getTopChestYWidth() {
        return topChestYWidth;
    }

    public double getTopChestZHeight() {
        return topChestZHeight;
    }

    public boolean isTopRounded() {
        return isTopRounded;
    }
}
