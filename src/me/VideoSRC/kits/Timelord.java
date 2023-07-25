package me.VideoSRC.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Timelord implements Listener {
	public static ArrayList<String> frozenPlayers = new ArrayList();
	public static ArrayList<String> freezing = new ArrayList();
	public static ArrayList<String> freeze = new ArrayList();
	public static ArrayList<String> cooldownt = new ArrayList();

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if (freeze.contains(p.getName())) {
			freeze.remove(p.getName());
			freezing.remove(p.getName());
			frozenPlayers.remove(p.getName());
		}
	}

	@EventHandler
	public void timelordkit(PlayerInteractEvent event) {
		if (Main.Partida) {
			final Player player = event.getPlayer();
			if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
					&& (player.getItemInHand().getType() == Material.WATCH)
					&& (Habilidade.getAbility(player).equalsIgnoreCase("timelord"))) {
				if (cooldownt.contains(player.getName())) {
					player.sendMessage("§cTIMELORD§7, Voce esta em cooldown!");
				} else {
					for (Entity frozen : player.getNearbyEntities(4.0D, 4.0D, 4.0D)) {
						if ((frozen != null) && ((frozen instanceof Player))) {
							freeze.add(((Player) frozen).getName());
							if (!freezing.contains(player.getName())) {
								player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
								player.getWorld().playSound(player.getLocation(), Sound.WITHER_SHOOT, 10.0F, 1.0F);
								freezing.add(player.getName());
								cooldownt.add(player.getName());
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance,
										new Runnable() {
											public void run() {
												Timelord.freezing.remove(player.getName());
												Timelord.cooldownt.remove(player.getName());
												Timelord.freeze.remove(player.getName());
												Timelord.frozenPlayers.remove(player.getName());
												player.sendMessage("�cTIMELORD�7, Seu cooldown acabou!");
											}
										}, 600L);
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if (freezing.contains(p.getName())) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					freeze.remove(p.getName());
					freezing.remove(p.getName());
					frozenPlayers.remove(p.getName());
				}
			}, 40L);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if ((freeze.contains(player.getName())) && (!freezing.contains(player.getName()))) {
			event.setTo(player.getLocation());
			player.sendMessage("�cTIMELORD�7, Voce foi congelado!");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					Timelord.freeze.remove(player.getName());
				}
			}, 160L);
		}
	}
}
