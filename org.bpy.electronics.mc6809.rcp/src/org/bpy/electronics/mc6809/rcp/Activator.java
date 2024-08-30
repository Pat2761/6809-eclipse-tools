package org.bpy.electronics.mc6809.rcp;

import java.util.logging.Logger;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	
	private static final Logger logger = Logger.getLogger(Activator.class.getName());
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.bpy.electronics.mc6809.rcp"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		// nothing to do
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	   * Create an image from a file path 
	   * 
	   * @param imagePath image file path
	   * 
	   * @return image reference, <b>null</b> if not found
	   */
	  public static Image getImage(String imagePath) {
	    ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imagePath);
	    return imageDescriptor.createImage();
	  }

	  /**
	   * Create an image descriptor from a file path 
	   * 
	   * @param imagePath image file path
	   * 
	   * @return image reference, <b>null</b> if not found
	   */
	  public static ImageDescriptor getImageDescriptor(String imagePath) {
	    return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imagePath);
	  }

}
