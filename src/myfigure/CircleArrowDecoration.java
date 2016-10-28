package myfigure;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class CircleArrowDecoration extends PolygonDecoration {
	
	public CircleArrowDecoration(){
		this(CircleDecoration.NORMAL_SCALE);
	}
	
	public CircleArrowDecoration(float size){
		setTemplate(CircleArrowDecoration.generatePointList());
		setScale(size, size); // Actual size
	}

	private static PointList generatePointList() {
		int delta = 25; // Number of corners in the circle
		double r = 500; // Integer difference in the points
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
	
	public static class Thick extends CircleArrowDecoration{
		public Thick(){
			super(CircleDecoration.THICK_SCALE);
		}
	}
	
	public static class Thicker extends CircleArrowDecoration{
		public Thicker(){
			super(CircleDecoration.THICKER_SCALE);
		}
	}
}
