package me.VideoSRC.eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.api.Habilidade;

public class LoadKits implements Listener {
	public static void CheckKits(Player p) {
		if (Habilidade.getAbility(p).equalsIgnoreCase("kangaroo")) {
			ItemStack kit = new ItemStack(Material.FIREWORK);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cKangaroo");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("none")) {
			ItemStack kit = new ItemStack(Material.STONE_SWORD);
			ItemStack kit2 = new ItemStack(Material.STONE_SWORD);
			p.getInventory().addItem(kit);
			p.getInventory().addItem(kit2);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("crafter")) {
			ItemStack kit = new ItemStack(Material.NETHER_STAR);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cCrafter");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("flash")) {
			ItemStack kit = new ItemStack(Material.REDSTONE_TORCH_ON);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cFlash");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("enderman")) {
			ItemStack kit = new ItemStack(Material.ENDER_PEARL, 3);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cEnderman");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("launcher")) {
			ItemStack kit = new ItemStack(Material.SPONGE, 20);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cLauncher");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("well")) {
			ItemStack kit = new ItemStack(Material.GOLD_NUGGET);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cWell");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("grandpa")) {
			ItemStack kit = new ItemStack(Material.STICK);
			kit.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cGrandpa");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("bigjump")) {
			ItemStack kit = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cBigJump");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("backpacker")) {
			ItemStack kit = new ItemStack(Material.LEATHER);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cBackPacker");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("wolff")) {
			ItemStack kit = new ItemStack(Material.FLINT);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cWolff");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("fireman")) {
			ItemStack kit = new ItemStack(Material.WATER_BUCKET);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cFireman");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("demoman")) {
			ItemStack kit = new ItemStack(Material.STONE_PLATE, 6);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cDemoman");
			kit.setItemMeta(rkit);
			p.updateInventory();
			ItemStack kits = new ItemStack(Material.GRAVEL, 6);
			ItemMeta rkits = kits.getItemMeta();
			rkits.setDisplayName("§cDemoman");
			kits.setItemMeta(rkits);
			p.updateInventory();
			p.getInventory().setItem(1, kit);
			p.getInventory().setItem(2, kits);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("endermage")) {
			ItemStack kit = new ItemStack(Material.PORTAL);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cEndermage");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("fisherman")) {
			ItemStack kit = new ItemStack(Material.FISHING_ROD);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cFisherman");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("forger")) {
			ItemStack kit = new ItemStack(Material.COAL, 16);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cForger");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("gladiator")) {
			ItemStack kit = new ItemStack(Material.IRON_FENCE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cGladiator");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("grappler")) {
			ItemStack kit = new ItemStack(Material.LEASH);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cGrappler");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("lumberjack")) {
			ItemStack kit = new ItemStack(Material.WOOD_AXE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cLumberJack");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("miner")) {
			ItemStack kit = new ItemStack(Material.STONE_PICKAXE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cMiner");
			kit.setItemMeta(rkit);
			kit.addEnchantment(Enchantment.DIG_SPEED, 1);
			kit.addEnchantment(Enchantment.DURABILITY, 3);

			ItemStack kits = new ItemStack(Material.APPLE, 3);
			ItemMeta rkits = kits.getItemMeta();
			rkits.setDisplayName("§cMiner");
			kits.setItemMeta(rkits);

			p.getInventory().setItem(1, kit);
			p.getInventory().setItem(2, kits);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("monk")) {
			ItemStack kit = new ItemStack(Material.BLAZE_ROD);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cMonk");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("reaper")) {
			ItemStack kit = new ItemStack(Material.WOOD_HOE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cReaper");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("specialist")) {
			ItemStack kit = new ItemStack(Material.BOOK);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cSpecialist");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("switcher")) {
			ItemStack kit = new ItemStack(Material.SNOW_BALL, 16);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cSwitcher");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("thor")) {
			ItemStack kit = new ItemStack(Material.WOOD_AXE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cThor");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("forcefield")) {
			ItemStack kit = new ItemStack(Material.getMaterial(101));
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cForcefield");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("timelord")) {
			ItemStack kit = new ItemStack(Material.WATCH);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cTimelord");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("Avatar")) {
			ItemStack kit = new ItemStack(Material.BEACON);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§cAvatar");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("pyro")) {
			ItemStack kit = new ItemStack(Material.FIREBALL, 6);
			ItemStack kit2 = new ItemStack(Material.FLINT_AND_STEEL);
			ItemMeta rkit = kit.getItemMeta();
			ItemMeta rkit2 = kit.getItemMeta();
			rkit.setDisplayName("§cPyro");
			rkit2.setDisplayName("§cPyro");
			kit.setItemMeta(rkit);
			kit2.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.getInventory().setItem(2, kit2);
			p.updateInventory();
		}
	}
}
