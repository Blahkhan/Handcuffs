package com.github.blahkhan.handcuffs;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.metadata.FixedMetadataValue;


public class RightClick implements Listener {
	private Main main;
	
	public RightClick(Main mi) {
		main = mi;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.HIGH)
	public void OnRightClick(EntityTargetEvent e) {
		Player p = (Player)e.getEntity();
		Player t = (Player)e.getTarget();
		List<String> lore = p.getItemInHand().getItemMeta().getLore();
		if (lore.get(0) == "Shackles" && t.getMetadata("cuffed").get(0).asBoolean() == false && !p.isSneaking()) {
			p.setMetadata("cuffing", new FixedMetadataValue(main, true));
			t.setMetadata("cuffed", new FixedMetadataValue(main, true));
			p.sendMessage("You just cuffed sb.");
			t.sendMessage("You've been cuffed");
		}
		else if (lore.get(0) == "Shackles" && t.getMetadata("cuffed").get(0).asBoolean() == true && !p.isSneaking()) {
			p.setMetadata("cuffing", new FixedMetadataValue(main, false));
			t.setMetadata("cuffed", new FixedMetadataValue(main, false));
			p.sendMessage("You just uncuffed sb.");
			t.sendMessage("You've been uncuffed");
		}
		else if (lore.get(0) == "Shackles" && t.getMetadata("cuffed").get(0).asBoolean() == true && p.isSneaking()) {
			if (t.getMetadata("carry").get(0).asBoolean() == false) {
				p.sendMessage("You're carrying sb.");
				t.sendMessage("You are carried");
				while (true) {
					t.teleport(p);
				}
				
			}
			else {
				p.sendMessage("You don't carry anybody anymore");
				t.sendMessage("You're not carried anymore.");
				
			}
			
		}
	}
}
