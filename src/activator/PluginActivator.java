package activator;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class PluginActivator extends AbstractUIPlugin {

	public static final String ID = "figures";

	private static PluginActivator ourInstance;

	public PluginActivator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		ourInstance = this;
	}

	public void stop(BundleContext context) throws Exception {
		ourInstance = null;
		super.stop(context);
	}

	public static PluginActivator getDefault() {
		return ourInstance;
	}
}
