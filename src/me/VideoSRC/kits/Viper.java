package me.VideoSRC.kits;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Viper implements Listener {
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if ((Main.Partida) && ((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity))) {
			LivingEntity entity = (LivingEntity) e.getEntity();
			Player p = (Player) e.getDamager();
			if (Habilidade.getAbility(p).equalsIgnoreCase("viper")) {
				Random rand = new Random();
				int percent = rand.nextInt(100);
				if (percent <= 33) {
					entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 120, 0));
					return;
				}
				return;
			}
			return;
		}
	}
}
