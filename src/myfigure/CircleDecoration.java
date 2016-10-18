package myfigure;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class CircleDecoration extends PolygonDecoration{
	public CircleDecoration(){
		setTemplate(generatePointList());
	}

	private PointList generatePointList() {
		//TODO: Test this, not done yet
		
		int delta = 10;
		double r = 5;
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
