package me.VideoSRC.kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.VideoSRC.api.Habilidade;

public class JackHammer implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		Block b = event.getBlock();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("jackhammer"))
				&& (p.getItemInHand().getItemMeta().getDisplayName().equals("�aJackHammer �7Kit!"))) {
			World w = (World) Bukkit.getServer().getWorlds().get(0);
			Double y = Double.valueOf(b.getLocation().getY() + 1.0D);
			Location l = new Location(w, b.getLocation().getX(), y.doubleValue(), b.getLocation().getZ());
			while ((l.getBlock().getType() != Material.BEDROCK) || (l.getBlock().getType() != Material.AIR)) {
				l.getBlock().breakNaturally();
				y = Double.valueOf(y.doubleValue() + 1.0D);
				l.setY(y.doubleValue());
			}
		}
	}
}
