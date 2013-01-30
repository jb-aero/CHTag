package com.zeoldcraft.chtag.abstraction.events;

import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.core.events.BindableEvent;

public interface ReceiveTagEvent extends BindableEvent {
	
	public String getTag();
	
	public MCPlayer getReceivingPlayer();
	
	public MCPlayer getReceivedPlayer();
	
	public boolean setTag(String tag);
	
}
