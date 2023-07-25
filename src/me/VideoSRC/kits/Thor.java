package me.VideoSRC.kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class Thor implements Listener {
	public static List<Location> explodir = new ArrayList();
	public static HashMap<Player, Long> cooldown = new HashMap();
	public int cd = 5;
	public String cooldownMessage1 = "Voce tem que esperar para usar novamente";
	public boolean doNetherackAndFire = true;
	private transient HashMap<String, Long> lastThored = new HashMap();
	public boolean protectThorer = true;
	public int thorItemId = Material.WOOD_AXE.getId();

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if (((event.getDamager() instanceof LightningStrike)) && ((event.getEntity() instanceof Player))
				&& (event.getDamager().hasMetadata("DontHurt")) && (((Player) event.getEntity()).getName()
						.equals(((MetadataValue) event.getDamager().getMetadata("DontHurt").get(0)).value()))) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void thorNetherExplode(LightningStrikeEvent e) {
		if (e.getLightning().getLocation().getBlock().getType() == Material.NETHERRACK) {
			e.getLightning().getWorld().createExplosion(e.getLightning().getLocation(), 3.5F);
			e.getLightning().getLocation().getBlock().setType(Material.FIRE);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = event.getPlayer();
			Block block = event.getClickedBlock();
			Block hbloc = block.getLocation().getWorld().getHighestBlockAt(block.getLocation());
			if ((Habilidade.getAbility(p).equalsIgnoreCase("thor")) && (event.getItem() != null)
					&& (event.getItem().getTypeId() == this.thorItemId)) {
				if ((!this.lastThored.containsKey(p.getName())) ||

						(((Long) this.lastThored.get(p.getName())).longValue() < System.currentTimeMillis())) {
					this.lastThored.put(p.getName(), Long.valueOf(System.currentTimeMillis() + this.cd * 1000));
					if (this.doNetherackAndFire) {
						Main.blockf.contains(event.getClickedBlock());
						if (event.getClickedBlock().getType() != Material.BEDROCK) {
							hbloc.getRelative(BlockFace.UP).setType(Material.FIRE);
							if (hbloc.getY() >= 80) {
								hbloc.setType(Material.NETHERRACK);
								hbloc.getRelative(BlockFace.UP).setType(Material.FIRE);
							}
						} else {
							p.sendMessage("Voce nao pode transformar blocos do forcefield");
						}
					}
					LightningStrike strike = p.getWorld()
							.strikeLightning(p.getWorld().getHighestBlockAt(event.getClickedBlock().getLocation())
									.getLocation().clone().add(0.0D, 0.0D, 0.0D));
					if (this.protectThorer) {
						strike.setMetadata("DontHurt", new FixedMetadataValue(Main.plugin, p.getName()));
					}
				} else {
					p.sendMessage(this.cooldownMessage1);
				}
			}
		}
	}
}
