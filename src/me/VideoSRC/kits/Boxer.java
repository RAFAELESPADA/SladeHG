package me.VideoSRC.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.VideoSRC.api.Habilidade;
import net.minecraft.server.v1_8_R3.Material;

public class Boxer implements Listener {

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void boxerHabilidade(EntityDamageByEntityEvent evento) {
		if ((evento.getDamager() instanceof Player)) {
			if ((evento.getEntity() instanceof Player)) {
				Player jogador2 = (Player) evento.getEntity();
				Player Player = null;
				if (Habilidade.getAbility(Player).equalsIgnoreCase("Boxer")) {
					evento.setDamage(evento.getDamage() + 1.0D);
					return;
				}
				org.bukkit.entity.Player p = null;
				if (Habilidade.getAbility(p).equalsIgnoreCase("Boxer")) {
					if (jogador2.getItemInHand().getType().equals(Material.AIR)) {
						evento.setDamage(evento.getDamage() - 1.0D);
						return;
					}
				}
			}
		}
	}

}
