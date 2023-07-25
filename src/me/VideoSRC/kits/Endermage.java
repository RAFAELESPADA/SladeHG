package me.VideoSRC.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Endermage implements Listener {
	public ArrayList<String> inPvP = new ArrayList();
	public static ArrayList<Player> admin = new ArrayList();
	public static String prefix;

	@EventHandler
	public void onPlace(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		Player p2 = event.getPlayer();
		if (((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_BLOCK))
				&& (item != null) && (Habilidade.getAbility(p2).equalsIgnoreCase("endermage"))
				&& (event.getMaterial() == Material.PORTAL)
				&& (!event.getClickedBlock().getType().equals(Material.BEDROCK))) {
			event.setCancelled(true);
			final Block b = event.getClickedBlock();
			if ((Habilidade.getAbility(p2).equalsIgnoreCase("endermage")) && (b.getTypeId() == 120)) {
				return;
			}
			item.setAmount(0);
			if (item.getAmount() == 0) {
			}
			final Location portal = b.getLocation().clone().add(0.5D, 0.5D, 0.5D);
			b.getType();
			b.getData();
			portal.getBlock().setTypeId(120);
			final Player mager = event.getPlayer();
			for (int i = 0; i <= 5; i++) {
				final int no = i;
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						for (Player p1 : Bukkit.getOnlinePlayers()) {
							Player p = p1.getPlayer();
							if ((b.getTypeId() == 120) && (p != mager.getPlayer())
									&& (Endermage.this.isEnderable(portal, p.getLocation()))) {
								Location teleport = portal.clone().add(0.0D, 0.5D, 0.0D);
								if (p.getLocation().distance(portal) > 3.0D) {
									if ((!Habilidade.getAbility(p).equalsIgnoreCase("endermage")) ||

											(!Endermage.admin.contains(p)) ||

											(!Endermage.admin.contains(mager)) ||

											(!Endermage.this.inPvP.contains(p)) ||

											(!Endermage.this.inPvP.contains(mager)) ||

											(!Endermage.admin.contains(mager))) {
										mager.getPlayer().sendMessage(
												"§cKIT§7, Voce puxou alguem Voce esta invencevel por 5 segundos");
										p.sendMessage("§cKIT§7, Voce foi puxado! Voce esta invencevel por 5 segundos");
										p.setNoDamageTicks(100);

										mager.getPlayer().setNoDamageTicks(100);

										p.addPotionEffect(
												new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
										p.getPlayer().setNoDamageTicks(100);

										mager.addPotionEffect(
												new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
										mager.getPlayer().teleport(teleport);
										p.teleport(teleport);
									} else {
									}
									ItemStack item = new ItemStack(Material.PORTAL);
									mager.getInventory().addItem(new ItemStack[] { item });
								}
								if ((portal.getBlock().getType() != Material.RED_MUSHROOM)
										|| (portal.getBlock().getType() != Material.BROWN_MUSHROOM)
										|| (portal.getBlock().getType() != Material.CHEST)) {
									portal.getBlock().setTypeId(121);
								}
							}
							if (no == 5) {
								if (b.getType() == Material.ENDER_PORTAL_FRAME) {
									ItemStack item = new ItemStack(Material.PORTAL);
									mager.getInventory().addItem(new ItemStack[] { item });
								}
								if ((portal.getBlock().getType() != Material.RED_MUSHROOM)
										|| (portal.getBlock().getType() != Material.BROWN_MUSHROOM)
										|| (portal.getBlock().getType() != Material.CHEST)) {
									portal.getBlock().setTypeId(121);
								}
							}
						}
					}
				}, i * 20);
			}
		}
	}

	private boolean isEnderable(Location portal, Location player) {
		return (Math.abs(portal.getX() - player.getX()) < 2.5D) && (Math.abs(portal.getZ() - player.getZ()) < 2.5D)
				&& (Math.abs(portal.getY() - player.getY()) > 3.0D);
	}
}
