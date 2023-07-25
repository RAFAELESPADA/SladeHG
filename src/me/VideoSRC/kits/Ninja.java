package me.VideoSRC.kits;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Ninja implements Listener {
	public HashMap<Player, Player> a = new HashMap();
	public HashMap<Player, Long> b = new HashMap();

	@EventHandler
	public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player))
				&& ((paramEntityDamageByEntityEvent.getEntity() instanceof Player))) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (Habilidade.getAbility(localPlayer1).equalsIgnoreCase("ninja")) {
				this.a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
					}
				}, 200L);
			}
		}
	}

	@EventHandler
	public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		if (Main.Partida) {
			Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
			if ((paramPlayerToggleSneakEvent.isSneaking())
					&& (Habilidade.getAbility(localPlayer1).equalsIgnoreCase("ninja"))
					&& (this.a.containsKey(localPlayer1))) {
				Player localPlayer2 = (Player) this.a.get(localPlayer1);
				if ((localPlayer2 != null) && (!localPlayer2.isDead())) {
					String str = null;
					if (this.b.get(localPlayer1) != null) {
						long l = ((Long) this.b.get(localPlayer1)).longValue() - System.currentTimeMillis();
						DecimalFormat localDecimalFormat = new DecimalFormat("##");
						int i = (int) l / 1000;
						str = localDecimalFormat.format(i);
					}
					if ((this.b.get(localPlayer1) == null)
							|| (((Long) this.b.get(localPlayer1)).longValue() < System.currentTimeMillis())) {
						if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 50.0D) {
							localPlayer1.teleport(localPlayer2.getLocation());
							localPlayer1.sendMessage("§cNINJA§7, Teleportado!");
							localPlayer1.playSound(localPlayer1.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
							this.b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
						} else {
							localPlayer1.sendMessage("§cNINJA§7, Jogador muito longe!");
						}
					} else {
						localPlayer1.sendMessage("§cNINJA§7, Voce esta em cooldown!");
					}
				}
			}
		}
	}
}
