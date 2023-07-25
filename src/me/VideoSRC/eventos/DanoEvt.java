package me.VideoSRC.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.VideoSRC.Main;

public class DanoEvt implements Listener {
	@EventHandler
	public void DamagePlayers(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		if (Main.Dano) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.Dano) {
			e.setCancelled(true);
			return;
		}
	}
}
