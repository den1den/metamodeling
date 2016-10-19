package myfigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.resource.ImageDescriptor;

import activator.PluginActivator;

public class ElipseWithDot extends Ellipse {
	
	final float dotSize = 0.5f;

	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);
		
		Color c = graphics.getBackgroundColor();
		graphics.setBackgroundColor(graphics.getForegroundColor());
		
		Rectangle bounds = getBounds();
		int diameter_x = (int)Math.floor(bounds.width() * dotSize);
		int diameter_y = (int)Math.floor(bounds.height() * dotSize);
		graphics.fillOval(bounds.x() + bounds.width() / 2 - diameter_x / 2,
				bounds.y() + bounds.height() / 2 - diameter_y / 2,
				diameter_x, diameter_y);
		
		graphics.setBackgroundColor(c);
	}
}
