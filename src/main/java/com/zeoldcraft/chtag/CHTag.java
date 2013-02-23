package com.zeoldcraft.chtag;

import com.laytonsmith.annotations.shutdown;
import com.laytonsmith.annotations.startup;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;

/**
 * 
 * @author jb_aero
 */
public class CHTag {
	
	public static CommandHelperPlugin chp;
	public static TagListener tagl;
	
	@startup
	public static void setup() {
		chp = CommandHelperPlugin.self;
		try {
			Static.checkPlugin("TagAPI", Target.UNKNOWN);
			tagl = new TagListener(chp);
		} catch (ConfigRuntimeException ex) {
			chp.getLogger().warning("TagAPI not found, CHTag features not enabled!");
		}
	}
	
	@shutdown
	public static void unload() {
		tagl.unregister();
	}
}
