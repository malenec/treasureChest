import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.Chest.BottomChest;
import org.abstractica.javacsgmodules.Chest.TopChest;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

			//the complete chest
		BottomChest bottom = new BottomChest(csg, 105, 75, 65);
		Geometry3D completeBottomChest = bottom.getCompleteBottomChest();
		TopChest top = new TopChest(csg, 105, 75, 37.5, true);
		Geometry3D completeTopChest = top.getCompleteTopChest();
		if (bottom.getBottomChestXLength() != top.getTopChestXLength())
		{
			throw new IllegalArgumentException("The top chest X length must be equal to the bottom chest X length");
		}
		if (bottom.getBottomChestYWidth() != top.getTopChestYWidth())
		{
			throw new IllegalArgumentException("The top chest Y width must be equal to the bottom chest Y width");
		}

			//view the bottom half of the chest alone
//		csg.view(completeBottomChest);

			//view the top half of the chest alone
//		csg.view(completeTopChest);

			//view the complete chest - closed
//		completeTopChest = csg.rotate3DY(csg.degrees(180)).transform(completeTopChest);
//		completeTopChest = csg.translate3D(0, 0, bottom.getBottomChestZHeight()+ top.getTopChestZHeight()+0.55).transform(completeTopChest);
//		Geometry3D completeBottomAndTop = csg.union3D(completeBottomChest, completeTopChest);
//		csg.view(completeBottomAndTop);

			//view the complete chest - open
		completeTopChest = csg.rotate3DZ(csg.degrees(180)).transform(completeTopChest);
		completeTopChest = csg.rotate3DX(csg.degrees(90)).transform(completeTopChest);
		completeTopChest = csg.translate3DZ(bottom.getBottomChestZHeight()+top.getTopChestYWidth()/2-3).transform(completeTopChest);
		if(top.isTopRounded())
		{
			completeTopChest = csg.translate3DY(bottom.getBottomChestYWidth()+0.95).transform(completeTopChest);
		}
		else
		{
			completeTopChest = csg.translate3DY(top.getTopChestZHeight()+bottom.getBottomChestYWidth()/2+0.95).transform(completeTopChest);
		}
		Geometry3D completeBottomAndTop = csg.union3D(completeBottomChest, completeTopChest);
		csg.view(completeBottomAndTop);
	}
}
