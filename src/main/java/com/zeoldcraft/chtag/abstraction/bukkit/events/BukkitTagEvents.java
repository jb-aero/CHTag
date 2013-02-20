package com.zeoldcraft.chtag.abstraction.bukkit.events;

import org.kitteh.tag.PlayerReceiveNameTagEvent;

import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.bukkit.BukkitMCPlayer;
import com.laytonsmith.annotations.abstraction;
import com.zeoldcraft.chtag.abstraction.events.ReceiveTagEvent;

/**
 * 
 * @author jb_aero
 */
public class BukkitTagEvents {

	@abstraction(type = Implementation.Type.BUKKIT)
	public static class TagAPIReceiveTagEvent implements ReceiveTagEvent {

		PlayerReceiveNameTagEvent event;
		public TagAPIReceiveTagEvent(PlayerReceiveNameTagEvent te) {
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
			return event.isModified();
		}
		
	}
}
