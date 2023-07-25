package me.VideoSRC.kits;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.SecondEvent;

public class Madman implements Listener {
	private HashMap<Player, Double> madman = new HashMap();

	@EventHandler
	public void onMadmanEffect(SecondEvent event) {
		DecimalFormat dm = new DecimalFormat("##");
		if (Main.Partida) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (Habilidade.getAbility(p).equalsIgnoreCase("madman")) {
					for (Entity e : p.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
						if (((e instanceof Player)) && (!Main.Watch.contains(e))) {
							if ((this.madman.containsKey((Player) e))
									&& (((Double) this.madman.get((Player) e)).doubleValue() < 3.0D)) {
								this.madman.put((Player) e,
										Double.valueOf(((Double) this.madman.get((Player) e)).doubleValue() + 0.03D));
							} else {
								this.madman.put((Player) e, Double.valueOf(0.03D));
								((Player) e).sendMessage(ChatColor.GRAY + "Voce se sente tonto... Ugh!");
							}
							((Player) e).sendMessage("�cMadman Effect - +"
									+ dm.format(((Double) this.madman.get((Player) e)).doubleValue() * 100.0D)
									+ "% Damage taken. (+3% / seg");
						}
					}
				}
				if (this.madman.containsKey(p)) {
					boolean hasMadMan = false;
					for (Entity e : p.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
						if (((e instanceof Player)) && (!Main.Watch.contains(e))) {
							Player mad = (Player) e;
							if (Habilidade.getAbility(mad).equalsIgnoreCase("madman")) {
								hasMadMan = true;
								break;
							}
						}
					}
					if (!hasMadMan) {
						if (((Double) this.madman.get(p)).doubleValue() - 0.1D <= 0.0D) {
							this.madman.remove(p);
							p.sendMessage(ChatColor.GRAY + "Sua cabe�a parece clara novamente");
						} else {
							this.madman.put(p, Double.valueOf(((Double) this.madman.get(p)).doubleValue() - 0.1D));
							((Player) p).sendMessage("Madman Effect -  +"
									+ dm.format(((Double) this.madman.get(p)).doubleValue() * 100.0D)
									+ "% Damage taken. (-1% / seg)");
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onMadmanDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) event.getEntity();
		if ((this.madman.containsKey(p)) && (((Double) this.madman.get(p)).doubleValue() > 0.05D)) {
			event.setDamage(event.getDamage() + event.getDamage() * ((Double) this.madman.get(p)).doubleValue());
		}
	}
}
