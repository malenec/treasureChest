import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.nodemcucutout.NodeMCUv2Cutout;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

//		NodeMCUv2Cutout cutout = new NodeMCUv2Cutout();
//
//		Geometry3D cutoutGeometry = cutout.getCutout(csg);
//		cutoutGeometry = csg.translate3DZ(3).transform(cutoutGeometry);
//
//		Geometry3D box = csg.box3D(30, 60, 7, false);
//
//		Geometry3D result = csg.difference3D(box, cutoutGeometry);


		Geometry3D outerBottomBox = csg.box3D(90, 60, 50, false);
		Geometry3D innerBottomBox = csg.box3D(88, 58, 48, false);
		Geometry3D bottomBox = csg.difference3D(outerBottomBox, innerBottomBox);

		Geometry3D outerTopBox = csg.box3D(90, 60, 15, false);
		Geometry3D innerTopBox = csg.box3D(88, 58, 13, false);
		Geometry3D topBox = csg.difference3D(outerTopBox, innerTopBox);
		topBox = csg.translate3D(150, 0, 0).transform(topBox);

//		Geometry3D cylinder = csg.cylinder3D(5, 35, 50, false);
//		cylinder = csg.rotate3DX(csg.degrees(90)).transform(cylinder);
//		cylinder = csg.translate3D(62, -20, 0).transform(cylinder);

		Geometry3D totalBox = csg.union3D(bottomBox, topBox);

//		csg.view(cylinder);

//		Geometry2D circle = csg.circle2D(4, 35);
//		Geometry2D plate = csg.rectangle2D(2, 6);
//		plate = csg.translate2D(0, 3).transform(plate);
//		Geometry2D kombi = csg.union2D(circle, plate);
//		Geometry3D kombi3D = csg.linearExtrude(35, false, kombi);
//
//		Geometry3D cutout = csg.box3D(2, 4.9, 5, false);
//		cutout = csg.translate3D(0, 4, 7.5).transform(cutout);
//		kombi3D = csg.difference3D(kombi3D, cutout);
//
//		csg.view(kombi3D);

		Geometry3D cylinder = csg.cylinder3D(4, 25, 360, false);

		Geometry3D plate1 = csg.box3D(2, 3.5, 5, false);
		plate1 = csg.translate3D(0, 3.5, 0).transform(plate1);

		Geometry3D plate2 = csg.box3D(2, 3.5, 5, false);
		plate2 = csg.translate3D(0, 3.5, 10).transform(plate2);

		Geometry3D plate3 = csg.box3D(2, 3.5, 5, false);
		plate3 = csg.translate3D(0, 3.5, 20).transform(plate3);

		Geometry3D plate4 = csg.box3D(2, 5, 25, false);
		plate4 = csg.translate3D(0, 7, 0).transform(plate4);

		Geometry3D kombi = csg.union3D(cylinder, plate1, plate2, plate3, plate4, totalBox);

		//csg.view(totalBox);


		//inner split
		Geometry2D circle = csg.circle2D(4.5, 64);
		Geometry3D ext = csg.linearExtrude( 4, false, circle);

		//outer grip
		Geometry2D circle2 = csg.circle2D(8.5, 360);
		Geometry3D ext2 = csg.linearExtrude( 4, false, circle2);

		Geometry2D pie = csg.cutoutPie2D(11, csg.degrees(0), csg.degrees(60));
		pie = csg.rotate2D(csg.degrees(-120)).transform(pie);

		Geometry3D ext3 = csg.linearExtrude( 4, false, pie);

//		Geometry3D box = csg.box3D(2,7,4, false);
//		box = csg.translate3DY(6).transform(box);

		Geometry3D grip = csg.difference3D(ext2, ext);
		grip = csg.difference3D(grip, ext3);
		grip = csg.union3D(grip);
		grip = csg.rotate3DZ(csg.degrees(180)).transform(grip);
		grip = csg.translate3D(0, 0, 5.5).transform(grip);

		Geometry3D grip2 = csg.translate3DZ(10).transform(grip);

		Geometry3D plate5 = csg.box3D(2, 5, 25, false);
		plate5 = csg.translate3D(0, -4.8, 0).transform(plate5);

		Geometry3D total = csg.union3D(grip, grip2, plate5, kombi, totalBox);

		csg.view(total);


	}
}
