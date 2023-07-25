package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;

public class CMDSpecTp implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (Main.Watch.contains(p.getName())) {
			if (args.length == 0) {
				p.sendMessage("§eUse: /ir <jogador>");
				return true;
			}
			if (!p.hasPermission("role.vip")) {
				p.sendMessage(Strings.perm);
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage("§eJogador offline ou invalido!");
				return true;
			}
			p.teleport(target.getLocation());
			p.sendMessage("§eVoce foi teleportado para: §c" + target.getName());
			return true;
		}
		return true;
	}
}
