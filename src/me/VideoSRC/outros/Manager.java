package me.VideoSRC.outros;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class Manager {

	public static void darItens(Player p) {

		p.getInventory().clear();
		ItemStack kits2 = new ItemStack(Material.DAYLIGHT_DETECTOR);
		ItemMeta mkits2 = kits2.getItemMeta();
		mkits2.setDisplayName("§aRanks §7(Clique)");
		kits2.setItemMeta(mkits2);
		p.getInventory().setItem(3, kits2);
		p.updateInventory();
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta mkits = kits.getItemMeta();
		mkits.setDisplayName("§aKits §7(Clique)");
		kits.setItemMeta(mkits);
		p.getInventory().setItem(4, kits);
		p.updateInventory();
		ItemStack shop = new ItemStack(Material.STORAGE_MINECART);
		ItemMeta mshop = shop.getItemMeta();
		mshop.setDisplayName("§aShop §7(Clique)");
		shop.setItemMeta(mshop);
		p.getInventory().setItem(5, shop);
		p.updateInventory();
		p.setGameMode(GameMode.SURVIVAL);
	}

	public static void darBussola(Player p) {

		ItemStack kits = new ItemStack(Material.COMPASS);
		ItemMeta mkits = kits.getItemMeta();
		mkits.setDisplayName("§cBussola");
		kits.setItemMeta(mkits);

		p.getInventory().setItem(0, kits);

		p.updateInventory();
	}

	public static void darBalde(Player p) {

		ItemStack balde = new ItemStack(Material.WATER_BUCKET);
		ItemMeta mbalde = balde.getItemMeta();
		mbalde.setDisplayName("§b§lVOCE VENCEU!");
		balde.setItemMeta(mbalde);

		p.getInventory().setItem(4, balde);

		p.updateInventory();
	}

	public static void tpwSpawn(Player p) {

		int topX = 0;
		int topZ = 0;
		int topY = 100;

		Location loc1 = new Location(p.getWorld(), topX, topY, topZ);
		p.teleport(loc1);
	}

	public static void tpSpawn(Player p) {

		Location plocation = p.getLocation();
		int topX = 0;
		int topZ = 0;
		int topY = plocation.getWorld().getHighestBlockYAt(topX, topZ);

		Location loc1 = new Location(p.getWorld(), topX, topY + 1, topZ);
		p.teleport(loc1);
	}

	public static void darItemInv(final Inventory inv, final Material mat, final int quantidade, final int modo,
			final String nome, final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade, (short) modo);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		inv.setItem(lugar, item);
	}
}