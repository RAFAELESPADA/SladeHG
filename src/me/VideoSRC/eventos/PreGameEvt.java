package me.VideoSRC.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.outros.Manager;

public class PreGameEvt implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Main.PreGame) {
			Main.Jogadores.remove(p.getName());
		}
	}

	@EventHandler
	public void DamageMobs(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof LivingEntity)) {
			return;
		}
		if (Main.PreGame) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void DamagePlayers(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		if (Main.PreGame) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.PreGame) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onWin(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.Finalizando) {
			e.setCancelled(true);
			return;
		}
	}
	@EventHandler
	public void BlockIgnite(BlockIgniteEvent event) {
		if (Main.PreGame) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void craftItem(CraftItemEvent event) {
		if (Main.PreGame) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void fisicaDoCogu(BlockPhysicsEvent e) {
		if (e.getBlock().getType().equals(Material.BROWN_MUSHROOM)) {
			e.setCancelled(true);
		} else if (e.getBlock().getType().equals(Material.RED_MUSHROOM)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		e.setJoinMessage(null);
		if (Main.PreGame) {
			p.getInventory().clear();
			Main.Jogadores.add(p.getName());
			TitleAPI.sendTitle(p,  20 , 60 , 20, Strings.nomeserver , "§eBem vindo!");

			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "None");
			Manager.darItens(p);
			Manager.tpwSpawn(p);
			Manager.tpSpawn(p);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
				}
			}, 5L);
		}
	}
}
