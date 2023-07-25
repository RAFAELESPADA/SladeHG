package me.VideoSRC.kits;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Turtle implements Listener {
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.Partida) {
			Player p = (Player) e.getEntity();
			if ((Habilidade.getAbility(p).equalsIgnoreCase("turtle")) && (p.isSneaking())
					&& ((e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
							|| (e.getCause() == EntityDamageEvent.DamageCause.CONTACT)
							|| (e.getCause() == EntityDamageEvent.DamageCause.CUSTOM)
							|| (e.getCause() == EntityDamageEvent.DamageCause.DROWNING)
							|| (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)
							|| (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
							|| (e.getCause() == EntityDamageEvent.DamageCause.FALL)
							|| (e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK)
							|| (e.getCause() == EntityDamageEvent.DamageCause.FIRE)
							|| (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)
							|| (e.getCause() == EntityDamageEvent.DamageCause.LAVA)
							|| (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING)
							|| (e.getCause() == EntityDamageEvent.DamageCause.MAGIC)
							|| (e.getCause() == EntityDamageEvent.DamageCause.MELTING)
							|| (e.getCause() == EntityDamageEvent.DamageCause.POISON)
							|| (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE)
							|| (e.getCause() == EntityDamageEvent.DamageCause.STARVATION)
							|| (e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION)
							|| (e.getCause() == EntityDamageEvent.DamageCause.THORNS)
							|| (e.getCause() == EntityDamageEvent.DamageCause.VOID)
							|| (e.getCause() == EntityDamageEvent.DamageCause.WITHER))) {
				e.setDamage(1.5D);
				p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 3);
				return;
			}
		}
	}
}
