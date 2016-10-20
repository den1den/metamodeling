package myfigure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;

public class DoublePolyLine extends PolylineConnection{
	@Override
	protected void outlineShape(Graphics g) {
		//TODO: implement the extra lines
		super.outlineShape(g);
		System.out.println("DoublePolyLine.outlineShape.points = "+super.getPoints());
	}
}
