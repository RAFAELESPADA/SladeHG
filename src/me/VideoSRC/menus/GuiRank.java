package me.VideoSRC.menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.outros.Manager;
import me.VideoSRC.pontos.SistemaPontos;

public class GuiRank implements Listener {

	public static String Rank(Player p) {

		double a = SistemaPontos.MostrarDinheiroPlayer(p);
		if (a <= 500.0D) {
			return "§7Bronze";
		}
		if (a <= 1500.0D) {
			return "§6Ouro";
		}
		if (a <= 2500.0D) {
			return "§fPlatina";
		}
		if (a <= 3500.0D) {
			return "§bDiamante";
		}
		if (a <= 5000.0D) {
			return "§cRuby";
		}
		return "§cRuby";
	}

	public static void GuiRanks(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 36, "§8Ranks:");
		final ItemStack vidro = new ItemStack(Material.getMaterial(102));
		final ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName(" ");
		vidro.setItemMeta(vidrom);
		final ItemStack ruby = new ItemStack(Material.INK_SACK, 1, (short) 1);
		final ItemMeta rubym = ruby.getItemMeta();
		rubym.setDisplayName("§cRuby");
		ruby.setItemMeta(rubym);
		final ItemStack papel = new ItemStack(Material.PAPER);
		final ItemMeta papelm = papel.getItemMeta();
		papelm.setDisplayName("§aRanks");
		final ArrayList<String> paperdesc = new ArrayList<String>();
		paperdesc.add("§fRank: §7" + Rank(p));
		paperdesc.add("§fPontos: §7" + SistemaPontos.MostrarDinheiroPlayer(p));
		papelm.setLore((List) paperdesc);
		papel.setItemMeta(papelm);
		Manager.darItemInv(inv, Material.getMaterial(336), 1, 0, "§7Bronze", 11);
		Manager.darItemInv(inv, Material.GOLD_INGOT, 1, 0, "§6Ouro", 12);
		Manager.darItemInv(inv, Material.getMaterial(265), 1, 0, "§fPlatina", 13);
		Manager.darItemInv(inv, Material.DIAMOND, 1, 0, "§bDiamante", 14);
		inv.setItem(15, ruby);
		inv.setItem(16, vidro);
		inv.setItem(17, vidro);
		inv.setItem(18, vidro);
		inv.setItem(19, vidro);
		Manager.darItemInv(inv, Material.INK_SACK, 1, 8, "§a0 a 500", 20);
		Manager.darItemInv(inv, Material.INK_SACK, 1, 8, "§a500 a 1500", 21);
		Manager.darItemInv(inv, Material.INK_SACK, 1, 8, "§a1500 a 2500", 22);
		Manager.darItemInv(inv, Material.INK_SACK, 1, 8, "§a2500 a 3500", 23);
		Manager.darItemInv(inv, Material.INK_SACK, 1, 8, "§a5000", 24);
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("§8Ranks:") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.getMaterial(102)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.PAPER) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(336)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(405)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(226)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(264)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(388)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(351)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(265)) {
				e.setCancelled(true);
			}
		}
	}
}
