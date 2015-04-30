package io.github.jbaero.abstraction.events;

import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.core.events.BindableEvent;

/**
 * 
 * @author jb_aero
 */
public interface ReceiveTagEvent extends BindableEvent {

	String getTag();

	MCPlayer getReceivingPlayer();

	MCPlayer getReceivedPlayer();

	boolean setTag(String tag);

	boolean isModified();
	
}
