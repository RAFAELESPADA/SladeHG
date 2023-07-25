package me.VideoSRC.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Habilidade;

public class Achilles implements Listener {
	@EventHandler
	public void onDamageAchilles(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			Player player = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			ItemStack item = ((Player) e.getDamager()).getItemInHand();
			if ((Habilidade.getAbility(player).equalsIgnoreCase("achilles")) && (damager.getItemInHand() != null)) {
				if (item.getType().equals(Material.WOOD_SWORD)) {
					e.setDamage(6.0D);
				} else if (item.getType().equals(Material.WOOD_AXE)) {
					e.setDamage(e.getDamage() + 6.0D);
				} else if (item.getType().equals(Material.WOOD_SPADE)) {
					e.setDamage(e.getDamage() + 6.0D);
				} else if (item.getType().equals(Material.WOOD_PICKAXE)) {
					e.setDamage(e.getDamage() + 6.0D);
				} else if (item.getType().equals(Material.STONE_SWORD)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.STONE_PICKAXE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.STONE_HOE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.IRON_SWORD)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.IRON_PICKAXE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.IRON_SPADE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.IRON_HOE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.GOLD_SWORD)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.DIAMOND_SWORD)) {
					e.setDamage(e.getDamage() - 3.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.DIAMOND_SPADE)) {
					e.setDamage(e.getDamage() - 3.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				} else if (item.getType().equals(Material.DIAMOND_HOE)) {
					e.setDamage(e.getDamage() - 3.0D);
					damager.sendMessage(
							"§3Huh, o cabo de §3§omadeira §3faz mais dano que uma lamina para esse cara...");
				}
			}
		}
	}
}
