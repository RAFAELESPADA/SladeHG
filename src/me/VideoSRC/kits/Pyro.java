package me.VideoSRC.kits;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Habilidade;

public class Pyro implements Listener {
	@EventHandler
	public void onPlayerDropItemKit1(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		Block block = event.getBlockPlaced();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("pyro")) && (block.getType().equals(Material.FIREBALL))) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerDropItemKit1pyro(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		Material item = event.getItemDrop().getItemStack().getType();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("pyro")) && (item == Material.FIREBALL)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteractpyro(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();
		if ((event.getAction() == Action.RIGHT_CLICK_AIR) && (item != null) && (item.getType() == Material.FIREBALL)
				&& (Habilidade.getAbility(player).equalsIgnoreCase("pyro"))) {
			item.setAmount(item.getAmount() - 1);
			if (item.getAmount() == 0) {
				event.getPlayer().setItemInHand(new ItemStack(Material.AIR));
			}
			Fireball ball = (Fireball) event.getPlayer().launchProjectile(Fireball.class);
			ball.setIsIncendiary(true);
			ball.setYield(ball.getYield() * 1.5F);
		}
	}
}
