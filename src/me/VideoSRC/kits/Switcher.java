package me.VideoSRC.kits;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.VideoSRC.api.Habilidade;

public class Switcher implements Listener {
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		Entity ent = e.getEntity();
		Entity damager = e.getDamager();
		if ((ent instanceof Player)) {
			Player hit = (Player) ent;
			if ((damager instanceof Snowball)) {
				Snowball snowball = (Snowball) damager;
				if ((snowball.getShooter() instanceof Player)) {
					Player shooter = (Player) snowball.getShooter();
					if (Habilidade.getAbility(shooter).equalsIgnoreCase("switcher")) {
						Location ploc = shooter.getLocation();
						Location hitloc = hit.getLocation();
						shooter.teleport(hitloc);
						hit.teleport(ploc);
					}
				}
			}
		}
	}
}
