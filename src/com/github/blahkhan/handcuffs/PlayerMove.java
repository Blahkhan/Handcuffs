package com.github.blahkhan.handcuffs;


import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.MetadataValue;


public class PlayerMove implements Listener {

	@EventHandler
	public void OnPlayerMove(PlayerMoveEvent  e) {
		List<MetadataValue> cuffed = e.getPlayer().getMetadata("cuffed");
		if (cuffed.get(0).asBoolean() == true) {
			e.setCancelled(true);
		}
		else {
			e.setCancelled(false);
		}
	}
	
}
