package me.VideoSRC.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Habilidade;

public class Viking implements Listener {
	@EventHandler
	public void onDamageViking(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player)) {
			return;
		}
		Player p = (Player) event.getDamager();
		if (Habilidade.getAbility(p).equalsIgnoreCase("viking")) {
			ItemStack item = ((Player) event.getDamager()).getItemInHand();
			if ((item != null) && (item.getType().name().contains("AXE"))) {
				event.setDamage(event.getDamage() + 1.5D);
			}
		}
	}
}
