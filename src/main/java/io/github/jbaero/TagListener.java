package io.github.jbaero;

import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import io.github.jbaero.abstraction.bukkit.events.BukkitTagEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

/**
 * 
 * @author jb_aero
 */
public class TagListener implements Listener {
	
	public TagListener(CommandHelperPlugin chp) {
		chp.registerEvents(this);
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
