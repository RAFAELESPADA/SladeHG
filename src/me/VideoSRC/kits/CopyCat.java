package me.VideoSRC.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.VideoSRC.api.Habilidade;
import me.VideoSRC.comandos.CMDKit;
import me.VideoSRC.eventos.LoadKits;

public class CopyCat implements Listener {
	@EventHandler
	public void onCopyCat(PlayerDeathEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player))) {
			Player p = e.getEntity();
			Player p2 = e.getEntity().getKiller();
			if (CMDKit.CopyCat.contains(p2.getName())) {
				String NovoKit = Habilidade.getAbility(p);
				Habilidade.setAbility(p2, NovoKit);
				LoadKits.CheckKits(p2);
				p2.sendMessage("§cCOPYCAT§7, Seu novo kit: §c" + NovoKit.toUpperCase());
			}
		}
	}
}
