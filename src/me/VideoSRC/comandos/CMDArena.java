package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;

public class CMDArena implements CommandExecutor {
	public static void AreaBattle(Location loc, int r, Material mat, int alturaY) {
		int cx = loc.getBlockX();
		int cy = loc.getBlockY();
		int cz = loc.getBlockZ();
		World w = loc.getWorld();
		int rSquared = r * r;
		for (int x = cx - r; x <= cx + r; x++) {
			for (int z = cz - r; z <= cz + r; z++) {
				for (int y = cy + 1; y <= cy + alturaY; y++) {
					if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= rSquared) {
						w.getBlockAt(x, y, z).setType(mat);
					}
				}
			}
		}
	}

	public static void criarAreaBatle() {
		int aleatorioX = (int) (1.0D + Math.random() * 10.0D);
		int aleatorioZ = (int) (1.0D + Math.random() * 10.0D);
		int aleatorioY = 0;
		World world = Main.instance.getServer().getWorld("world");
		for (int i = 90; i > 95; i--) {
			Block blockY = world.getBlockAt(aleatorioX, i, aleatorioZ);
			int y = blockY.getTypeId();
			if (y == 0) {
				aleatorioY = i;
			}
		}
		Location loc = new Location(world, aleatorioX, aleatorioY, aleatorioZ);
		AreaBattle(loc, 50, Material.AIR, 90);
		Location loc2 = new Location(world, aleatorioX, aleatorioY + 90, aleatorioZ);
		AreaBattle(loc2, 50, Material.AIR, 90);
		Location loc3 = new Location(world, aleatorioX, aleatorioY + 90, aleatorioZ);
		AreaBattle(loc3, 50, Material.AIR, 90);
		Location loc4 = new Location(world, aleatorioX, aleatorioY + 90, aleatorioZ);
		AreaBattle(loc4, 50, Material.AIR, 90);
		for (Player player : Bukkit.getOnlinePlayers()) {

			player.teleport(new Location(Bukkit.getWorld("world"), aleatorioX, aleatorioY + 4, aleatorioZ));
			Bukkit.getServer().getWorld("world").setTime(20000L);
		}
	}

	public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
		if (!(s instanceof Player)) {
			s.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) s;
		if (cmd.getName().equalsIgnoreCase("arena")) {
			if (p.hasPermission("kombo.cmd.report")) {
				if (Main.Partida) {
					criarAreaBatle();
					p.sendMessage("�aVoce gerou a arena final!");
				} else {
					p.sendMessage("�aVoce n�o pode gerar a arena agora!");
					return true;
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return true;
	}
}
