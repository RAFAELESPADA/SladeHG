package me.VideoSRC.menus;


import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.Coins;
import me.VideoSRC.Main;
import net.helix.core.bukkit.HelixBukkit;
import net.helix.core.bukkit.account.HelixPlayer;

public class Shop
  implements Listener, CommandExecutor
{
  private Main main;
  public static Inventory shop = Bukkit.getServer().createInventory(null, 54, "§cLoja de kits");
  
  static
  {
    createButton(Material.WOOD_SWORD, shop, 0, "§cAchilles", "§eCoins:" + " 5000");
    createButton(Material.ANVIL, shop, 1, "§cAnchor", "§eCoins:" + " 5000");
    createButton(Material.QUARTZ, shop, 2, "§cBoxer", "§eCoins:" + " 5000");
    createButton(Material.RAW_CHICKEN, shop, 3, "§cCannibal", "§eCoins:" + " 5000");
    createButton(Material.YELLOW_FLOWER, shop, 4, "§cCopyCat", "§eCoins:" + " 5000");
    createButton(Material.WORKBENCH, shop, 5, "§cCrafter", "§eCoins:" + " 5000");
    createButton(Material.SEEDS, shop, 6, "§6-> §cCultivator", "§eCoins:" + " 5000");
    createButton(Material.STONE_PLATE, shop, 7, "§cDemoman",  "§eCoins:" + " 5000");
    createButton(Material.ENDER_PORTAL_FRAME, shop, 8, "§cEnderman", "§eCoins:" + " 5000");
    createButton(Material.IRON_FENCE, shop, 9, "§cGladiator", "§eCoins:" + " 5000");
    createButton(Material.COAL, shop, 10, "§cNinja", "§eCoins:" + " 5000");
    createButton(Material.WATCH, shop, 11, "§cTimelord", "§eCoins:" + " 5000");
    createButton(Material.IRON_AXE, shop, 12, "§cViking", "§eCoins:" + " 5500");
    createButton(Material.WATER_BUCKET, shop, 13, "§cPoseidon", "§eCoins:" + " 5000");
    createButton(Material.REDSTONE_TORCH_ON, shop, 14, "§cFlash", "§eCoins:" + " 5000");
    createButton(Material.LAVA_BUCKET, shop, 15, "§cFireman", "§eCoins:" + " 5000");
    createButton(Material.BARRIER, shop, 53, "§cFechar Loja", "§fFechar loja");
  }
  
  public Shop(Main main)
  {
	ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
    ItemMeta vidro2 = vidro.getItemMeta();
    vidro2.setDisplayName("§a§k=====");
    vidro.setItemMeta(vidro2);
    ItemStack[] arrayOfItemStack;
    int descpyro1 = (arrayOfItemStack = shop.getContents()).length;
    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
    {
      ItemStack item = arrayOfItemStack[metapyro1];
      if (item == null) {
        shop.setItem(shop.firstEmpty(), vidro);
      }
    }
    this.main = main;
  }
  
  private static void createButton(Material mat, Inventory inv, int Slot, String name, String lore)
  {
    ItemStack item = new ItemStack(mat);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(name);
    meta.setLore(Arrays.asList(new String[] { lore }));
    item.setItemMeta(meta);
    inv.setItem(Slot, item);
  }
  
  
  public void openMenu(Player p)
  {
    p.openInventory(shop);
    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
  }
  
  @EventHandler
  public void kit(InventoryClickEvent e)
  {
    Inventory inv = e.getInventory();
    if (inv.getTitle().equals(shop.getName())) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    Inventory inv = e.getInventory();
    Player p = (Player)e.getWhoClicked();
    if (inv.getTitle().equals("§cLoja de kits"))
    {
      p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
      e.setCancelled(true);
    }
    ItemStack clicked = e.getCurrentItem();
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem() == null)) {
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getType() == Material.AIR)) {
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE)) {
        return;
      }
    if ((inv.getName().equals(shop.getName())) && (p.hasPermission("role.vip") && (!(clicked.getType() == Material.BARRIER)) && (!(clicked.getType() == Material.STAINED_GLASS_PANE) && inv.getTitle().equals("§cLoja de kits")))) {
    	p.sendMessage("§e[HG] §cVocê já tem todos os kits!");
    	p.closeInventory();
    	return;
    }
    if ((inv.getName().equals(shop.getName()) && p.hasPermission("hg.kit." + ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())) && inv.getTitle().equals("§cLoja de kits") && (!(clicked.getType() == Material.BARRIER)))) {
    		p.sendMessage("§e[HG] §cVocê já tem esse kit!");
      		p.closeInventory();
      		return;
    	}
    	HelixPlayer p1 = HelixBukkit.getInstance().getPlayerManager().getPlayer(p.getName());
      if (p1.getPvp().getCoins() >= 5000 && inv.getTitle().equals("§cLoja de kits")  && (!(clicked.getType() == Material.BARRIER)  && (!(clicked.getType() == Material.CHEST))  && (!(clicked.getType() == Material.DAYLIGHT_DETECTOR)  && (!(clicked.getType() == Material.STORAGE_MINECART) && (!(clicked.getType() == Material.STAINED_GLASS_PANE)  && (clicked.hasItemMeta()))))))
      {
        Coins.perms.playerAdd(p, "hg.kit." + ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
        p.sendMessage("§6-> §cVocê comprou o kit §e§l" + ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
        p1.getPvp().removeCoins(5000);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (p1.getPvp().getCoins() < 5000 && inv.getTitle().equals("§cLoja de kits"))
      {
        p.sendMessage("§cVocê não tem dinheiro o bastante");
        e.setCancelled(true);
        p.closeInventory();
      }
    
  }
  
  private Material ItemStack(Material stainedGlassPane, int i, short s) {
	// TODO Auto-generated method stub
	return null;
}

public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    return false;
  }
}

