package me.VideoSRC.borda;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.VideoSRC.Main;
import me.VideoSRC.outros.Manager;

public class BorderMove implements Listener {
	@EventHandler
	public void ForcefieldDamagePositive(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		World w = p.getWorld();
		if ((w.getSpawnLocation().getWorld().setSpawnLocation(0, 120, 0))
				&& ((Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 500)
						|| (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 500))
				&& (Main.Jogadores.contains(p.getName()))) {
			p.damage(0.5D);
			p.sendMessage("§cVoce esta no forcefield, volte!");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
				}
			}, 40L);
		}
	}

	@EventHandler
	public void ForcefieldDamagePositive2(PlayerMoveEvent e) {
		if (Main.PreGame) {
			Player p = e.getPlayer();
			Location loc = p.getLocation();
			World w = p.getWorld();
			if ((w.getSpawnLocation().getWorld().setSpawnLocation(0, 120, 0))
					&& ((Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 30)
							|| (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 30))
					&& (Main.Jogadores.contains(p.getName()))) {
				Bukkit.getServer().getWorld("world");
				Location teleportLocation = null;
				int x = 2;
				int y = 75;
				int z = -2;
				boolean isOnLand = false;
				while (!isOnLand) {
					teleportLocation = new Location(p.getWorld(), x, y, z);
					if (teleportLocation.getBlock().getType() != Material.AIR) {
						isOnLand = true;
					} else {
						y--;
					}
				}
				Manager.tpwSpawn(p);
				Manager.tpSpawn(p);
				p.sendMessage("§cNao fique longe do spawn!");
			}
		}
	}
}
