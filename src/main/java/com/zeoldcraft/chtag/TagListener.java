package com.zeoldcraft.chtag;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import com.zeoldcraft.chtag.abstraction.bukkit.events.BukkitTagEvents;

/**
 * 
 * @author jb_aero
 */
public class TagListener implements Listener {
	
	public TagListener(CommandHelperPlugin chp) {
		chp.registerEvent(this);
	}
	
	public void unregister() {
		AsyncPlayerReceiveNameTagEvent.getHandlerList().unregister(this);
	}
	
	@EventHandler
	public void onNameTag(AsyncPlayerReceiveNameTagEvent event) {
		BukkitTagEvents.TagAPIReceiveTagEvent rte = new BukkitTagEvents.TagAPIReceiveTagEvent(event);
		EventUtils.TriggerListener(Driver.EXTENSION, "player_tagged", rte);
	}
}
