package com.zeoldcraft.chtag;

import com.laytonsmith.annotations.startup;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;

public class CHTag {
	
	@startup
	public void setup() {
		CommandHelperPlugin chp = CommandHelperPlugin.self;
		try {
			Static.checkPlugin("TagAPI", Target.UNKNOWN);
			new TagListener(chp);
		} catch (ConfigRuntimeException ex) {
			chp.getLogger().warning("TagAPI not found, CHTag features not enabled!");
		}
	}
}
