package myfigure;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.swt.graphics.Image;

import org.eclipse.jface.resource.ImageDescriptor;

import activator.PluginActivator;

public class MyFigure extends ImageFigure {
	public MyFigure(){
	    super(constructImage(), 0);
	  }
	
	private static Image constructImage(){
		ImageDescriptor descriptor = null;
		descriptor = PluginActivator.imageDescriptorFromPlugin(
				PluginActivator.ID,
				"images/kb.png"
		);
		if(descriptor == null){
			// FIXME:
			// something wrong with PluginActivator.ID, it points to somewhere where there is no images/kb.png 
			throw new RuntimeException("Could not find image, gr Dennis");
		}
		return descriptor.createImage();
	}
}
