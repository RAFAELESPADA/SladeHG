package me.VideoSRC.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.VideoSRC.Main;

public class KangarooPreGame implements Listener {
	public static boolean Kangaroo = false;
	ArrayList<Player> kangaroo = new ArrayList();
	ArrayList<Player> cos = new ArrayList();
	private HashMap<Player, Integer> jumped = new HashMap();

	@EventHandler
	public void interact(PlayerInteractEvent event) {
		Player Player = event.getPlayer();
		if (Main.PreGame) {
			if (Kangaroo) {
				if (Player.getItemInHand().getType() == Material.FIREWORK) {
					event.setCancelled(true);
					if ((!this.cos.contains(Player)) && (!this.jumped.containsKey(Player))) {
						if (!Player.isSneaking()) {
							if (!((CraftPlayer) Player).getHandle().onGround) {
								this.jumped.put(Player, Integer.valueOf(1));
								Player.setVelocity(
										new Vector(Player.getVelocity().getX(), 1.0D, Player.getVelocity().getZ()));
							} else {
								Player.setVelocity(
										new Vector(Player.getVelocity().getX(), 1.0D, Player.getVelocity().getZ()));
							}
						} else if (!((CraftPlayer) Player).getHandle().onGround) {
							Player.setVelocity(Player.getLocation().getDirection().multiply(1.2D));
							Player.setVelocity(
									new Vector(Player.getVelocity().getX(), 0.5D, Player.getVelocity().getZ()));
							this.jumped.put(Player, Integer.valueOf(1));
						} else {
							Player.setVelocity(Player.getLocation().getDirection().multiply(1.2D));
							Player.setVelocity(
									new Vector(Player.getVelocity().getX(), 0.5D, Player.getVelocity().getZ()));
						}
					}
				}
			} else if (Player.getItemInHand().getType() == Material.FIREWORK) {
				return;
			}
		}
	}

	@EventHandler
	public void landed(PlayerMoveEvent e) {
		if ((e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
				&& (this.jumped.containsKey(e.getPlayer()))) {
			this.jumped.remove(e.getPlayer());
		}
	}

	public boolean isOnGround(Player p) {
		Location l = p.getLocation();
		l = l.add(0.0D, -1.0D, 0.0D);
		return l.getBlock().getState().getTypeId() != 0;
	}
}
