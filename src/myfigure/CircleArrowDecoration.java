package myfigure;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class CircleArrowDecoration extends PolygonDecoration {
	
	public CircleArrowDecoration(){
		setTemplate(generatePointList());
		setScale(0.1, 0.1); // Actual size
	}

	private static PointList generatePointList() {
		int delta = 15; // Number of corners in the circle
		double r = 50; // Integer difference in the points
		double da = Math.PI / delta;
		PointList pl = new PointList(delta);
		for(double a = 0; a <= Math.PI * 2; a += da){
			double x = r*( - Math.cos(a) - 1);
			double y = r*(Math.sin(a));
			pl.addPoint((int)x, (int)y);
		}
		pl.addPoint((int)(-3.5 * r), (int)(-r));
		pl.addPoint((int)(-3.5 * r), (int)(r));
		return pl;
	}
}
