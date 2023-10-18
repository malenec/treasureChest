package org.abstractica.javacsgmodules.Chest;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class BottomChest {

    private double bottomChestXLength;
    private double bottomChestYWidth;
    private double bottomChestZHeight;
    private Geometry3D completeBottomChest;
    private double bottomBoxThickness = 2.5;
    private double bottomChestInnerXLength;
    private double bottomChestInnerYWidth;
    private double bottomChestInnerZHeight;
    static private double gripXLength = 4;
    static private double gapBetweenGripPair = 6;
    private double buttonHolderXLength = 15.45;
    private double buttonHolderYWidth = 8.33;
    private double buttonHolderZHeight = 7.8;
    private double buttonHolderThickness = 1.1;

    public BottomChest(JavaCSG csg, double bottomChestXLength, double bottomChestYWidth, double bottomChestZHeight)
    {
        this.bottomChestXLength = bottomChestXLength;
        if(bottomChestXLength < 85)
        {
            throw new IllegalArgumentException("The bottom chest X length cannot be less than 85 mm with the current components");
        }
        this.bottomChestYWidth = bottomChestYWidth;
        if(bottomChestYWidth < 65)
        {
            throw new IllegalArgumentException("The bottom chest Y width cannot be less than 65 mm with the current components");
        }
        this.bottomChestZHeight = bottomChestZHeight;

        this.bottomChestInnerXLength = bottomChestXLength-(bottomBoxThickness*2);
        this.bottomChestInnerYWidth = bottomChestYWidth-(bottomBoxThickness*2);
        this.bottomChestInnerZHeight = bottomChestZHeight-bottomBoxThickness;

        Geometry3D bottomBox3D = this.getBottomBox(csg);
        Geometry3D cylindersForNodeMCU = this.getCylindersForNodeMCU(csg);
        Geometry3D microUSBHole = this.getMicroUSBHole(csg);
        Geometry3D cylindersForGrips = this.getCylindersForGrips(csg);
        Geometry3D holesForGrips = this.getHolesForGrips(csg);
        Geometry3D buttonHolder = this.getButtonHolder(csg);
        Geometry3D edgesForLithophane = this.getEdgesForLithophane(csg);
        bottomBox3D = csg.difference3D(bottomBox3D, microUSBHole, holesForGrips);
        this.completeBottomChest = csg.union3D(bottomBox3D, cylindersForNodeMCU, cylindersForGrips, buttonHolder, edgesForLithophane);
    }

    public Geometry3D getBottomBox (JavaCSG csg)
    {
            //outer box size
        Geometry3D outerBottomBox = csg.box3D(bottomChestXLength, bottomChestYWidth, bottomChestZHeight, false);

            //inner box size (cutout)
        Geometry3D innerBottomBox = csg.box3D(bottomChestInnerXLength, bottomChestInnerYWidth, bottomChestInnerZHeight, false);
        innerBottomBox = csg.translate3D(0, 0, bottomBoxThickness).transform(innerBottomBox);
        Geometry3D totalBottomBox = csg.difference3D(outerBottomBox, innerBottomBox);

        return totalBottomBox;
    }

    public Geometry3D getCylindersForNodeMCU(JavaCSG csg)
    {
        double nodeCylinderHeight = 12.5;
        double nodeCylinderWidth = 2.6;
        double nodeCylinderXDist = 21.0;
        double nodeCylinderYDist = 43.4;

        double nodeTotalYWidth = 49;

        Geometry3D cylinders = csg.cylinder3D(nodeCylinderWidth, nodeCylinderHeight, 360, false);
        cylinders = csg.translate3DZ(bottomBoxThickness).transform(cylinders);
        Geometry3D cylinder1 = csg.translate3D(0.5* nodeCylinderXDist, 0.5* nodeCylinderYDist, 0).transform(cylinders);
        Geometry3D cylinder2 = csg.translate3D(-0.5* nodeCylinderXDist, 0.5* nodeCylinderYDist, 0).transform(cylinders);
        Geometry3D cylinder3 = csg.translate3D(0.5* nodeCylinderXDist, -0.5* nodeCylinderYDist, 0).transform(cylinders);
        Geometry3D cylinder4 = csg.translate3D(-0.5* nodeCylinderXDist, -0.5* nodeCylinderYDist, 0).transform(cylinders);
        cylinders = csg.union3D(cylinder1, cylinder2, cylinder3, cylinder4);
        cylinders = csg.translate3D(0,bottomChestInnerYWidth/2-nodeTotalYWidth/2-5.5,0).transform(cylinders);
        return cylinders;
    }

    public Geometry3D getMicroUSBHole(JavaCSG csg)
    {
        double USBholeXLength = 11.5;
        double USBholeZHeight = 8.5;

        Geometry3D USBhole = csg.box3D(USBholeXLength, bottomBoxThickness, USBholeZHeight, false);
        USBhole = csg.translate3D(0, bottomChestYWidth/2-bottomBoxThickness/2, bottomBoxThickness).transform(USBhole);
        return USBhole;
    }

    public Geometry3D getCylindersForGrips(JavaCSG csg)
    {
            //first cylinder for grip (the one on the plus side of the x-axis)
        Geometry3D cylinderForGripXpos = csg.cylinder3D(4, 15, 360, false);
        cylinderForGripXpos = csg.rotate3DX(csg.degrees(90)).transform(cylinderForGripXpos);
        cylinderForGripXpos = csg.rotate3DZ(csg.degrees(90)).transform(cylinderForGripXpos);
        cylinderForGripXpos = csg.translate3D(bottomChestXLength/10-0.5, bottomChestYWidth/2-bottomBoxThickness/2, bottomChestZHeight-1.5).transform(cylinderForGripXpos);

            //second cylinder for grip (the one on the minus side of the x-axis)
        Geometry3D cylinderForGripXneg = csg.translate3D(-(bottomChestXLength/10*2+(gripXLength*2+gapBetweenGripPair)), 0, 0).transform(cylinderForGripXpos);

            //the two cylinders for grips combined
        Geometry3D totalCylinders = csg.union3D(cylinderForGripXpos, cylinderForGripXneg);
        return totalCylinders;
    }

    public Geometry3D getHolesForGrips(JavaCSG csg)
    {
        double holeForGripXLength = 5;
        double holeForGripYWidth = 4;

            //the two holes on the plus side of the x-axis
        Geometry3D holeForGripXpos1 = csg.box3D(holeForGripXLength, bottomBoxThickness, holeForGripYWidth, false);
        holeForGripXpos1 = csg.translate3D((bottomChestXLength/10-0.5)+holeForGripXLength/2, bottomChestYWidth/2-bottomBoxThickness/2, bottomChestZHeight-7).transform(holeForGripXpos1);
        Geometry3D holeForGripXpos2 = csg.translate3D(gripXLength+gapBetweenGripPair, 0, 0).transform(holeForGripXpos1);

            //the two holes on the minus side of the x-axis
        Geometry3D holeForGripXneg1 = csg.translate3D(-(bottomChestXLength/10*2+gripXLength), 0, 0).transform(holeForGripXpos1);
        Geometry3D holeForGripXneg2 = csg.translate3D(-(bottomChestXLength/10*2+(gripXLength*2+gapBetweenGripPair)), 0, 0).transform(holeForGripXpos1);
        Geometry3D totalHolesForGrips = csg.union3D(holeForGripXpos1, holeForGripXpos2, holeForGripXneg1, holeForGripXneg2);
        return totalHolesForGrips;
    }

    public Geometry3D getButtonHolder(JavaCSG csg)
    {

            //button holder
        Geometry3D outerButtonHolder = csg.box3D(buttonHolderXLength, buttonHolderYWidth, buttonHolderZHeight, false);

            //cutout for button
        Geometry3D cutoutForButton = csg.box3D(buttonHolderXLength-buttonHolderThickness*2, buttonHolderYWidth-buttonHolderThickness*2, buttonHolderZHeight-buttonHolderThickness, false);
        cutoutForButton = csg.translate3DZ(buttonHolderThickness).transform(cutoutForButton);

            //cutout for button legs
        Geometry3D cutoutForButtonLegs = csg.box3D(buttonHolderXLength-buttonHolderThickness*2, 2, buttonHolderThickness, false);

            //cutout for side slide in
        Geometry3D sideCutout = csg.box3D(buttonHolderThickness, 2, buttonHolderZHeight, false);
        sideCutout = csg.translate3DX((buttonHolderXLength/2)-(buttonHolderThickness/2)).transform(sideCutout);

        Geometry3D buttonHolder = csg.difference3D(outerButtonHolder, cutoutForButton, cutoutForButtonLegs, sideCutout);
        buttonHolder = csg.translate3D(-(bottomChestInnerXLength/2-buttonHolderXLength/2+buttonHolderThickness), bottomChestInnerYWidth/2-buttonHolderYWidth/2+buttonHolderThickness, bottomChestZHeight-buttonHolderZHeight).transform(buttonHolder);

        return buttonHolder;
    }

    public Geometry3D getEdgesForLithophane(JavaCSG csg)
    {
        double edgeDepth = 2;
        double edgeHeight = 1.5;
        double cutoutForCordXLength = 2;

            //edges for lithophane - long sides
        Geometry3D edgeYpos = csg.box3D(bottomChestInnerXLength, edgeDepth, edgeHeight, false);
        edgeYpos = csg.translate3D(0, bottomChestInnerYWidth/2-edgeDepth/2, bottomChestZHeight-17.5).transform(edgeYpos);
        Geometry3D edgeYneg = csg.translate3D(0, -(bottomChestInnerYWidth-edgeDepth),0).transform(edgeYpos);

            //edges for lithophane - short sides
        Geometry3D edgeXneg = csg.box3D(edgeDepth, bottomChestInnerYWidth, edgeHeight, false);
        edgeXneg = csg.translate3D(-(bottomChestInnerXLength/2-edgeDepth/2), 0, bottomChestZHeight-17.5).transform(edgeXneg);
        Geometry3D edgeXpos = csg.translate3D(bottomChestInnerXLength-edgeDepth, 0,0).transform(edgeXneg);

            //cutout for cords from button to nodeMCU
        Geometry3D cutoutForCord1 = csg.box3D(cutoutForCordXLength, edgeDepth, edgeHeight, false);
        cutoutForCord1 = csg.translate3D(-(bottomChestInnerXLength/2-edgeDepth-cutoutForCordXLength/2), bottomChestInnerYWidth/2-edgeDepth/2, bottomChestZHeight-17.5).transform(cutoutForCord1);
        Geometry3D cutoutForCord2 = csg.translate3D(buttonHolderXLength-buttonHolderThickness-(edgeDepth+cutoutForCordXLength/2)*2-cutoutForCordXLength/2, 0,0).transform(cutoutForCord1);
        edgeXpos = csg.difference3D(edgeXpos, cutoutForCord1, cutoutForCord2);

        Geometry3D edgesCombined = csg.union3D(edgeYpos, edgeYneg, edgeXneg, edgeXpos);

        return edgesCombined;
    }

    public Geometry3D getCompleteBottomChest()
    {
        return completeBottomChest;
    }

    public double getBottomChestXLength() {
        return bottomChestXLength;
    }

    public double getBottomChestYWidth() {
        return bottomChestYWidth;
    }

    public double getBottomChestZHeight()
    {
        return bottomChestZHeight;
    }

    public static double getGripXLength() {
        return gripXLength;
    }

    public static double getGapBetweenGripPair() {
        return gapBetweenGripPair;
    }
}
