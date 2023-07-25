package me.VideoSRC.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Hulk implements Listener {
	ArrayList<String> Hulk = new ArrayList();
	ArrayList<String> Cooldown = new ArrayList();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onHulk(PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (Main.Partida) {
			if ((event.getRightClicked() instanceof Player)) {
				Player d = (Player) event.getRightClicked();
				if ((Habilidade.getAbility(p).equalsIgnoreCase("hulk"))
						&& (p.getItemInHand().getType().equals(Material.AIR))) {
					if (this.Cooldown.contains(p.getName())) {
						p.sendMessage("§cHULK§7, Voce esta em cooldown!");
						event.setCancelled(true);
						return;
					}
					if (p.getPassenger() == null) {
						p.setPassenger(d);
						this.Cooldown.add(p.getName());
					} else {
					}
				}
			}
			if (this.Cooldown.contains(p.getName())) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						Hulk.this.Cooldown.remove(p.getName());
						p.sendMessage("§cHULK§7, Cooldown acabou!");
					}
				}, 120L);
			}
		}
	}
}
