package myfigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.resource.ImageDescriptor;

import activator.PluginActivator;

public class MyShape extends Shape {

	@Override
	protected void fillShape(Graphics graphics) {
		graphics.fillRectangle(getBounds());
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset);

		Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
		r.x += inset1;
		r.y += inset1;
		r.width -= inset1 + inset2;
		r.height -= inset1 + inset2;

		graphics.drawRectangle(r);
		
		graphics.drawRoundRectangle(r.shrink(5, 5), 5, 5);
	}
}
