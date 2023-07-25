package me.VideoSRC.kits;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.VideoSRC.Main;


public class Launcher implements Listener {
	public Main plugin;

	public Launcher(Main plugin) {
		this.plugin = plugin;
	}

	protected ArrayList<String> fall = new ArrayList();

	public void Atirar(Player p) {
		int y = 8;
		Block block = p.getLocation().getBlock().getRelative(0, -1, 0);
		if (block.getType() == Material.SPONGE) {
			Vector vector = new Vector(0, y, 0);
			p.setVelocity(vector);
			this.fall.remove(p.getName());
			 p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 4.0F, 4.0F);
			p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
			this.fall.add(p.getName());
		}
	}
	@EventHandler
	public void onEntityDamage(PlayerMoveEvent event) {
		Atirar(event.getPlayer());
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			if ((this.fall.contains(player.getName()))
					&& (event.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
				event.setCancelled(true);
				this.fall.remove(player.getName());
			}
		}
	}
}
