package me.VideoSRC.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import me.VideoSRC.api.Habilidade;

public class Fisherman implements Listener {
	@EventHandler
	public void onPlayerHitFishingrodscorpion(PlayerFishEvent event) {
		Player player = event.getPlayer();
		if ((event.getCaught() instanceof Player)) {
			Player caught = (Player) event.getCaught();
			if ((Habilidade.getAbility(player).equalsIgnoreCase("fisherman"))
					&& (player.getItemInHand().getType() == Material.FISHING_ROD)) {
				caught.teleport(player.getLocation());
				player.sendMessage("§cFISHERMAN§7, Voce puxou: §C" + caught.getName());
				caught.sendMessage("§cFISHERMAN§7, Voce foi puxado por: §C" + player.getName());
			}
		}
	}
}
