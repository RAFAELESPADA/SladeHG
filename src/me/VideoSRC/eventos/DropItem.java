package me.VideoSRC.eventos;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class DropItem implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("forcefield"))
				&& (e.getItemDrop().getItemStack().getType() == Material.getMaterial(101))) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("crafter"))
				&& (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("demoman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.GRAVEL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("grandpa"))
				&& (e.getItemDrop().getItemStack().getType() == Material.STICK)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("demoman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.STONE_PLATE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("endermage"))
				&& (e.getItemDrop().getItemStack().getType() == Material.PORTAL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("jellyfish"))
				&& (e.getItemDrop().getItemStack().getType() == Material.CLAY_BALL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("flash"))
				&& (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("enderman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.ENDER_PEARL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("fisherman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("gladiator"))
				&& (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("grappler"))
				&& (e.getItemDrop().getItemStack().getType() == Material.LEASH)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("kangaroo"))
				&& (e.getItemDrop().getItemStack().getType() == Material.FIREWORK)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("monk"))
				&& (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("reaper"))
				&& (e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("specialist"))
				&& (e.getItemDrop().getItemStack().getType() == Material.BOOK)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("thor"))
				&& (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("timelord"))
				&& (e.getItemDrop().getItemStack().getType() == Material.WATCH)) {
			e.setCancelled(true);
			p.updateInventory();
		}
	}
	public static boolean isFull(Inventory p) {
		if (p.firstEmpty() == -1) {
			return true;
		}
		return false;
	}
@EventHandler
public void onBreak(BlockBreakEvent event) {
	if (event.isCancelled()) {
		return;
	}
	Player player = event.getPlayer();
	
	
	if (!Main.Jogadores.contains(player.getName()) || Main.Watch.contains(player.getName())) {
		return;
	}
	Block block = event.getBlock();
	
	if (block.getType() == Material.COBBLESTONE || block.getType() == Material.STONE) {
		if (!isFull(player.getInventory())) {
			event.getBlock().setType(Material.AIR);
			player.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
		} else {
			for (ItemStack itens : player.getInventory().getContents()) {
				 if ((itens.getType().equals(block.getType())) && (itens.getAmount() != 64)) {
					  event.getBlock().setType(Material.AIR);
					  player.getInventory().addItem(new ItemStack(Material.COBBLESTONE));
					  break;
				 }
			}
		}
	} else if (block.getType() == Material.BROWN_MUSHROOM) {
		if (!isFull(player.getInventory())) {
			event.getBlock().setType(Material.AIR);
			player.getInventory().addItem(new ItemStack(Material.BROWN_MUSHROOM));
		} else {
			for (ItemStack itens : player.getInventory().getContents()) {
				 if ((itens.getType().equals(block.getType())) && (itens.getAmount() != 64)) {
					  event.getBlock().setType(Material.AIR);
					  player.getInventory().addItem(new ItemStack(Material.BROWN_MUSHROOM));
					  break;
				 }
			}
		}
	} else if (block.getType() == Material.RED_MUSHROOM) {
		if (!isFull(player.getInventory())) {
			event.getBlock().setType(Material.AIR);
			player.getInventory().addItem(new ItemStack(Material.RED_MUSHROOM));
		} else if (block.getType() == Material.COCOA) {
				if (!isFull(player.getInventory())) {
					event.getBlock().setType(Material.AIR);
					player.getInventory().addItem(new ItemStack(Material.INK_SACK, 3 ,(short)3));
		} else {
			for (ItemStack itens : player.getInventory().getContents()) {
				 if ((itens.getType().equals(block.getType())) && (itens.getAmount() != 64)) {
					  event.getBlock().setType(Material.AIR);
					  player.getInventory().addItem(new ItemStack(Material.RED_MUSHROOM));
					  break;
				 }
			}
		}
	} else if (block.getType().name().contains("LOG")) {
		if (Habilidade.getAbility(player) == "Lumberjack") {
			return;
		}
		if (Habilidade.getAbility(player) == "jackhammer") {
			return;
		}
		if (!isFull(player.getInventory())) {
			ArrayList<ItemStack> items = new ArrayList<>(event.getBlock().getDrops());
			for (ItemStack item : items) {
				 player.getInventory().addItem(item);
			}
			event.getBlock().setType(Material.AIR);
		} else {
			for (ItemStack itens : player.getInventory().getContents()) {
				 if ((itens.getType().equals(block.getType())) && (itens.getAmount() != 64)) {
					  ArrayList<ItemStack> items = new ArrayList<>(event.getBlock().getDrops());
					  for (ItemStack item : items) {
						   player.getInventory().addItem(item);
					  }
					  event.getBlock().setType(Material.AIR);
					  break;
				 }
			}
		}
	}
}
}
}
