package me.VideoSRC.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.VideoSRC.Main;
import me.VideoSRC.menus.GuiRank;
import me.VideoSRC.menus.MenuKits1;

public class LoadTag implements Listener {


	@EventHandler(priority = EventPriority.MONITOR)
	public void Stats(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((Main.PreGame) && (p.getItemInHand().getType() == Material.DAYLIGHT_DETECTOR)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			;
			GuiRank.GuiRanks(p);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void Kits(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((Main.PreGame) && (p.getItemInHand().getType() == Material.CHEST)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			MenuKits1.InventarioKitsGui(p);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void Shop(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((Main.PreGame) && (p.getItemInHand().getType() == Material.STORAGE_MINECART)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			p.openInventory(me.VideoSRC.menus.Shop.shop);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	}

	

	}
