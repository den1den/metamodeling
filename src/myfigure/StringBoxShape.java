package myfigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.resource.ImageDescriptor;

import activator.PluginActivator;

public class StringBoxShape extends Shape {
	
	public static class Init extends StringBoxShape{

		public Init() {
			super("init");
		}
		
	}
	
	final String text;
	final Insets boundInsets;
	final Dimension toprect;
	
	public StringBoxShape(String text){
		this.text = text;
		toprect = new Dimension(50, 20);
		boundInsets = new Insets(toprect.height, 0, 0, 0);
	}

	@Override
	protected void fillShape(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		r.shrink(boundInsets);
		graphics.fillRectangle(r);
		
		r = getBounds().getCopy();
		r.setSize(toprect);
		r.setX((r.width - toprect.width) / 2);
		graphics.fillRectangle(r);
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset);

		Rectangle r = getBounds().getCopy();
		r.shrink(boundInsets);
		r.x += inset1;
		r.y += inset1;
		r.width -= inset1 + inset2;
		r.height -= inset2;

		graphics.drawRectangle(r);

		r = getBounds().getCopy();
		r.setX(r.x() + (r.width - toprect.width) / 2);
		r.setSize(toprect);
		//r.x += inset1;
		r.y += inset1;
		r.width -= inset1 + inset2;
		r.height -= inset1;
		graphics.drawRectangle(r);
		
		FontMetrics m = graphics.getFontMetrics();
		int x = (r.width - m.getAverageCharWidth() * text.length()) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ((r.height - m.getHeight()) / 2);
	    
		graphics.drawString(text, r.x() + x, r.y() + y);
	}
}
