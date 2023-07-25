package me.VideoSRC.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.Main;
import me.VideoSRC.api.EspectadoresManager;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.outros.Manager;

public class PreJoin implements Listener {
	public ArrayList<String> antilog = new ArrayList();
	public ArrayList<String> NoLog = new ArrayList();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuitInv(PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(p));
		e.setQuitMessage(null);
		if (Main.PreGame) {
			return;
		}
		Main.saiu.add(p.getName());
		if (Main.saiu.contains(p.getName())) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					if (p.isOnline()) {
						return;
					}
					if (Main.Watch.contains(p.getName())) {
						return;
					}
					Main.Jogadores.remove(p.getName());
					Main.saiu.remove(p.getName());
					Main.Watch.add(p.getName());
					EspectadoresManager.DamageMobs.add(p);
			        Bukkit.broadcastMessage("§b" + p.getName() + " demorou a relogar e foi eliminado do torneio");
			        for (Player p1 : Bukkit.getOnlinePlayers()) {
			        	p1.playSound(p1.getLocation(), Sound.AMBIENCE_THUNDER, 1.0f, 1.0f);
			        }
					ChecarVitoria.verificaWin();
					PreJoin.this.NoLog.add(p.getName());
				}
			}, 650L);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCheck2(PlayerJoinEvent e) {
			Player p = e.getPlayer();
			if ((Main.Andamento > 100) && (p.hasPermission("role.vip"))) {		
			p.setAllowFlight(true);
			p.setFlying(true);
			p.sendMessage("§cSPEC§7, Voce entrou no modo espectador!");
			p.sendMessage("§cSPEC§7, Use /ir para se teleportar a algum jogador!");
Main.Watch.add(p.getName());
if (Main.Jogadores.contains(p.getName())) {
Main.Jogadores.remove(p.getName());
}
EspectadoresManager.DamageMobs.add(p);
			p.getInventory().clear();
			p.setGameMode(GameMode.CREATIVE);
			ItemStack kit = new ItemStack(Material.SLIME_BALL);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§aMenu De Transporte.");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(4, kit);

			Location loc = new Location(Bukkit.getWorld("world"), 10.0D, 140.0D, 10.0D, -90.0F, 0.0F);
			p.teleport(loc);
			for (Player pl : Bukkit.getOnlinePlayers()) {
				pl.hidePlayer(p);
			}
			}
	}

	@EventHandler
	public void onCheck(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (Main.PreGame) {
			if (Bukkit.getServer().getOnlinePlayers().size() <= Bukkit.getMaxPlayers()) {
				e.allow();
			} else if (p.hasPermission("role.vip")) {
				e.allow();
			} else {
				e.setKickMessage("§aServidor Lotado!\n§7Visite: §c" + Main.site);
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
			}
		} else {
			if (Main.Jogadores.contains(p.getName())) {
				e.allow();
			} else if ((p.hasPermission("role.vip")) && (Main.PreInvencibilidade)) {
				e.allow();
				Manager.darBussola(p);
				Main.Jogadores.add(p.getName());
			} else {
				e.setKickMessage("§cPartida em andamento!\n§7Visite: §c" + Main.site);
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
			}
			if ((Main.Watch.contains(p.getName())) && (p.hasPermission("role.vip"))) {
				e.allow();
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage("§cSPEC§7, Voce entrou no modo espectador!");
				p.sendMessage("§cSPEC§7, Use /ir para se teleportar a algum jogador!");

				p.getInventory().clear();
				p.setGameMode(GameMode.CREATIVE);
				ItemStack kit = new ItemStack(Material.SLIME_BALL);
				ItemMeta rkit = kit.getItemMeta();
				rkit.setDisplayName("§aMenu De Transporte.");
				kit.setItemMeta(rkit);
				p.getInventory().setItem(4, kit);

				Location loc = new Location(Bukkit.getWorld("world"), 10.0D, 140.0D, 10.0D, -90.0F, 0.0F);
				p.teleport(loc);
				Player[] arrayOfPlayer;
				for (Player pl : Bukkit.getOnlinePlayers()) {
					pl.hidePlayer(p);
				}
			}
			if (this.NoLog.contains(p.getName())) {
				e.setKickMessage("§eVoce demorou demais!\n§7Visite: §c" + Main.site);
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
			} else if (p.hasPermission("role.vip")) {
				e.allow();
			}
			if (this.antilog.contains(p.getName())) {
				e.setKickMessage("§cVoce deslogou em PvP\n§7Visite: §c" + Main.site);
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
			} else if (p.hasPermission("role.vip")) {
				e.allow();
			}
			if (Main.mortos.contains(p.getName())) {
				e.setKickMessage("§cVoce morreu\n§7Visite: §c" + Main.site);
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
			} else if (p.hasPermission("role.vip")) {
				e.allow();
			}
			if ((Main.Andamento > 100) && (p.hasPermission("role.vip"))) {
				e.allow();
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage("§cSPEC§7, Voce entrou no modo espectador!");
				p.sendMessage("§cSPEC§7, Use /ir para se teleportar a algum jogador!");
Main.Watch.add(p.getName());
EspectadoresManager.DamageMobs.add(p);
				p.getInventory().clear();
				p.setGameMode(GameMode.CREATIVE);
				ItemStack kit = new ItemStack(Material.SLIME_BALL);
				ItemMeta rkit = kit.getItemMeta();
				rkit.setDisplayName("§aMenu De Transporte.");
				kit.setItemMeta(rkit);
				p.getInventory().setItem(4, kit);

				Location loc = new Location(Bukkit.getWorld("world"), 10.0D, 140.0D, 10.0D, -90.0F, 0.0F);
				p.teleport(loc);
				for (Player pl : Bukkit.getOnlinePlayers()) {
					pl.hidePlayer(p);
				}
			} else {
				e.setKickMessage("§cPartida em andamento!\n§7Visite: §c" + Main.site);
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
		}
		}
	}

	@EventHandler
	public void AntiCaps(AsyncPlayerChatEvent evt) {
		if (!evt.getPlayer().hasPermission("role.vip")) {
			evt.setMessage(evt.getMessage().toLowerCase());
		}
	}

	@EventHandler
	public void onAntiLogDmg(EntityDamageByEntityEvent event) {
		if (((event.getDamager() instanceof Player)) && ((event.getEntity() instanceof Player))) {
			final Player player = (Player) event.getEntity();
			final Player target = (Player) event.getDamager();
			if ((Main.Partida) && (!this.antilog.contains(player.getName()))
					&& (!this.antilog.contains(target.getName()))) {
				this.antilog.add(player.getName());
				this.antilog.add(target.getName());
				Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						if ((PreJoin.this.antilog.contains(player.getName()))
								&& (PreJoin.this.antilog.contains(target.getName()))) {
							PreJoin.this.antilog.remove(player.getName());
							PreJoin.this.antilog.remove(target.getName());
						}
					}
				}, 450L);
			}
		}
	}
}
