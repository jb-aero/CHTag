package io.github.jbaero;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;
/**
 * 
 * @author jb_aero
 */
@MSExtension("CHTag")
public class CHTag extends AbstractExtension {

	public CommandHelperPlugin chp;
	public TagListener tagl;

	@Override
	public void onStartup() {
		chp = CommandHelperPlugin.self;
		try {
			Static.checkPlugin("TagAPI", Target.UNKNOWN);
			tagl = new TagListener(chp);
		} catch (ConfigRuntimeException ex) {
			chp.getLogger().warning("TagAPI not found, CHTag features not enabled!");
		}
	}

	@Override
	public void onShutdown() {
		tagl.unregister();
	}

	public Version getVersion() {
		return new SimpleVersion(1, 0, 1);
	}
}
