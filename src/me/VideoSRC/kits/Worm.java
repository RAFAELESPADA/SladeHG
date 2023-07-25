package me.VideoSRC.kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.api.Habilidade;

public class Worm implements Listener {
	public boolean danonaterra = true;

	@EventHandler
	public void onDamage(BlockDamageEvent event) {
		Player p = event.getPlayer();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("worm")) && (event.getBlock().getType() == Material.DIRT)) {
			event.getBlock().getLocation().distance(p.getWorld().getSpawnLocation());
			boolean drop = true;
			if (((CraftPlayer) p).getHealth() < 20.0D) {
				double hp = ((CraftPlayer) p).getHealth() + 1.0D;
				if (hp > 20.0D) {
					hp = 20.0D;
				}
				p.setHealth((int) hp);
				drop = false;
			} else if (p.getFoodLevel() < 20) {
				p.setFoodLevel(p.getFoodLevel() + 1);
				drop = false;
			} else {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30, 1), false);
			}
			event.getBlock().getWorld().playEffect(event.getBlock().getLocation(), Effect.STEP_SOUND,
					Material.DIRT.getId());
			event.getBlock().setType(Material.AIR);
			if (drop) {
				event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation().add(0.5D, 0.0D, 0.5D),
						new ItemStack(Material.DIRT));
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if ((this.danonaterra) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)
				&& ((event.getEntity() instanceof Player))) {
			Player p = (Player) event.getEntity();
			if (Habilidade.getAbility(p).equalsIgnoreCase("worm")) {
				Location loc = event.getEntity().getLocation();
				boolean dirt = false;
				for (float x = -0.35F; (x <= 0.35F) && (!dirt); x += 0.35F) {
					for (float z = -0.35F; (z <= 0.35F) && (!dirt); z += 0.35F) {
						Block b = loc.clone().add(x, -1.0D, z).getBlock();
						if (b.getType() == Material.DIRT) {
							dirt = true;
						}
					}
				}
				if (dirt) {
					event.setCancelled(true);
				}
			}
		}
	}
}
