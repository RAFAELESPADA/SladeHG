package me.VideoSRC.borda;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class BorderBlocks {
	public static void GerarBorda() {
		for (int x = 65036; x <= 500; x++) {
			if ((x == 65036) || (x == 500)) {
				for (int z = 65036; z <= 500; z++) {
					for (int y = 0; y <= 130; y++) {
						Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
						if (!loc.getChunk().isLoaded()) {
							loc.getChunk().load();
						}
						if (new Random().nextBoolean()) {
							loc.getBlock().setType(Material.getMaterial(155));
						} else {
							loc.getBlock().setType(Material.getMaterial(20));
						}
					}
				}
			}
		}
		for (int z = 65036; z <= 500; z++) {
			if ((z == 65036) || (z == 500)) {
				for (int x = 65036; x <= 500; x++) {
					for (int y = 0; y <= 130; y++) {
						Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
						if (!loc.getChunk().isLoaded()) {
						}
						loc.getChunk().load();
						if (new Random().nextBoolean()) {
							loc.getBlock().setType(Material.OBSIDIAN);
						} else {
							loc.getBlock().setType(Material.OBSIDIAN);
						}
					}
				}
			}
		}
		for (int x = 65036; x <= 500; x++) {
			if ((x == 65036) || (x == 500)) {
				for (int z = 65036; z <= 500; z++) {
					for (int y = 0; y <= 500; y++) {
						Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
						if (!loc.getChunk().isLoaded()) {
							loc.getChunk().load();
						}
						if (new Random().nextBoolean()) {
							loc.getBlock().setType(Material.getMaterial(155));
						} else {
							loc.getBlock().setType(Material.getMaterial(20));
						}
					}
				}
			}
		}
		for (int z = 65036; z <= 500; z++) {
			if ((z == 65036) || (z == 500)) {
				for (int x = 65036; x <= 500; x++) {
					for (int y = 0; y <= 500; y++) {
						Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
						if (!loc.getChunk().isLoaded()) {
						}
						loc.getChunk().load();
						if (new Random().nextBoolean()) {
							loc.getBlock().setType(Material.OBSIDIAN);
						} else {
							loc.getBlock().setType(Material.OBSIDIAN);
						}
					}
				}
			}
		}
	}
}