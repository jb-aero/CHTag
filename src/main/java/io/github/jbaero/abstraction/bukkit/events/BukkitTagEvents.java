package io.github.jbaero.abstraction.bukkit.events;

import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCPlayer;
import com.laytonsmith.annotations.abstraction;
import io.github.jbaero.abstraction.events.ReceiveTagEvent;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

/**
 * 
 * @author jb_aero
 */
public class BukkitTagEvents {

	@abstraction(type = Implementation.Type.BUKKIT)
	public static class TagAPIReceiveTagEvent implements ReceiveTagEvent {

		AsyncPlayerReceiveNameTagEvent event;
		public TagAPIReceiveTagEvent(AsyncPlayerReceiveNameTagEvent te) {
			this.event = te;
		}
		
		public Object _GetObject() {
			return event;
		}

		public String getTag() {
			return event.getTag();
		}

		public MCPlayer getReceivingPlayer() {
			return new BukkitMCPlayer(event.getPlayer());
		}

		public MCPlayer getReceivedPlayer() {
			return new BukkitMCPlayer(event.getNamedPlayer());
		}

		public boolean setTag(String tag) {
			return event.setTag(tag);
		}

		public boolean isModified() {
			return event.isTagModified();
		}
		
	}
}
