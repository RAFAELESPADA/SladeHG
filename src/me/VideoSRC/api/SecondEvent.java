package me.VideoSRC.api;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SecondEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public HandlerList getHandlers() {
		return handlers;
	}
}
