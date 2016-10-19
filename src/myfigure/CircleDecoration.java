package myfigure;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class CircleDecoration extends PolygonDecoration{
	
	public CircleDecoration(){
		setTemplate(generatePointList());
		setScale(0.1, 0.1); // Actual size
	}

	private PointList generatePointList() {
		int delta = 15; // Number of conrners in the cirlce
		double r = 50; // Integer difference in the points
		double da = Math.PI / delta;
		PointList pl = new PointList(delta);
		for(double a = 0; a < Math.PI * 2; a += da){
			double x = r*(Math.cos(a) - 1);
			double y = r*(Math.sin(a));
			pl.addPoint((int)x, (int)y);
		}
		return pl;
	}
}
