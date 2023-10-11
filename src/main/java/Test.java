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
		BottomBox bottom = new BottomBox(csg);
		Geometry3D bottomBox3D = bottom.getBottomBox(csg);
		Geometry3D cylindersForNodeMCU = bottom.getCylindersForNodeMCU(csg);
		Geometry3D microUSBHole = bottom.getMicroUSBHole(csg);
		bottomBox3D = csg.difference3D(bottomBox3D, microUSBHole);
		Geometry3D cylindersForGrips = bottom.getCylindersForGrips(csg);
		Geometry3D holesForGrips = bottom.getHolesForGrips(csg);
		bottomBox3D = csg.difference3D(bottomBox3D, holesForGrips);
		Geometry3D buttonHolder = bottom.getButtonHolder(csg);
		Geometry3D edgesForLithophane = bottom.getEdgesForLithophane(csg);
		Geometry3D completeBottomBox = csg.union3D(bottomBox3D, cylindersForNodeMCU, cylindersForGrips, buttonHolder, edgesForLithophane);
//		csg.view(completeBottomBox);

		//the top half of the box
		TopBox top = new TopBox();
		Geometry3D topBox3D = top.getRoundedTopBox(csg);
		Geometry3D grips = top.getGrips(csg);
		Geometry3D buttonClicker = top.getButtonClicker(csg);
		Geometry3D completeTopBox = csg.union3D(topBox3D, grips, buttonClicker);
//		csg.view(completeTopBox);

		//the complete box - closed
//		completeTopBox = csg.rotate3DY(csg.degrees(180)).transform(completeTopBox);
//		completeTopBox = csg.translate3D(0, 0, 85.75).transform(completeTopBox);
//		Geometry3D completeBottomAndTop = csg.union3D(completeBottomBox, completeTopBox);
//		csg.view(completeBottomAndTop);

		//the complete box - open
		completeTopBox = csg.rotate3DY(csg.degrees(180)).transform(completeTopBox);
		completeTopBox = csg.rotate3DX(csg.degrees(270)).transform(completeTopBox);
		completeTopBox = csg.translate3D(0, 58.5, 100).transform(completeTopBox);
		Geometry3D completeBottomAndTop = csg.union3D(completeBottomBox, completeTopBox);
		csg.view(completeBottomAndTop);
	}
}
