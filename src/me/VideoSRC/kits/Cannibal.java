package me.VideoSRC.kits;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Cannibal implements Listener {


@EventHandler(priority=EventPriority.MONITOR)
public void Dano(EntityDamageByEntityEvent e) {
	if (e.isCancelled())
		return;
	
	if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
		Player p = (Player) e.getDamager();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("cannibal"))) {
			if (new Random().nextInt(100) <= 35) {
				Player d = (Player) e.getEntity();
				
				Main.runLater(() -> {
					d.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 150, 2));
					p.setFoodLevel(20);
					if (new Random().nextInt(100) <= 35) {
						d.setFoodLevel((int) (d.getFoodLevel() - 1.0D));
					}
				}, 1);
			}
		}
	}
}
}