package com.zeoldcraft.chtag;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import com.zeoldcraft.chtag.abstraction.bukkit.events.BukkitPluginEvents;

/**
 * 
 * @author jb_aero
 */
public class TagListener implements Listener {
	
	public TagListener(CommandHelperPlugin chp) {
		chp.registerEvent(this);
	}
	
	@EventHandler
	public void onNameTag(PlayerReceiveNameTagEvent event) {
		BukkitPluginEvents.TagAPIReceiveTagEvent rte = new BukkitPluginEvents.TagAPIReceiveTagEvent(event);
		EventUtils.TriggerListener(Driver.EXTERNAL, "player_tagged", rte);
	}
}
