package com.github.blahkhan.handcuffs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PlayerJoin implements Listener {
	
	private Main main;
	
	public PlayerJoin(Main mi) {
		main = mi;
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().setMetadata("cuffed", new FixedMetadataValue(main, false));
		e.getPlayer().setMetadata("cuffing", new FixedMetadataValue(main, false));
		e.getPlayer().setMetadata("carry", new FixedMetadataValue(main, false));
	}
}
