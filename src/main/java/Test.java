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

		Geometry3D bottomAndTop = csg.union3D(bottomBox3D, topBox3D);

		Geometry3D cylinder = csg.cylinder3D(4, 25, 360, false);
		Geometry3D plate1 = csg.box3D(2, 3.5, 5, false);
		plate1 = csg.translate3D(0, 3.5, 0).transform(plate1);
		Geometry3D plate2 = csg.box3D(2, 3.5, 5, false);
		plate2 = csg.translate3D(0, 3.5, 10).transform(plate2);
		Geometry3D plate3 = csg.box3D(2, 3.5, 5, false);
		plate3 = csg.translate3D(0, 3.5, 20).transform(plate3);
		Geometry3D plate4 = csg.box3D(2, 5, 25, false);
		plate4 = csg.translate3D(0, 7, 0).transform(plate4);

		Geometry3D kombi = csg.union3D(cylinder, plate1, plate2, plate3, plate4, bottomAndTop);

		//inner split
		Geometry2D circle = csg.circle2D(4.5, 64);
		Geometry3D ext = csg.linearExtrude( 4, false, circle);

		//outer grip
		Geometry2D circle2 = csg.circle2D(8.5, 360);
		Geometry3D ext2 = csg.linearExtrude( 4, false, circle2);

		Geometry2D pie = csg.cutoutPie2D(11, csg.degrees(0), csg.degrees(60));
		pie = csg.rotate2D(csg.degrees(-120)).transform(pie);

		Geometry3D ext3 = csg.linearExtrude( 4, false, pie);

		Geometry3D grip = csg.difference3D(ext2, ext);
		grip = csg.difference3D(grip, ext3);
		grip = csg.union3D(grip);
		grip = csg.rotate3DZ(csg.degrees(180)).transform(grip);
		grip = csg.translate3D(0, 0, 5.5).transform(grip);

		Geometry3D grip2 = csg.translate3DZ(10).transform(grip);

		Geometry3D plate5 = csg.box3D(2, 5, 25, false);
		plate5 = csg.translate3D(0, -4.8, 0).transform(plate5);

		Geometry3D total = csg.union3D(grip, grip2, plate5, kombi, bottomAndTop, holes);
		total = csg.difference3D(total, microUSBHole);

		csg.view(total);
	}
}
