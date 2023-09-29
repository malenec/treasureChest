package org.abstractica.javacsgmodules.Box;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class TopBox {


    public TopBox() {
    }

    public Geometry3D topBox(JavaCSG csg){
        Geometry3D outerTopBox = csg.box3D(90, 60, 15, false);
        Geometry3D innerTopBox = csg.box3D(88, 58, 13, false);
        Geometry3D topBox = csg.difference3D(outerTopBox, innerTopBox);
        topBox = csg.translate3D(150, 0, 0).transform(topBox);
        return topBox;
    }
}
