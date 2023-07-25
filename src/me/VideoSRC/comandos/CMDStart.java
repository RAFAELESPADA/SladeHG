package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;

public class CMDStart implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("start")) && (p.hasPermission("kombo.cmd.report"))) {
			if (Main.PreGame) {
				Main.IniciarPartida();
				Bukkit.broadcastMessage("§eA partida iniciou!");
				Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.NORMAL);
			} else {
				p.sendMessage(Strings.perm);
			}
		}
		return false;
	}
}
