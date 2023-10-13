import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.Box.BottomBox;
import org.abstractica.javacsgmodules.Box.TopBox;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

		//the bottom half of the box
		BottomBox bottom = new BottomBox(csg, 105, 75, 65);
//		csg.view(bottom.getCompleteBottomBox());

		//the top half of the box
		TopBox top = new TopBox(csg, 105, 75, 20);
//		csg.view(top.getCompleteTopBox());

		//the complete box - closed
//		Geometry3D completeBottomBox = bottom.getCompleteBottomBox();
//		Geometry3D completeTopBox = top.getCompleteTopBox();
//		completeTopBox = csg.rotate3DY(csg.degrees(180)).transform(completeTopBox);
//		completeTopBox = csg.translate3D(0, 0, 85.75).transform(completeTopBox);
//		Geometry3D completeBottomAndTop = csg.union3D(completeBottomBox, completeTopBox);
//		csg.view(completeBottomAndTop);

		//the complete box - open
		Geometry3D completeBottomBox = bottom.getCompleteBottomBox();
		Geometry3D completeTopBox = top.getCompleteTopBox();
		completeTopBox = csg.rotate3DY(csg.degrees(180)).transform(completeTopBox);
		completeTopBox = csg.rotate3DX(csg.degrees(270)).transform(completeTopBox);
		completeTopBox = csg.translate3D(0, 58.5, 99.5).transform(completeTopBox);
		Geometry3D completeBottomAndTop = csg.union3D(completeBottomBox, completeTopBox);
		csg.view(completeBottomAndTop);
	}
}
