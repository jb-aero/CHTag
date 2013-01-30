package com.zeoldcraft.chtag.core.events.drivers;

import java.util.HashMap;
import java.util.Map;

import com.laytonsmith.annotations.api;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.AbstractEvent;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.zeoldcraft.chtag.abstraction.events.ReceiveTagEvent;

/**
 * 
 * @author jb_aero
 */
public class PlayerTagged {

	@api
	public static class player_tagged extends AbstractEvent {

		public String getName() {
			return "player_tagged";
		}

		public String docs() {
			return "{player: <string match> | tagged: <string match>} "
					+ "This event is called when a player (and their name tag) comes into view of another, "
					+ "but only if you have TagAPI installed. It is worth noting that the players see each "
					+ "other at the same time, but an event is fired for each. "
					+ "{player: The player recieving the name tag | tagged: The player whose tag is being received | "
					+ "tag: the tag that is currently being received} "
					+ "{tag} "
					+ "{player | tagged | tag}";
		}

		public boolean matches(Map<String, Construct> prefilter, BindableEvent event)
				throws PrefilterNonMatchException {
			if (event instanceof ReceiveTagEvent) {
				ReceiveTagEvent e = (ReceiveTagEvent) event;
				if (prefilter.containsKey("player")) {
					if (!e.getReceivingPlayer().getName().equals(prefilter.get("player").val())) {
						return false;
					}
				}
				if (prefilter.containsKey("tagged")) {
					if (!e.getReceivedPlayer().getName().equals(prefilter.get("tagged").val())) {
						return false;
					}
				}
				return true;
			}
			return false;
		}

		public BindableEvent convert(CArray manualObject) {
			return null;
		}

		public Map<String, Construct> evaluate(BindableEvent event)
				throws EventException {
			ReceiveTagEvent e = (ReceiveTagEvent) event;
			Map<String, Construct> ret = new HashMap<String, Construct>();
			
			ret.put("player", new CString(e.getReceivingPlayer().getName(), Target.UNKNOWN));
			
			ret.put("tagged", new CString(e.getReceivedPlayer().getName(), Target.UNKNOWN));
			
			ret.put("tag", new CString(e.getTag(), Target.UNKNOWN));
			
			return ret;
		}

		public Driver driver() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean modifyEvent(String key, Construct value,
				BindableEvent event) {
			if (event instanceof ReceiveTagEvent) {
				ReceiveTagEvent e = (ReceiveTagEvent) event;
				if (key.equals("tag")) {
					return e.setTag(value.val());
				}
			}
			return false;
		}

		public CHVersion since() {
			return CHVersion.V3_3_1;
		}
		
	}
}
