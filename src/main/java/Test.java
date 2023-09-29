import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.Box.BottomBox;
import org.abstractica.javacsgmodules.Box.TopBox;

public class Test
{
	private static double zSize = 7.0;
	private static double holeSize = 2.6;
	private static double holeXDist = 21.0;
	private static double holeYDist = 43.4;

	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

		BottomBox bottom = new BottomBox(csg);
		Geometry3D holes = bottom.getHoles(csg);
		Geometry3D microUSBHole = bottom.getMicroUSBHole(csg);
		Geometry3D bottomBox3D = bottom.bottomBox(csg);

		TopBox top = new TopBox();
		Geometry3D topBox3D = top.topBox(csg);
		topBox3D = csg.rotate3DY(csg.degrees(180)).transform(topBox3D);
		topBox3D = csg.translate3D(150, 0, -2.3).transform(topBox3D);

		Geometry3D bottomAndTop = csg.union3D(bottomBox3D, topBox3D);

		Geometry3D cylinder = csg.cylinder3D(4, 25, 360, false);
		Geometry3D plateHole = csg.box3D(5, 2, 4, false);
		plateHole = csg.translate3D(-17.5, -29.5, 1).transform(plateHole);
		Geometry3D plateHole2 = csg.translate3D(-10, 0, 0).transform(plateHole);
		Geometry3D plateHole3 = csg.translate3D(35, 0, 0).transform(plateHole);
		Geometry3D plateHole4 = csg.translate3D(45, 0, 0).transform(plateHole);
		bottomAndTop = csg.difference3D(bottomAndTop, plateHole, plateHole2, plateHole3, plateHole4);

		Geometry3D cylinderCombined = csg.union3D(cylinder);
		cylinderCombined = csg.rotate3DX(csg.degrees(90)).transform(cylinderCombined);
		cylinderCombined = csg.rotate3DZ(csg.degrees(90)).transform(cylinderCombined);
		cylinderCombined = csg.translate3D(0, -29.5, 0).transform(cylinderCombined);
		cylinderCombined = csg.translate3D(10, 0, 0).transform(cylinderCombined);
		Geometry3D cylinderCombined2 = csg.translate3D(-45, 0, 0).transform(cylinderCombined);
		Geometry3D totalCylinder = csg.union3D(bottomAndTop, cylinderCombined, cylinderCombined2);
		//csg.view(totalBottomBox);

		//inner split
		Geometry2D circle = csg.circle2D(4.5, 64);
		Geometry3D ext = csg.linearExtrude( 4, false, circle);

		//outer grip
		Geometry2D circle2 = csg.circle2D(8.5, 360);
		Geometry3D ext2 = csg.linearExtrude( 4, false, circle2);

		Geometry2D pie = csg.cutoutPie2D(11, csg.degrees(0), csg.degrees(60));
		pie = csg.rotate2D(csg.degrees(-80)).transform(pie);

		Geometry3D ext3 = csg.linearExtrude( 4, false, pie);

		Geometry3D grip = csg.difference3D(ext2, ext);
		grip = csg.difference3D(grip, ext3);
		grip = csg.union3D(grip);
		grip = csg.rotate3DZ(csg.degrees(180)).transform(grip);
		grip = csg.translate3D(0, 0, 5.5).transform(grip);

		Geometry3D grip2 = csg.translate3DZ(10).transform(grip);

		//Geometry3D plate5 = csg.box3D(2, 5, 25, false);
		//plate5 = csg.translate3D(0, -4.8, 0).transform(plate5);
		Geometry3D gribCombined = csg.union3D(grip, grip2);
		gribCombined = csg.rotate3DX(csg.degrees(90)).transform(gribCombined);
		gribCombined = csg.rotate3DZ(csg.degrees(90)).transform(gribCombined);
		gribCombined = csg.translate3D(0, -29.5, 0).transform(gribCombined);
		gribCombined = csg.translate3D(10, 0, 0).transform(gribCombined);
		Geometry3D gribCombined2 = csg.translate3D(-45, 0, 0).transform(gribCombined);
		Geometry3D totalGribs = csg.union3D(gribCombined, gribCombined2);


		Geometry3D total = csg.union3D(totalGribs, totalCylinder, bottomAndTop, holes);
		total = csg.difference3D(total, microUSBHole);

		csg.view(total);
	}
}
