package me.VideoSRC.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Poseidon implements Listener {
	@EventHandler
	public void onPlayerMove1(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (Main.Partida) {
			Material m = e.getPlayer().getLocation().getBlock().getType();
			if ((Habilidade.getAbility(p).equalsIgnoreCase("poseidon"))
					&& ((m == Material.STATIONARY_WATER) || (m == Material.WATER))) {
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1));
			}
		}
	}
}
