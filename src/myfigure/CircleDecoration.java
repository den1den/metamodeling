package myfigure;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class CircleDecoration extends PolygonDecoration {
	
	public static float NORMAL_SCALE = 0.01f;
	public static float THICK_SCALE = 0.0120f;
	public static float THICKER_SCALE = 0.0145f;

	public CircleDecoration(){
		this(CircleDecoration.NORMAL_SCALE);
	}
	
	public CircleDecoration(float size){
		setTemplate(CircleDecoration.generatePointList());
		setScale(size, size); // Actual size
	}

	private static PointList generatePointList() {
		int delta = 25; // Number of corners in the circle
		double r = 500; // Integer difference in the points
		double da = Math.PI / delta;
		PointList pl = new PointList(delta);
		for(double a = 0; a < Math.PI * 2; a += da){
			double x = r*(Math.cos(a) - 1);
			double y = r*(Math.sin(a));
			pl.addPoint((int)x, (int)y);
		}
		return pl;
	}
	
	public static class Thick extends CircleDecoration{
		public Thick(){
			super(CircleDecoration.THICK_SCALE);
		}
	}
	
	public static class Thicker extends CircleDecoration{
		public Thicker(){
			super(CircleDecoration.THICKER_SCALE);
		}
	}
}
