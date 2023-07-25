package me.VideoSRC.borda;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import me.VideoSRC.Main;

public class WorldBorder {
	private static Integer shed_id = null;
	private static HashMap<Player, Location> locations = new HashMap();
	public static HashMap<BorderType, Border> BORDERS = new HashMap();

	private static boolean inBorderCheck(Location checkHere, BorderType t) {
		if (!BORDERS.containsKey(t)) {
			return true;
		}
		Border border = (Border) BORDERS.get(t);
		if (checkHere.getX() > border.radius) {
			return false;
		}
		if (checkHere.getZ() > border.radius) {
			return false;
		}
		if (checkHere.getX() < -border.radius) {
			return false;
		}
		if (checkHere.getZ() < -border.radius) {
			return false;
		}
		return true;
	}

	public static boolean inBorder(Location c, BorderType t) {
		if (t == BorderType.STOP) {
			return inBorderCheck(c, BorderType.STOP);
		}
		if (t == BorderType.WARN) {
			if ((!inBorderCheck(c, BorderType.WARN)) && (inBorderCheck(c, BorderType.STOP))) {
				return false;
			}
			return true;
		}
		if (t == BorderType.SHRINK) {
			if (BORDERS.containsKey(BorderType.SHRINK)) {
				return inBorderCheck(c, BorderType.SHRINK);
			}
			return true;
		}
		return true;
	}

	public static void WorldBorderMove() {
		shed_id = Integer
				.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
					public void run() {
						for (Player p : Bukkit.getOnlinePlayers()) {
							if (!WorldBorder.inBorder(p.getLocation(), BorderType.STOP)) {
								p.sendMessage("§cVoce esta no forcefield!");
								if (Main.PreGame) {
									if (p.isInsideVehicle()) {
										p.getVehicle().eject();
									}
									if ((WorldBorder.locations.containsKey(p)) && (WorldBorder
											.inBorder((Location) WorldBorder.locations.get(p), BorderType.STOP))) {
										p.teleport((Location) WorldBorder.locations.get(p));
									}
								} else {
									EntityDamageEvent entitydamage = new EntityDamageEvent(p,
											EntityDamageEvent.DamageCause.CUSTOM, 1.0D);
									if ((entitydamage instanceof Player)) {
										((Player) entitydamage.getEntity()).damage(1.0D);
									}
									Bukkit.getPluginManager().callEvent(entitydamage);
								}
							} else if ((Main.PreGame) && (!WorldBorder.inBorder(p.getLocation(), BorderType.WARN))) {
								p.sendMessage("§cVoce esta no forcefield, volte!");
							}
						}
					}
				}, 0L, 40L));
	}

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
	}
}
